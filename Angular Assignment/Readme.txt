This assignment is in two parts : 
Express Rest Api
Angular Frontend

For running the express part first create the required database and table in MySql and the query for that is :

create database blogs;
use blogs;
create table blog(title varchar(100), content text,id int primary key auto_increment);


For running the Angular part first install the modules using--   npm i

Run both the appication and the api using--   npm start 
and the angular app will run on port 4200

Express part is required for the angular app to work so run both the parts