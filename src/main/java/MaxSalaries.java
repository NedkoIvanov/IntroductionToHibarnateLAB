import entities.Employee;
import entities.Project;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;


public class MaxSalaries {
    public static void main(String[] args){
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        List<Employee> emp = entity.createQuery("select e from  Employee e where e.salary not between 30000 and 70000 " +
                        "group by e.department order by e.salary desc", Employee.class)
                .getResultList();

        for(Employee e : emp){
            System.out.println(e.getDepartment().getName() + " - " + e.getSalary().doubleValue());
        }

        entity.getTransaction().commit();
        entity.close();
    }

}
