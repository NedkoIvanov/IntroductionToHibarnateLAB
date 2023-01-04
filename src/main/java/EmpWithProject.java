import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class EmpWithProject {
    public static void main(String[] args){
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        Scanner s = new Scanner(System.in);
        Integer id = Integer.parseInt(s.nextLine());
        Employee emp = entity.createQuery("select e from Employee e where id = :id",Employee.class)
                .setParameter("id",id)
                .getSingleResult();
        List<String> names = new ArrayList<>();
       for(Project project : emp.getProjects()){
           names.add(project.getName());
       }
       Collections.sort(names);
       System.out.print(emp.getFirstName() + " " + emp.getLastName() + " - ");
       for(String name : names){
           System.out.println(name);
       }
        entity.getTransaction().commit();
        entity.close();
    }


}
