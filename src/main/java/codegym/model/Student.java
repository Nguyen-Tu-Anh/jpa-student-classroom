package codegym.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;
    private int age;

    @ManyToOne
    private Classroom classRoom;

    public Student() {
    }

    public Student(String name, String img, int age, Classroom classRoom) {
        this.name = name;
        this.img = img;
        this.age = age;
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classroom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Classroom classRoom) {
        this.classRoom = classRoom;
    }
}