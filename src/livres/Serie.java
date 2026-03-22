package livres;

import java.util.ArrayList;

public class Serie {
   private String nomSerie;
   private  ArrayList<Ouvrage> listeOuvrage = new ArrayList<>();

    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    public ArrayList<Ouvrage> getListeOuvrage() {
        return listeOuvrage;
    }

    public void setListeOuvrage(ArrayList<Ouvrage> listeOuvrage) {
        this.listeOuvrage = listeOuvrage;
    }

    public Serie(String nomSerie, ArrayList<Ouvrage> listeOuvrage) {
        this.nomSerie = nomSerie;
        this.listeOuvrage = listeOuvrage;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nomSerie='" + nomSerie + '\'' +
                ", listeOuvrage=" + listeOuvrage +
                '}';
    }
}
