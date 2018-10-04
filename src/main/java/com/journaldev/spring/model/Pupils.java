package com.journaldev.spring.model;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "pupils")
public class Pupils {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pupil_id")
    private int pupilId;
    private String name;
    private String grade;

    @OneToMany(mappedBy = "pupil")
    private Set<Books> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPupilId() {
        return pupilId;
    }

    public void setPupilId(int pupilId) {
        this.pupilId = pupilId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

}
