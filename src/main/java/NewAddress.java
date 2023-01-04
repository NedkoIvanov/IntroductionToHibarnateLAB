import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class NewAddress {
    public static void main(String[] args) {
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        Scanner s = new Scanner(System.in);
        String family = s.nextLine();
        Address address = new Address();
        address.setText("Vitoshka 15");
        Town town = new Town();
        town.setName("sofia");
        address.setTown(town);
        List<Employee> emp = entity.createQuery("Select e from Employee e", Employee.class).getResultList();
        for(Employee e : emp){
            if(e.getLastName().equals(family)){
                entity.persist(e);
            }
        }
        entity.getTransaction().commit();
        entity.close();

    }
}
