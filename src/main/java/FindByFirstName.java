import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FindByFirstName {
    public static void main(String[] args){
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        Scanner s = new Scanner(System.in);
        String letters = s.nextLine().toUpperCase().trim();
        List<Employee> emp = entity.createQuery("select e from Employee e where e.firstName like :p",Employee.class)
                .setParameter("p",letters + "%")
                .getResultList();
        for(Employee e : emp){
            System.out.println(e.getFirstName() + " " + e.getLastName()
                + " - " + e.getDepartment().getName() + " ($" + e.getSalary() + ")");
        }
        entity.getTransaction().commit();
        entity.close();
    }

}
