
create table public.album (
    albumId INTEGER PRIMARY KEY,
    artist character  varying ,
    dateRelease date,
    genre character  varying ,
    tracks INTEGER ,
    price numeric
);

drop sequence album_id_seq;

create sequence album_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;



create table public.application_user (
   user_id INTEGER PRIMARY KEY,
   username character  varying ,
   password character varying,
   is_admin boolean
);

drop sequence application_user_id_seq;

create sequence application_user_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483647
    start 1
    cache 100;