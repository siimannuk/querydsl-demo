--liquibase formatted sql

--changeset initial_state:1

CREATE TABLE public.alignment (
  id serial PRIMARY KEY,
  name CHARACTER VARYING UNIQUE NOT NULL
);

CREATE TABLE public.publisher (
  id serial PRIMARY KEY,
  name CHARACTER VARYING UNIQUE NOT NULL
);

CREATE TABLE public.race (
  id serial PRIMARY KEY,
  name CHARACTER VARYING UNIQUE NOT NULL
);

CREATE TABLE public.superpower (
  id serial PRIMARY KEY,
  name CHARACTER VARYING UNIQUE NOT NULL
);

CREATE TABLE public.superhero (
  id serial PRIMARY KEY,
  name CHARACTER VARYING UNIQUE NOT NULL,
  gender CHARACTER VARYING NOT NULL,
  skin_color CHARACTER VARYING,
  eye_color CHARACTER VARYING,
  hair_color CHARACTER VARYING,
  height NUMERIC (10, 3) NOT NULL,
  weight NUMERIC (10, 3) NOT NULL,
  alignment_id INTEGER NOT NULL REFERENCES public.alignment(id),
  publisher_id INTEGER NOT NULL REFERENCES public.publisher(id),
  race_id INTEGER NOT NULL REFERENCES public.race(id)
);

CREATE TABLE public.superhero_has_superpower (
  superhero_id INTEGER NOT NULL REFERENCES public.superhero(id),
  superpower_id INTEGER NOT NULL REFERENCES public.superpower(id)
);
