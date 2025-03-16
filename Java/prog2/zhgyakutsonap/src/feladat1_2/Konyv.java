package feladat1_2;

import java.util.Objects;

public class Konyv {
    private String cim;
    private String szerzo;
    private int kiadasEve;
    private String mufaj;
    private String isbn;

    /**
     * Létrehoz egy Konyv példányt
     * @param cim
     * @param szerzo
     * @param kiadasEve
     * @param mufaj
     * @param isbn
     */
    public Konyv(String cim, String szerzo, int kiadasEve, String mufaj, String isbn) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiadasEve = kiadasEve;
        this.mufaj = mufaj;
        this.isbn = isbn;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return the title of the book as a String
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
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Konyv{");
        sb.append("cim='").append(cim).append('\'');
        sb.append(", szerzo='").append(szerzo).append('\'');
        sb.append(", kiadasEve=").append(kiadasEve);
        sb.append(", mufaj='").append(mufaj).append('\'');
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Compares this object to the specified object to determine if they are equal.
     *
     * @param o the object to compare this instance with
     * @return true if the specified object is equal to this instance, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Konyv konyv)) return false;
        return Objects.equals(isbn, konyv.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
}
