import entities.Employee;
import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class AddressesWithCount {
    public static void main(String[] args){
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        List<Address> address = entity.createQuery("select a from Address a order by a.employees.size desc , a.town.id",Address.class)
                        .setMaxResults(10).getResultList();
        for(Address a : address){
            System.out.println(a.getText() + ", " + a.getTown().getName() + ", " + a.getEmployees().size());
        }
        entity.getTransaction().commit();
        entity.close();
    }

}
