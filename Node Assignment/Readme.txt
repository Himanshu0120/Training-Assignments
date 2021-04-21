Node Js Blog Application--:

To run the application type npm start in the terminal of the project directory.
The application will run on port 5000.
The database used in this assignment is MySql.

Run the following code to create the database and the table --:
"
create database blog;
use blog;
create table blogs(title varchar(50), content text , id int primary key auto_increment);
"

if there is an connection error with the database try running the following code in mysql --:

"
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
flush privileges;
"