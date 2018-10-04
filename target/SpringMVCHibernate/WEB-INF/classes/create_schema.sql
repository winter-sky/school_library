
use school_library;

drop table if exists pupils_books;
drop table if exists pupils;
drop table if exists books;

create table books
(
  book_id integer NOT NULL AUTO_INCREMENT,
  name varchar(512) NOT NULL,
  author varchar (512) NOT NULL,
  genre varchar (512) NOT NULL,
  country varchar (512) NOT NULL,
  CONSTRAINT book_pk PRIMARY KEY (book_id)
);

CREATE INDEX name ON books(name);
CREATE INDEX author ON books(author);
CREATE INDEX genre ON books(genre);
CREATE INDEX country ON books(country);

create table pupils
(
  pupil_id integer NOT NULL AUTO_INCREMENT,
  name varchar(512) NOT NULL,
  grade varchar (4) NOT NULL,
  CONSTRAINT pupil_pk PRIMARY KEY (pupil_id)
);

create table pupils_books
(
  id integer NOT NULL AUTO_INCREMENT,
  book_id integer NOT NULL,
  pupil_id integer NOT NULL,
  date_taken datetime DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT id_pk PRIMARY KEY (id),
  FOREIGN KEY (book_id) REFERENCES books(book_id),
  FOREIGN KEY (pupil_id) REFERENCES pupils(pupil_id)
);
