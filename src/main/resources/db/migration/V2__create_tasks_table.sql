CREATE SEQUENCE task_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
CACHE 1;

create table tasks
(
  id long not null,
  name text,
  description text,
  version long,
  user_id long references users (id)
);

ALTER TABLE tasks ADD CONSTRAINT pk_task PRIMARY KEY (id);
