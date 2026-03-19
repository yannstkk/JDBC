package cinema;

import java.util.List;

import cinema.data.Pays;
import cinema.data.Artiste;
import cinema.data.Film;
import cinema.data.Video;
import cinema.jpa.EntitySingleton;

import jakarta.persistence.*;

public class ApplicationChargement {

    public static void main(String[] args) throws Exception {
		

        EntityManager em = EntitySingleton.getManager();

        em.getTransaction().begin();

        // placez votre code ici, entre le begin et le commit

        // question 1 : récupérez la liste des films puis affichez leur titre.

//        List<Film> l = em.createQuery("select f from Film f", Film.class).getResultList();
//
//        for (Film li : l){
//            System.out.println(li.getTitre());
//        }



        // question 2 : on a ajouter 2 @joinFetch (value = JoinFetchType.OUTER)

        // question 3 :  afficher pour chaque film en plus du titre son réalisateur

//        List<Film> l = em.createQuery("SELECT f FROM Film f", Film.class).getResultList();
//        for (Film f : l) {
//            System.out.println(f.getTitre() + " .. " + f.getRealisateur().getNom());
//        }

       
        // question 4
      
        // question 5

        List<Film> l3 = em.createQuery(
                "SELECT DISTINCT f FROM Film f JOIN FETCH f.realisateur r JOIN FETCH f.acteurs",
                Film.class
        ).getResultList();

        for (Film f : l3) {
            System.out.println(f.getTitre() + " .. " + f.getRealisateur().getNom() +"c'est acteur \n");

            for (Artiste a : f.getActeurs()) {
                System.out.println(a.getNom());
            }
        }


        // question 6
      
        em.getTransaction().commit();
    }
}

