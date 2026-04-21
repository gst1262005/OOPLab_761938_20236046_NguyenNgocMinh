package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    // equals(): Media được coi là giống nhau nếu title trùng nhau
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media other = (Media) obj;
            return this.title.equalsIgnoreCase(other.title);
        }
        return false;
    }

    // toString(): mặc định
    @Override
    public String toString() {
        return "Media - " + title + " - " + category + " - Cost: " + cost + " $";
    }

    // Comparator: Title → Cost
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    // Comparator: Cost → Title
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}