CREATE TABLE users
(
    user_id bigint NOT NULL,
    name character varying(200) COLLATE pg_catalog."default",
    nickname character varying(20) COLLATE pg_catalog."default",
    active boolean default false,
    blockeed boolean default false,

    CONSTRAINT users_pkey PRIMARY KEY (user_id)
)
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to xp4dev_estagio;