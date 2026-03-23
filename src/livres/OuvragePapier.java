package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage{
    private static final int NOMBRE_PAGE_DEFAULT = 0;

    private int nombreDePage = NOMBRE_PAGE_DEFAULT;

    public int getNombreDePage() {
        return nombreDePage;
    }

    public void setNombreDePage(int nombreDePage) {
        this.nombreDePage = nombreDePage;
    }

    public OuvragePapier(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int nombreDePage) {
        super(titre, auteur, date, nombreExemplaires);
        this.nombreDePage = nombreDePage;
    }

    public OuvragePapier(String titre, Auteur auteur, LocalDate date, int nombreDePage) {
        super(titre, auteur, date);
        this.nombreDePage = nombreDePage;
    }

    public OuvragePapier(String titre, Auteur auteur) {
        super(titre, auteur);
    }

    @Override
    public String toString() {

        String affichageDAte = super.getDate() != null ? super.getDate().toString() : "Non Disponible";

        return "[" + identificateur() + "] " + super.getTitre() + " (" + super.getAuteur().getPrenom() + " "
                + super.getAuteur().getNom() + ") - " + "Livre papier " + " - disponible le " + affichageDAte + " (" + super.getNombreExemplaires() + " ex.)" +
                " - " + getNombreDePage();
    }
}
