import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        List<Employee> empInfo = entity.createQuery("select e from Employee e where " +
                "order by e.salary , e.id",Employee.class).getResultList();
        for(Employee e : empInfo){
            if(e.getDepartment().getName().equals("Research and Development")){
                System.out.println(e.getFirstName() + " " + e.getLastName()
                + " from " + e.getDepartment().getName() + " - $" + e.getSalary());
            }
        }
        entity.getTransaction().commit();
        entity.close();

    }
}
