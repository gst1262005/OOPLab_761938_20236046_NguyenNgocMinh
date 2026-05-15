package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private static int idCounter = 0; 
    private String director;
    private int length;

    // Constructor có id truyền vào
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Constructor rút gọn: id tự động tăng
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++idCounter, title, category, cost); // dùng idCounter để tự tăng
        this.director = director;
        this.length = length;
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++idCounter, title, category, cost);
        this.director = "Unknown";
        this.length = 0;
    }


    public String getDirector() { return director; }
    public int getLength() { return length; }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - "
               + director + " - " + length + ": " + getCost() + " $";
    }
    
    @Override
    public void play() {

        // Kiểm tra length hợp lệ
        if (getLength() <= 0) {

            System.out.println("This DVD cannot be played.");

            return;
        }

        // Thông tin play
        System.out.println(
                "Playing DVD: "
                + getTitle()
                + " - Length: "
                + getLength());
    }

    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
}