

CREATE TABLE public.books_rent_history (
	rent_id uuid NOT NULL,
	book_id uuid NULL,
	end_renting_date date NULL,
	rent_duration_in_days int8 NOT NULL,
	start_renting_date date NULL,
	user_id uuid NULL,
	rent_price float4 NOT NULL,
	CONSTRAINT books_rent_history_pkey PRIMARY KEY (rent_id)
);



ALTER TABLE public.books_rent_history ADD CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES books(book_id);
ALTER TABLE public.books_rent_history ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id);
commit