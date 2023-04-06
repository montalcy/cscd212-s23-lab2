package cscd212classes.lab2;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {
    @Override
    public int compare(Television t1, Television t2) {
        if(t1.getResolution()-(t2.getResolution())==0){
            return t1.getMake().compareTo(t2.getMake());
        }
        return t1.getResolution()-(t2.getResolution());
    }
}
