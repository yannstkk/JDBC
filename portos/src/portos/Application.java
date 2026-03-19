package portos;

import java.util.List;
import java.util.Set;

import portos.data.*;


public class Application {

    public static void main(String[] args) throws Exception {
		
        Portos portos = new Portos();
        ManagerPM mpm = portos.getManagerPM();
        ManagerProjet mp = portos.getManagerProjet();
        ManagerDeveloppeur md = portos.getManagerDeveloppeur();
        ManagerTechnologie mt = portos.getManagerTechnologie();

        portos.debuter();

        // création de projets
        Projet p1 = mp.ajouterProjet("Apogée");
        Projet p2 = mp.ajouterProjet("Ecandidat");
        Projet p3 = mp.ajouterProjet("MonMaster");

        // création des chefs de projet
        PM pm1 = mpm.ajouterPM("Baude", "Fanny", "fanny.baude@portos.fr",5);
        PM pm2 = mpm.ajouterPM("Gosselin", "Thibaut", "thibaut.gosselin@portos.fr",8);
        PM pm3 = mpm.ajouterPM("Ledoux", "Lyderic", "lyderic.ledoux@portos.fr", 2);
 
        // création des développeurs
        Developpeur d1 = md.ajouterDeveloppeur("DASCALU","Alexandra","alexandra.dascalu@portos.fr","testing");
        Developpeur d2 = md.ajouterDeveloppeur("PALACIOS","Vanessa","vanessa.palacios@portos.fr","analyste");
        Developpeur d3 = md.ajouterDeveloppeur("ARBOS","Lisa","lisa.arbos@portos.fr","ticketing");
        Developpeur d4 = md.ajouterDeveloppeur("ELOUGA","Eva","eva.elouga@portos.fr","testing");
        Developpeur d5 = md.ajouterDeveloppeur("LAURENT","Sarah","sarah.laurent@portos.fr","analyste");
        Developpeur d6 = md.ajouterDeveloppeur("LA ROSA","Zoila","zoila.larosa@portos.fr","ticketing");
        Developpeur d7 = md.ajouterDeveloppeur("SAVAGE","Tristin","tristin.savage@portos.fr","dev");
        Developpeur d8 = md.ajouterDeveloppeur("CERF","Camille","camille.cerf@portos.fr","dev");
        Developpeur d9 = md.ajouterDeveloppeur("MITTENAERE","Iris","iris.mittenaere@portos.fr","dev");
        Developpeur d10 = md.ajouterDeveloppeur("COUCKE","Maëva","maeva.coucke@portos.fr","dev");
        Developpeur d11 = md.ajouterDeveloppeur("GILLES","Eve","eve.gilles@portos.fr","analyste");
        Developpeur d12 = md.ajouterDeveloppeur("AMPIOT","Indira","indira.ampiot@portos.fr","testing");
        Developpeur d13 = md.ajouterDeveloppeur("LEYRE","Diane","diane.leyre@portos.fr","ticketing");
        Developpeur d14 = md.ajouterDeveloppeur("LOVELACE","Ada","ada.lovelace@portos.fr","ticketing");
        Developpeur d15 = md.ajouterDeveloppeur("HOPPER","Grace","grace.hopper@portos.fr","dev");
        Developpeur d16 = md.ajouterDeveloppeur("HAMILTON","Margaret","margaret.hamilton@portos.fr","dev");
        Developpeur d17 = md.ajouterDeveloppeur("WILKES","Mary Allen","maryallen.wilkes@portos.fr","dev");
        Developpeur d18 = md.ajouterDeveloppeur("LAMARR","Hedy","hedy.lamarr@portos.fr","dev");
        Developpeur d19 = md.ajouterDeveloppeur("GOLDBERG","Adele","adele.goldberg@portos.fr","testing");
     
        // création des technologies
        Technologie t1 = mt.ajouterTechnologie("oracle");
        Technologie t2 = mt.ajouterTechnologie("spring");
        Technologie t3 = mt.ajouterTechnologie("angular");
        Technologie t4 = mt.ajouterTechnologie("postgresql");
        Technologie t5 = mt.ajouterTechnologie("haskell");
        Technologie t6 = mt.ajouterTechnologie("node.js");
        Technologie t7 = mt.ajouterTechnologie("python");
        Technologie t8 = mt.ajouterTechnologie("java");
        Technologie t9 = mt.ajouterTechnologie("c");

        // associer projets et développeurs
        mp.affecterDeveloppeur(d1,p1);
        mp.affecterDeveloppeur(d2,p1);
        mp.affecterDeveloppeur(d3,p1);
        mp.affecterDeveloppeur(d4,p1);
        mp.affecterDeveloppeur(d5,p1);
        mp.affecterDeveloppeur(d6,p1);
        mp.affecterDeveloppeur(d7,p1);
        mp.affecterDeveloppeur(d8,p2);
        mp.affecterDeveloppeur(d9,p2);
        mp.affecterDeveloppeur(d10,p2);
        mp.affecterDeveloppeur(d11,p2);
        mp.affecterDeveloppeur(d12,p2);
        mp.affecterDeveloppeur(d13,p2);
        mp.affecterDeveloppeur(d14,p3);
        mp.affecterDeveloppeur(d15,p3);
        mp.affecterDeveloppeur(d16,p3);
        mp.affecterDeveloppeur(d17,p3);
        mp.affecterDeveloppeur(d18,p3);
        mp.affecterDeveloppeur(d19,p3);
       
        // associer equipes et chefs de projet
        mp.gererParChefDeProjet(p1,pm2);
        mp.gererParChefDeProjet(p2,pm1);
        mp.gererParChefDeProjet(p3,pm3);
        
        // associer technologies et développeurs
        mt.affecterDeveloppeur(d19, t9);
        mt.affecterDeveloppeur(d19, t6);
        mt.affecterDeveloppeur(d18, t9);
        mt.affecterDeveloppeur(d17, t1);
        mt.affecterDeveloppeur(d16, t4);
        mt.affecterDeveloppeur(d15, t5);
        mt.affecterDeveloppeur(d14, t4);
        mt.affecterDeveloppeur(d13, t2);
        mt.affecterDeveloppeur(d12, t3);
        mt.affecterDeveloppeur(d11, t6);
        mt.affecterDeveloppeur(d10, t9);
        mt.affecterDeveloppeur(d9, t8);
        mt.affecterDeveloppeur(d8, t7);
        mt.affecterDeveloppeur(d7, t7);
        mt.affecterDeveloppeur(d7, t1);
        mt.affecterDeveloppeur(d6, t6);
        mt.affecterDeveloppeur(d5, t5);
        mt.affecterDeveloppeur(d4, t4);
        mt.affecterDeveloppeur(d3, t3);
        mt.affecterDeveloppeur(d2, t2);
        mt.affecterDeveloppeur(d1, t1);
        

        portos.valider();
      
        portos.debuter();
      
        List<Projet> lp = mp.lesProjets();
        for(Projet p : lp) {
            // afficher le projet

            // afficher son chef de projet

            // afficher les différentes développeuses du projet
            System.out.println("\tDéveloppeurs :");

            // pour chaque développeuse, afficher ses technologies
        }
    }
}

