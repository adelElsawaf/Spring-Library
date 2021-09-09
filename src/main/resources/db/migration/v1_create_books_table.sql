-- public.books definition

-- Drop table

-- DROP TABLE public.books;

CREATE TABLE public.books (
	book_id uuid NOT NULL,
	author_name varchar(255) NULL,
	book_name varchar(255) NULL,
	category varchar(255) NULL,
	renter_id uuid NULL,
	rent_price float8 NOT NULL,
	CONSTRAINT books_pkey PRIMARY KEY (book_id)
);


-- public.books foreign keys

ALTER TABLE public.books ADD CONSTRAINT fk_user_id FOREIGN KEY (renter_id) REFERENCES users(user_id);
commit