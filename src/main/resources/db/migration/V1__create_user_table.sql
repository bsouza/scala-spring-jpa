CREATE SEQUENCE user_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
CACHE 1;

create table users
(
    id long not null,
    name text,
    version long
);

ALTER TABLE users ADD CONSTRAINT pk_user PRIMARY KEY (id);
