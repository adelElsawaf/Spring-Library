CREATE TABLE public.books (
	book_id uuid NOT NULL,
	author_name varchar(255) NULL,
	book_name varchar(255) NULL,
	category varchar(255) NULL,
	rent_price float8 NOT NULL,
	CONSTRAINT books_pkey PRIMARY KEY (book_id),
	CONSTRAINT books_un UNIQUE (book_name)
);
