package DockerExample.Entity;

import javax.persistence.*;

@Entity
@Table(name = "DEP")
public class Department {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;
}
