create table participants(
					 Participants_Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
					 Participants_Name VARCHAR(200),
					 Team_Name VARCHAR(200));
					 
create table matches(
					 Round_no INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
					 Team_Name VARCHAR(200),
					 First_Player VARCHAR(200),
					 First_Player_Point INT,
					 Second_Player VARCHAR(200),
					 Second_Player_Point INT);