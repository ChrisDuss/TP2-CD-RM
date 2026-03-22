package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import livres.Ouvrage;
import livres.Auteur;
import livres.Pays;
import livres.Serie;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testVerifPays();
        test.testSerie();
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAD"));
        Auteur john = new Auteur("John", "Smith", new Pays("Etats-Unis", "USA"));

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new Ouvrage("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new Ouvrage(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new Ouvrage("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new Ouvrage("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10);
        System.out.println(livre2);

        livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new Ouvrage("Musique du hasard", new Auteur("Paul", "Auster", new Pays("Etats-Unis", "USA")), Ouvrage.Format.PAPIER, LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new Ouvrage("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new Ouvrage("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre6 = new Ouvrage("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), Ouvrage.Format.PAPIER, LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new Ouvrage("Test", new Auteur("Z", "B", new Pays("Etats-Unis", "USA")), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", new Pays("Canada", "CAD")));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", new Pays("France", "FRC")));
        System.out.println("Livres de Jacques: " + resultat);
    }

// regarder pour la verif car elle est mis private dans pays
    /// La vérif se fait dans setCodePays() donc pas besoin ^^
    /// des que tu crée le pays il se fait verifier
    /// tes tests son null aussi

    private void testVerifPays () {

        Pays pays = new Pays("Canada", "CAD" );

//       if(validerCodePays(pays.getCodePays())){
//           System.out.println("le code du pays est correct");
//       }else {
//           System.out.println("code pays invalide il faut exactement 3 lettre majuscule");
//       }

        //associer auteur a un pays
        System.out.println(new Auteur("Jacques", "Beaulieu", pays));

    }

//    private boolean validerCodePays(String codePays) {
//        boolean valide = false;
//        int majCount = 0;
//
//        //exactement 3 lettres
//        if (codePays.length() == 3) {
//            //majuscule
//            for (int i = 0; i < codePays.length(); i++) {
//                if (isMaj(codePays.charAt(i))) {
//                    majCount += 1;
//                }
//            }
//            if (majCount == 3) valide = true;
//        }
//
//        return valide;
//    }
//
//    private boolean isMaj(char c) {
//        return (c >= 65 && c <= 90);
//    }

    public void testSerie() {
        Pays usa = new Pays("Etats-Unis", "USA");
        Pays cad = new Pays("Canada", "CAD");

        Auteur albertine = new Auteur("Albertine", "Tremblay", cad);
        Auteur john = new Auteur("John", "Smith", usa);

        Ouvrage livre4 = new Ouvrage("Test2", albertine, Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre5 = new Ouvrage("Test3", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 10);
        Ouvrage livre6 = new Ouvrage("Test5", john, Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        ArrayList<Ouvrage> collectionTest = new ArrayList<>();
        collectionTest.add(livre4);
        collectionTest.add(livre5);
        collectionTest.add(livre6);

        System.out.println("\n-----Test des constructeurs de série-----------");
        Serie testSerie = new Serie("Serie Test", collectionTest);
        Serie serie2 = new Serie("Test Vide", new ArrayList<>());

        System.out.println(testSerie);
        System.out.println(serie2);

        System.out.println("\n----------Test Serie-----------");
        System.out.println("\n-- getter --");
        System.out.println(testSerie.getNomSerie().equals("Serie Test") + " --> est Serie Test");
        System.out.println((serie2.getListeOuvrage().equals(new ArrayList<>())) + " --> serie2 est vide");

        System.out.println("\n-- setter --");
        System.out.println(testSerie.getNomSerie());
        testSerie.setNomSerie("test Serie");
        System.out.println(testSerie.getNomSerie());
    }

}

