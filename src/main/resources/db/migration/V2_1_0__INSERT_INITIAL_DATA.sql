INSERT INTO users
VALUES ('1','Albert','White','$2a$12$/X.Urj8UxH.djWPeg2OvgujRHw440I1I79VUuOdhH/r9Pq0WeZ61q','albertW','2','1');

INSERT INTO users
VALUES ('2','Bill','Jackson','$2a$12$UFRk/sNYuSFKrwII9bkf/.hsBWd76Qz2KoQNFgYL7nPQB4yXmmGVa','billJ','1','1');

INSERT INTO users
VALUES ('3','Cliff','Armstrong','$2a$12$C5d4Q8rxRjkRAZzrHXRk.uBTLy13DNlKPx2I1NoONL1gWisEMvQaS','cliffA','2','1');

INSERT INTO users
VALUES ('4','Jeffry','Doll','$2a$12$9mY4JjENJSApq8IzXiR9g.EAMPxMtY/2iTIlvw40HjDFhh1Rusao2','jeffD','1','1');

INSERT INTO users
VALUES ('5','John','Willson','$2a$12$7bhiEHI5ywupiJuHelGEFesF8gYGddwHiHbO8anvdLHLRiYRWC6ZS','johnW','2','1');

INSERT INTO users
VALUES ('6','George','Pirson','$2a$12$RXURTQrlo69Bz74HI2ket.fOWRnzgcuVLysHZFTZVOhWCKbC2uwyy','georgeP','1','1');

INSERT INTO users
VALUES ('7','Richard','Rockwell','$2a$12$z/74HcErq3NTTXowOarIluzqD7oSWGnq0ksKQ7ZEvOPHOdDoqk7YO','richardR','2','1');

INSERT INTO users
VALUES ('8','Samuel','Torston','$2a$12$JbAt/9t.BO6U4gLn0FZaqOuxiorn5j3TRMrLNvr9RW/kaqsreHX/C','samuelT','1','1');

INSERT INTO users
VALUES ('9','Joe','Samwell','$2a$12$FMLTEayHaJf2uM1aA69FA.mIY4ik8qr.AVrwN8jH/bZYGQMNyNfSy','joeS','2','1');

INSERT INTO users
VALUES ('10','Lewis','Nickman','$2a$12$K4XYZjb8Ely2cJmGjuHpHuiim/4QzxC2zJZfEiG8x9fbvAxx0WNwe','lewisN','1','1');


INSERT INTO tasks
VALUES ('1','Understand (define) the problem and what the solution must do','Analysis and Specification');

INSERT INTO tasks
VALUES ('2','Develop a comprehensive unambiguous logical sequence of steps to solve the problem','Algorithm Development');

INSERT INTO tasks
VALUES ('3','Follow steps closely (manually) to see if solution works','Verification of Algorithm');

INSERT INTO tasks
VALUES ('10','Write an algorithm and draw a flowchart that will calculate the roots of a quadratic equation. Hint: d = sqrt ( ), and the roots are: x1 = ( b + d)/2a and x2 = ( b d)/2a 10','Algorithm Development');

INSERT INTO tasks
VALUES ('4','Translate algorithm into a program written in a programming language','Program Development');

INSERT INTO tasks
VALUES ('8','Write an algorithm and draw a flowchart to convert the length in feet to centimeter','Algorithm Development');

INSERT INTO tasks
VALUES ('5','Test program for syntactical and logical errors. Fix the errors.','Program Testing');

INSERT INTO tasks
VALUES ('6','Modify the program to meet changing requirements','Maintain');

INSERT INTO tasks
VALUES ('7','Fix logout button','Program Testing');

INSERT INTO tasks
VALUES ('9','Write an algorithm and draw a flowchart that will read the two sides of a rectangle and calculate its area','Algorithm Development');

INSERT INTO teams
VALUES ('1','Discovery');

INSERT INTO teams
VALUES ('2','Execute');

INSERT INTO teams
VALUES ('3','Students');

INSERT INTO teams
VALUES ('4','Office');

INSERT INTO teams
VALUES ('5','Management');

INSERT INTO user_teams
VALUES ('1','1');

INSERT INTO user_teams
VALUES ('2','1');

INSERT INTO user_teams
VALUES ('3','2');

INSERT INTO user_teams
VALUES ('4','2');

INSERT INTO user_teams
VALUES ('5','3');

INSERT INTO user_teams
VALUES ('6','3');

INSERT INTO user_teams
VALUES ('7','4');

INSERT INTO user_teams
VALUES ('8','5');

INSERT INTO user_tasks
VALUES ('1','10');

INSERT INTO user_tasks
VALUES ('2','9');

INSERT INTO user_tasks
VALUES ('3','8');

INSERT INTO user_tasks
VALUES ('4','7');

INSERT INTO user_tasks
VALUES ('5','6');

INSERT INTO user_tasks
VALUES ('6','5');

INSERT INTO team_tasks
VALUES ('1','1');

INSERT INTO team_tasks
VALUES ('2','2');

INSERT INTO team_tasks
VALUES ('3','9');

INSERT INTO team_tasks
VALUES ('4','10');

INSERT INTO status
VALUES ('1','Active');

INSERT INTO roles
VALUES ('1','USER');

INSERT INTO roles
VALUES ('2','ADMIN');

INSERT INTO role_permissions
VALUES ('1','1');

INSERT INTO role_permissions
VALUES ('1','2');

INSERT INTO role_permissions
VALUES ('2','2');

INSERT INTO permissions
VALUES ('1','READ');

INSERT INTO permissions
VALUES ('2','WRITE');