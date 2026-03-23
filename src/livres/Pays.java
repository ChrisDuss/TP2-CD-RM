package livres;

import java.util.Objects;

/**
 * TP2-CD-RM
 *
 * @author chris
 * @since 3/19/2026
 */
public class Pays {
    private String nom;
    private String codePays;

    public Pays(String nom, String codePays) {
        setNom(nom);
        setCodePays(codePays);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePays() {
        return codePays;
    }

    public void setCodePays(String codePays) {
        if (validerCodePays(codePays)) {
            this.codePays = codePays;
        } else {
            System.out.println("code pays invalide (exactement 3 lettre majuscule)");
        }
    }

    private boolean validerCodePays(String codePays) {
        boolean valide = false;
        int majCount = 0;

        //exactement 3 lettres
        if (codePays.length() == 3) {
            //majuscule
            for (int i = 0; i < codePays.length(); i++) {
                if (isMaj(codePays.charAt(i))) {
                    majCount += 1;
                }
            }
            if (majCount == 3) valide = true;
        }

        return valide;
    }

    private boolean isMaj(char c) {
        return (c >= 65 && c <= 90);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pays pays = (Pays) o;
        return Objects.equals(nom, pays.nom) && Objects.equals(codePays, pays.codePays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, codePays);
    }

    @Override
    public String toString() {
        return "Pays{" +
                "nom='" + nom + '\'' +
                ", codePays='" + codePays + '\'' +
                '}';
    }
}
