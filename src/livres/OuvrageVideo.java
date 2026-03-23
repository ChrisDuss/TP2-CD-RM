package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage{
    private int dureMinute;
    private int TailleMb;

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

    public OuvrageVideo(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int dureMinute, int tailleMb) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.dureMinute = dureMinute;
        TailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur, Format type, int dureMinute, int tailleMb) {
        super(titre, auteur, type);
        this.dureMinute = dureMinute;
        TailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur, int dureMinute, int tailleMb) {
        super(titre, auteur);
        this.dureMinute = dureMinute;
        TailleMb = tailleMb;
    }

    @Override
    public String toString() {
        return "OuvrageVideo{" +
                "dureMinute=" + dureMinute +
                ", TailleMb=" + TailleMb +
                '}';
    }
}
