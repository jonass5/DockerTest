package DockerExample;

import DockerExample.Entity.Department;
import DockerExample.Entity.Person;
import DockerExample.Repo.DepartmentRepository;
import DockerExample.Repo.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        PersonRepository repoAlt = new PersonRepository();

        DepartmentRepository drep = new DepartmentRepository();

        repoAlt.updatePerson(67, "Adelina", "Pitts");
        repoAlt.add("test321", "abc", 87);
        List<Person> list = repoAlt.getAll();
        Person p = repoAlt.getByID(5);
        repoAlt.removePerson(6);

//        drep.add("HR");
//        drep.add("TEST");
//        drep.add("TEST2");
//        drep.add("DEV");

        drep.remove(63);

        List<Department> departmentList = drep.getAll();

        Department department = drep.getByID(64);

        drep.update(64, "Sale");

        Department department2 = drep.getByID(64);
    }
}