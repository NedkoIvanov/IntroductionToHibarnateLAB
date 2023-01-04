import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Latest10Projects {
    public static void main(String[] args){
        EntityManagerFactory ent = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entity = ent.createEntityManager();
        entity.getTransaction().begin();
        StringBuilder prj = new StringBuilder();
        entity.createQuery("select t from Employee t",Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> prj
                        .append("Project name: ").append(project.getName()).append(System.lineSeparator())
                        .append("\tProject Description: ").append(project.getDescription()).append(System.lineSeparator())
                        .append("\tProject Start Date: ").append(project.getStartDate()).append(System.lineSeparator())
                        .append("\tProject End Date: ").append(project.getEndDate()).append(System.lineSeparator()));
        entity.getTransaction().commit();
        entity.close();
    }

}


