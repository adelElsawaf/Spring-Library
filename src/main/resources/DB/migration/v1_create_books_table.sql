create table books(
book_id uuid primary key,
book_name varchar(100) not null,
author_name varchar(100) not null,
category varchar(100) not null
)
alter table books
add column user_id uuid;
alter table books add constraint fk_user_id Foreign key(user_id)  references users(user_id);
alter table books
add column price numeric (5,2) default 0;
alter table books
drop column user_id_who_rented_book;
alter table books
drop column user_id_who_rented_book;
alter table books add constraint fk_user_id Foreign key(renter_id)  references users(user_id);
commit