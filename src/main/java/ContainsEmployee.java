import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {

    public static void main(String[] args){
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        Scanner s = new Scanner(System.in);
        String[] name = s.nextLine().split(" ");
        List<Employee> empInfo = entity.createQuery("select t from Employee t",Employee.class).getResultList();
        int counter = 0;
        for(Employee emp : empInfo){
            if(emp.getFirstName().equals(name[0]) && emp.getLastName().equals(name[1])){
                counter++;
            }
        }
        if(counter>0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        entity.getTransaction().commit();
        entity.close();
    }

}
