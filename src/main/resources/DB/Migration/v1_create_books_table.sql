create table books(
book_id uuid primary key,
book_name varchar(100) not null,
author_name varchar(100) not null,
category varchar(100) not null
)
commit