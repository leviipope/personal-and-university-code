package feladat1_2;

import java.util.Objects;

public class Konyv {
    private String cim;
    private String szerzo;
    private int kiadasEve;
    private String mufaj;
    private String ISBN;

    /**
     * Constructor to initialize a hotel.
     * @param cim
     * @param szerzo
     * @param kiadasEve
     * @param mufaj
     * @param ISBN
     */
    public Konyv(String cim, String szerzo, int kiadasEve, String mufaj, String ISBN) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiadasEve = kiadasEve;
        this.mufaj = mufaj;
        this.ISBN = ISBN;
    }

    /**
     *
     * @return Visszaadja egy peldany Cimet
     */
    public String getCim() {
        return cim;
    }
    public String getSzerzo() {
        return szerzo;
    }
    public int getKiadasEve() {
        return kiadasEve;
    }
    public String getMufaj() {
        return mufaj;
    }
    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Konyv{");
        sb.append("cim='").append(cim).append('\'');
        sb.append(", szerzo='").append(szerzo).append('\'');
        sb.append(", kiadasEve=").append(kiadasEve);
        sb.append(", mufaj='").append(mufaj).append('\'');
        sb.append(", ISBN='").append(ISBN).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this book to another for equality
     * @param o the object to compare with this book
     * @return true is the specified object is equal to this book, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Konyv konyv)) return false;
        return Objects.equals(ISBN, konyv.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }
}
