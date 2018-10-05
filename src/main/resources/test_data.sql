use school_library;

insert into books(name,author,genre,country) values ('The 120 Days of Sodom',
'Marquis de Sade','novel','France');
insert into books(name,author,genre,country) values ('War and Peace',
'Tolstoy L.N.','novel','Russia');
insert into books(name,author,genre,country) values ('Alice in Wonderland)',
'Lewis Carroll','fiction','UK');

insert into pupils (name,grade) values ('Knize K.','11A');
insert into pupils (name,grade) values ('Taiga A.','10B');

insert into pupils_books (book_id, pupil_id) values (1,1);
insert into pupils_books (book_id, pupil_id) values (2,1);
insert into pupils_books (book_id, pupil_id) values (3,2);