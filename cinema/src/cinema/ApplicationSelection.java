package cinema;

import java.util.List;
import jakarta.persistence.*;

import cinema.data.Pays;
import cinema.data.Artiste;
import cinema.data.Film;
import cinema.data.Video;
import cinema.jpa.EntitySingleton;

import jakarta.persistence.*;

public class ApplicationSelection {

    public static void main(String[] args) throws Exception {
		

        EntityManager em = EntitySingleton.getManager();
        
        em.getTransaction().begin();

        Query q;
        // placez votre code ici, entre le begin et le commit

        // requête : les films avec leur nombre d'acteurs

        System.out.println("\n\n\n qustion 1 : \n\n\n ");


        List<Object[]> res = em.createQuery(
                "SELECT f, COUNT(a) FROM Film f JOIN f.acteurs a GROUP BY f",
                Object[].class
        ).getResultList();

        for(Object[] r : res){
            System.out.println(r[0] + " -> " + r[1]);
        }


        // requête : les différentes oeuvres cinématographiques (Film et Reportage)

        System.out.println("\n\n\n qustion 2 : \n\n\n ");


        List<Object[]> res2 = em.createQuery(
                "SELECT v, TYPE(v) FROM Video v",
                Object[].class
        ).getResultList();

        for(Object[] r : res2){
            System.out.println(r[0] + " -> " + r[1]);
        }

        // requête : les artistes avec le nombre de films dans lesquels ils jouent qui ont joués dans plus de 6 films


        System.out.println("\n\n\n qustion 3 : \n\n\n ");


        List<Object[]> res3 = em.createQuery(
                "SELECT a, COUNT(f) FROM Artiste a JOIN a.filmsJoues f GROUP BY a HAVING COUNT(f) > 6",
                Object[].class
        ).getResultList();

        for(Object[] r : res3){
            System.out.println(r[0] + " -> " + r[1]);
        }

        // requête : les réalisateurs nés après 800


        System.out.println("\n\n\n qustion 4 : \n\n\n ");


        List<Object[]> res4 = em.createQuery(
                "SELECT v.realisateur.nom, v.realisateur.prenom FROM Video v WHERE v.realisateur.anneeNaissance > 800",
                Object[].class
        ).getResultList();

        for(Object[] r : res4){
            System.out.println(r[0] + " " + r[1]);
        }

        // requête : les Pays avec le nombre de Films

        System.out.println("\n\n\n qustion 5 : \n\n\n ");


        List<Object[]> res5 = em.createQuery(
                "SELECT p.nom, COUNT(f) FROM Film f JOIN f.pays p GROUP BY p.nom",
                Object[].class
        ).getResultList();

        for(Object[] r : res5){
            System.out.println(r[0] + " -> " + r[1]);
        }
      
        em.getTransaction().commit();
    }
}

