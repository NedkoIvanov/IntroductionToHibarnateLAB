
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveObject {
    public static void main(String[] args) {
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        List<Town> townsInfo = entity.createQuery("select t from Town t",Town.class).getResultList();
        for(int i=0;i<townsInfo.size();i++){
            if(townsInfo.get(i).getName().length()<=5){
                String updated = townsInfo.get(i).getName().toUpperCase();
                townsInfo.get(i).setName(updated);
                entity.persist(townsInfo.get(i));
            }
        }
        for(Town town : townsInfo){
            System.out.println(town.getName());
        }
        entity.getTransaction().commit();
        entity.close();

    }
}