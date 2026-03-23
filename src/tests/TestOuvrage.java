package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import livres.*;

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
        Ouvrage livreA = new OuvragePapier("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new OuvragePapier("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new OuvragePapier(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new OuvragePapier("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new OuvragePapier("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new OuvrageAudio("Tout va bien", albertine, 10, ".mp4");
        System.out.println(livre2);

        livre2 = new OuvragePapier("Tout va bien", albertine, LocalDate.now(), 200, 100);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new OuvragePapier("Musique du hasard", new Auteur("Paul", "Auster", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), null, 5);
        Ouvrage livre6 = new OuvragePapier("Test", new Auteur("A", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new OuvragePapier("Test", new Auteur("Z", "B", new Pays("Etats-Unis", "USA")), LocalDate.now(), 5);

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


    private void testVerifPays() {
        System.out.println();
        System.out.println("-----test pour vérifier si le code d'un pays fonctionne----");
        //test qui fonctionne (true)
        Pays pays = new Pays("Canada", "CAD");
        //associer auteur a un pays
        System.out.println(new Auteur("Jacques", "Beaulieu", pays));
        System.out.println();
        //test qui ne fonctionne pas (false)
        Pays pays2 = new Pays("Mexique", "mex");
        System.out.println(new Auteur("Jacques", "Beaulieu", pays2));
        System.out.println();
    }

    public void testSerie() {
        Pays usa = new Pays("Etats-Unis", "USA");
        Pays cad = new Pays("Canada", "CAD");

        Auteur albertine = new Auteur("Albertine", "Tremblay", cad);
        Auteur john = new Auteur("John", "Smith", usa);

        Ouvrage livre4 = new OuvragePapier("Test2", albertine, null, 5);
        Ouvrage livre5 = new OuvragePapier("Test3", albertine, LocalDate.now(), 10);
        Ouvrage livre6 = new OuvragePapier("Test5", john, LocalDate.now(), 5);

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

