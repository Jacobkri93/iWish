package login.domain;

public class Wish {

public String itemName;
public String description;
public double price;
public String link;
public boolean isReserved;

    public Wish(String itemName, String description, double price, String link, boolean isReserved) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.link = link;
        this.isReserved = isReserved;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
