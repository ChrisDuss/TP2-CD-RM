package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage{
    public static final int DUREE_MINUTE_DEFAULT = 0;
    public static final int TAILLE_DEFAULT = 0;


    private int dureMinute = DUREE_MINUTE_DEFAULT;
    private int TailleMb = TAILLE_DEFAULT;

    public int getTailleMb() {
        return TailleMb;
    }

    public void setTailleMb(int tailleMb) {
        TailleMb = tailleMb;
    }

    public int getDureMinute() {
        return dureMinute;
    }

    public void setDureMinute(int dureMinute) {
        this.dureMinute = dureMinute;
    }

    public OuvrageVideo(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int dureMinute, int tailleMb) {
        super(titre, auteur, date, nombreExemplaires);
        this.dureMinute = dureMinute;
        TailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur, int dureMinute, int tailleMb) {
        super(titre, auteur);
        this.dureMinute = dureMinute;
        TailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur) {
        super(titre, auteur);
    }

    @Override
    public String toString() {

        String affichageDAte = super.getDate() != null ? super.getDate().toString() : "Non Disponible";

        return "[" + identificateur() + "] " + super.getTitre() + " (" + super.getAuteur().getPrenom() + " "
                + super.getAuteur().getNom() + ") - " + "Video " + " - disponible le " + affichageDAte + " (" + super.getNombreExemplaires() + " ex.)" +
                " - " + getDureMinute() + "min - " + getTailleMb() + " mb.";
    }
}
