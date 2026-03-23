package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage {
    public static final int DUREE_MINUTE_DEFAULT = 0;
    public static final String FORAMT_DEFAULT = "no format";

    private int dureMinute = DUREE_MINUTE_DEFAULT;
    private String format = FORAMT_DEFAULT;

    public int getDureMinute() {
        return dureMinute;
    }

    public void setDureMinute(int dureMinute) {
        this.dureMinute = dureMinute;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public OuvrageAudio(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int dureMinute, String format) {
        super(titre, auteur, date, nombreExemplaires);
        this.dureMinute = dureMinute;
        this.format = format;
    }

    public OuvrageAudio(String titre, Auteur auteur, int dureMinute, String format) {
        super(titre, auteur);
        this.dureMinute = dureMinute;
        this.format = format;
    }

    public OuvrageAudio(String titre, Auteur auteur) {
        super(titre, auteur);
    }

    @Override
    public String toString() {

        String affichageDAte = super.getDate() != null ? super.getDate().toString() : "Non Disponible";

        return "[" + identificateur() + "." + getFormat() + "] " + super.getTitre() + " (" + super.getAuteur().getPrenom() + " "
                + super.getAuteur().getNom() + ") - " + "Livre audio " + " - disponible le " + affichageDAte + " (" + super.getNombreExemplaires() + " ex.)" +
                " - " + getDureMinute() + " min";
    }
}
