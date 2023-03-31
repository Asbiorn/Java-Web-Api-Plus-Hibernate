
INSERT INTO tb_character VALUES (1,'Mithrandir','Gandalf the grey','MALE','https://static.wikia.nocookie.net/lotr/images/e/e7/Gandalf_the_Grey.jpg/revision/latest/scale-to-width-down/350?cb=20121110131754');

INSERT INTO tb_franchise VALUES (1, 'about a powerful ring embarking on a journey home, to find its master' ,'Lord of the Rings');

INSERT INTO tb_movie (director, genre, picture_url,release_year,title, trailer_url,franchise_id)  VALUES ('Peter Jackson','Fantasy','https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_.jpg',2001,'The Lord of the Rings: The Fellowship of the Ring',null, 1);
INSERT INTO tb_movie (director, genre, picture_url,release_year,title, trailer_url,franchise_id)  VALUES ('Peter Jackson','Fantasy','https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_.jpg',2002,'The Lord of the Rings: The Two Towers',null, 1);

INSERT INTO character_movie (character_id, movie_id)  VALUES (1,1);
INSERT INTO character_movie (character_id, movie_id)  VALUES (1,2);