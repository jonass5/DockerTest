package DockerExample.Repo;

import DockerExample.Entity.Department;
import DockerExample.Entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonRepoAlt {

    @PersistenceContext
    EntityManager entityManager = Persistence.createEntityManagerFactory("person_catalog").createEntityManager();
    @PersistenceContext
    EntityManager depEntityManager = Persistence.createEntityManagerFactory("dep_catalog").createEntityManager();

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public void add(String firstname, String lastname, int age) {
        entityManager.getTransaction().begin();

        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setAge(age);

        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    public List<Person> getAll() {
        entityManager.getTransaction().begin();

        List<Person> list = entityManager.createQuery("SELECT a FROM Person a", Person.class).getResultList();

        entityManager.getTransaction().commit();
        return list;
    }

    public Person getByID(int id) {
        entityManager.getTransaction().begin();

        Person p = entityManager.find(Person.class, id);

        entityManager.getTransaction().commit();
        return p;
    }

    public void removePerson(int id) {
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, id);
        if (person != null)
            entityManager.remove(person);

        entityManager.getTransaction().commit();
    }

    public void updatePerson(int id, String newFName, String newLName) {
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, id);

        entityManager.detach(person);

        person.setLastname(newLName);
        person.setFirstname(newFName);

        entityManager.merge(person);

        entityManager.getTransaction().commit();
    }
}