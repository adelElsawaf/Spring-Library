create table users (
user_id uuid primary key ,
password varchar(100) not null,
first_name varchar(100) not null,
last_name varchar(100) not null,
user_type varchar(100) not null
)
commit