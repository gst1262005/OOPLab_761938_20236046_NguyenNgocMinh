package code;

public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Unknown", 90, 18.99f);

        // Thêm DVD vào giỏ
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng chi phí trước khi xóa
        System.out.println("Total cost before removal: " + anOrder.totalCost());

        // Xóa một DVD
        anOrder.removeDigitalVideoDisc(dvd2);

        // In tổng chi phí sau khi xóa
        System.out.println("Total cost after removal: " + anOrder.totalCost());

        // Thử xóa DVD không có trong giỏ
        anOrder.removeDigitalVideoDisc(dvd2); // sẽ báo "The disc is not in the cart"
    }
}
