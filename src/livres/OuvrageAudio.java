package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage {
    private int dureMinute;
    private String format;

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

    public OuvrageAudio(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int dureMinute, String format) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.dureMinute = dureMinute;
        this.format = format;
    }

    public OuvrageAudio(String titre, Auteur auteur, Format type, int dureMinute, String format) {
        super(titre, auteur, type);
        this.dureMinute = dureMinute;
        this.format = format;
    }

    public OuvrageAudio(String titre, Auteur auteur, int dureMinute, String format) {
        super(titre, auteur);
        this.dureMinute = dureMinute;
        this.format = format;
    }

    @Override
    public String toString() {
        return "OuvrageAudio{" +
                "dureMinute=" + dureMinute +
                ", format='" + format + '\'' +
                '}';
    }
}
