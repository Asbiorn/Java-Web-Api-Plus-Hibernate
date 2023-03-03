
DROP TABLE IF EXISTS tb_character;
DROP TABLE IF EXISTS tb_franchise;
DROP TABLE IF EXISTS tb_movie;

CREATE TABLE tb_franchise(
	franchise_id serial PRIMARY KEY,
        franchise_name varchar(50) NOT NULL,
	franchise_description varchar(50) NOT NULL,
);
CREATE TABLE tb_character(
	character_id serial  PRIMARY KEY,
        character_fullname varchar(100) NOT NULL,
        character_alias varchar(100),
        character_gender varchar(50) NOT NULL,-- should be an enum
        character_picture_url varchar(255)

);

CREATE TABLE tb_movie(
	movie_id serial PRIMARY KEY,
        movie_title varchar(100) NOT NULL,
        movie_genre varchar(100) NOT NULL,
        movie_release_year varchar(4) NOT NULL, --should be an int! maybe more than 4 is needed if we time stamp
	movie_director varchar(50) NOT NULL,
	movie_picture_url varchar(255),
	movie_trailer_url varchar(255)
);
