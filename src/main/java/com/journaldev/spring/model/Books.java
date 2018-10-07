package com.journaldev.spring.model;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

 /*   @ManyToOne//(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pupils_books",
            joinColumns = { @JoinColumn(name = "book"//,insertable = false,updatable = false
            )},//book_id исправила на book
            //в базе данных в связующей таблице
            inverseJoinColumns = { @JoinColumn(name = "pupil_id" //,insertable = false, updatable = false
            ) }
    )
    private Pupils pupil;*/

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


//    public Pupils getPupil() {
//        return pupil;
//    }
//
//    public void setPupil(Pupils pupil) {
//        this.pupil = pupil;
//    }
}
