package cinema;

import java.util.List;

import cinema.data.Pays;
import cinema.data.Artiste;
import cinema.data.Film;
import cinema.jpa.EntitySingleton;

import jakarta.persistence.*;

public class ApplicationChargement {

    public static void main(String[] args) throws Exception {
		

        EntityManager em = EntitySingleton.getManager();

        em.getTransaction().begin();

        // placez votre code ici, entre le begin et le commit

        // question 1

        // question 2

        // question 3
       
        // question 4
      
        // question 5

        // question 6
      
        em.getTransaction().commit();
    }
}

