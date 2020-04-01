package DockerExample.Repo;

import DockerExample.Entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DepartmentRepository {

    //Test

    @PersistenceContext
    EntityManager entityManager = Persistence.createEntityManagerFactory("dep_catalog").createEntityManager();


    public void add(String name) {
        entityManager.getTransaction().begin();

        Department department = new Department();
        department.setName(name);

        entityManager.persist(department);

        entityManager.getTransaction().commit();
    }

    public void remove(int id) {
        entityManager.getTransaction().begin();

        Department department = entityManager.find(Department.class, id);
        if (department != null)
            entityManager.remove(department);

        entityManager.getTransaction().commit();
    }

    public void update(int id, String newName) {
        entityManager.getTransaction().begin();

        Department department = entityManager.find(Department.class, id);
        entityManager.detach(department);

        department.setName(newName);

        entityManager.merge(department);

        entityManager.getTransaction().commit();
    }

    public Department getByID(int id) {
        entityManager.getTransaction().begin();

        Department department = entityManager.find(Department.class, id);

        entityManager.getTransaction().commit();
        return department;
    }

    public List<Department> getAll() {
        entityManager.getTransaction().begin();

        List<Department> depList = entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();

        entityManager.getTransaction().commit();
        return depList;
    }

}
