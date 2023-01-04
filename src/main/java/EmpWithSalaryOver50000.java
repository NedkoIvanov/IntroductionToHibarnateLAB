import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class EmpWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        List<Employee> emps = entity.createQuery("select e from Employee e where e.salary > 50000 ",Employee.class).getResultList();
        for(Employee emp : emps){
            System.out.println(emp.getFirstName());
        }
        entity.getTransaction().commit();
        entity.close();

    }
}

