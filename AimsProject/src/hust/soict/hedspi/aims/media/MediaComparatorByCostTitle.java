package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo cost giảm dần
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        // Nếu cost bằng nhau → title tăng dần
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}