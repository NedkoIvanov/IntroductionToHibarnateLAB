import entities.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args){
    EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
    EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
    List<Employee> empInfo = entity.createQuery(" SELECT e FROM Employee AS e " +
            "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services') " +
                    "ORDER BY e.id", Employee.class).getResultList();
        for(Employee e : empInfo){
            double salary = e.getSalary().doubleValue();
            salary = salary + salary * (12 / 100);
            e.setSalary(new BigDecimal(salary));
            System.out.println(e.getFirstName() + " " + e.getLastName() + " ($" +
                    e.getSalary() + ")");
    }
        entity.getTransaction().commit();
        entity.close();

    }
}
