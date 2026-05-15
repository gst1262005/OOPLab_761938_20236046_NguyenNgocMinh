package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println(media.getTitle() + " is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}