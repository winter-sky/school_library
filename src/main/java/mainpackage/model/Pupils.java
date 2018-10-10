package mainpackage.model;
import java.util.List;

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

    @OneToMany//(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pupils_books",
            joinColumns = { @JoinColumn(name = "pupil_id") },
            inverseJoinColumns = { @JoinColumn(name = "book") }
    )
    private List<Books> books;

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

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public void setBook (Books book){books.add(book);}

}
