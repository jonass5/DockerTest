package DockerExample.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "LASTNAME")
    private String Lastname;

    @Column(name = "FIRSTNAME")
    private String Firstname;

    @Column(name = "AGE")
    private int age;

    public Person(int personID, String lastname, String firstname, int age) {
        this.id = personID;
        this.Lastname = lastname;
        this.Firstname = firstname;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + id +
                ", Lastname='" + Lastname + '\'' +
                ", Firstname='" + Firstname + '\'' +
                ", age=" + age +
                '}';
    }


    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
