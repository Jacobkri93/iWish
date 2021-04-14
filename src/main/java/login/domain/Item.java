package login.domain;

public class Item {

    private int id;
    private String name;
    private String description;
    private double price;
//    public String link;
//    public boolean isReserved;

    public Item(int id, String itemName, String description, double price) {
        this.id = id;
        this.name = itemName;
        this.description = description;
        this.price = price;

//        this.link = link;
//        this.isReserved = isReserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public boolean isReserved() {
//        return isReserved;
//    }
//
//    public void setReserved(boolean reserved) {
//        isReserved = reserved;
//    }
    
    
}
