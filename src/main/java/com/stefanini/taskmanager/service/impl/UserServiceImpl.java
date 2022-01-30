package com.stefanini.taskmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.stefanini.taskmanager.converter.UserConverter;
import com.stefanini.taskmanager.dao.impl.TeamDAOImpl;
import com.stefanini.taskmanager.dao.impl.UserDAOImpl;
import com.stefanini.taskmanager.entity.SecurityUser;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.Team;
import com.stefanini.taskmanager.entity.User;
import com.stefanini.taskmanager.entity.dto.UserDetailsDto;
import com.stefanini.taskmanager.entity.dto.UserDto;
import com.stefanini.taskmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    final static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    private final UserDAOImpl userDAO;
    private final TeamDAOImpl teamDAO;
    private final UserConverter converter;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO, UserConverter converter, TeamDAOImpl teamDAO) {
        this.userDAO = userDAO;
        this.converter = converter;
        this.teamDAO = teamDAO;
    }


    @Override
    public UserDto getUserById(Long id) {
        return converter.userModelToUserDto(userDAO.getById(id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public List<UserDto> getAllUsers() throws HibernateException {
        List<UserDto> users = converter.userModelToUserDto(userDAO.getAll());
        if (users == null) throw new HibernateException("Users == null");
        return users;
    }

    @Override
    public UserDetailsDto getUserDetailsById(Long id) throws Exception {
        try {
            User user = userDAO.getById(id);
            return converter.userModelToUserDetailsDto(user);
        } catch (Exception e) {
            throw new Exception("Error in getUserDetailsById");
        }
    }

    @Override
    public User saveUser(User user) throws Exception {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setPassword(bcrypt.encode(user.getPassword()));
        return userDAO.add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User by username " + username + " not found");
        return SecurityUser.fromUser(user);
    }

    @Override
    public User addTaskToUser(Task task, long id) {
        User user = userDAO.getById(id);
        Task existingTask = user.getTasks()
                .stream()
                .filter(existingTasks -> existingTasks.getId().equals(task.getId()))
                .findAny().orElse(null);

        if (existingTask == null) {
            user.addTask(task);
        }

        return userDAO.update(user);
    }

    @Override
    public User updateUserById(User userInfo) {
        User user = userDAO.getById(userInfo.getId());
        if (user == null) throw new UsernameNotFoundException("User not found");
        if (!userInfo.getUserName().isEmpty())
            user.setUserName(userInfo.getUserName());
        if (!userInfo.getFirstName().isEmpty())
            user.setFirstName(userInfo.getFirstName());
        if (!userInfo.getLastName().isEmpty())
            user.setLastName(userInfo.getLastName());
        return userDAO.update(user);
    }

    @Override
    public User addUserToTeam(User userInfo, String teamName) {
        Team team = teamDAO.getTeamByName(teamName);
        User user = userDAO.getById(userInfo.getId());
        user.addTeam(team);
        return userDAO.update(user);
    }

    @Override
    public void deleteUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        userDAO.remove(user);
    }

    @Override
    public void deleteUserByID(Long id) {
        userDAO.removeById(id);
    }
}