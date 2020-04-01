package DockerExample;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        Application.launch(MainFX.class, args);

//        PersonRepository repoAlt = new PersonRepository();
//        repository = repoAlt;

//        DepartmentRepository drep = new DepartmentRepository();
//
//        repoAlt.updatePerson(67, "Adelina", "Pitts");
//        repoAlt.add("test321", "abc", 87);
//        List<Person> list = repoAlt.getAll();
//        Person p = repoAlt.getByID(5);
//        repoAlt.removePerson(6);

//        drep.add("HR");
//        drep.add("TEST");
//        drep.add("TEST2");
//        drep.add("DEV");

//        drep.remove(63);
//
//        List<Department> departmentList = drep.getAll();
//
//        Department department = drep.getByID(64);
//
//        drep.update(64, "Sale");
//
//        Department department2 = drep.getByID(64);
    }
}