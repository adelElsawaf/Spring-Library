
CREATE TABLE public.users (
	user_id uuid NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"password" varchar(255) NULL,
	"type" int4 NULL,
	user_name varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (user_id)
);
commit