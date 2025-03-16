package feladat1;

import java.util.Comparator;

public class EtelComparator implements Comparator<Etel> {
    // E2
    @Override
    public int compare(Etel o1, Etel o2) {
        int v = (int)(o1.getAr()-o2.getAr());
        if(v!=0) return v;
        return o1.getNev().compareTo(o2.getNev());
    }


}
