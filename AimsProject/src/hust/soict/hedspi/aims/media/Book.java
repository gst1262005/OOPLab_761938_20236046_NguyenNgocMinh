package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() { return authors; }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " has been added.");
        } else {
            System.out.println("Author " + authorName + " already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.println("Author " + authorName + " has been removed.");
        } else {
            System.out.println("Author " + authorName + " not found.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + " - Cost: " + getCost() + " $";
    }
}