package cscd212classes.lab2;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {

    @Override
    public int compare(Television t1, Television t2) {
        return t1.getScreenSize()-t2.getScreenSize();
    }
}
