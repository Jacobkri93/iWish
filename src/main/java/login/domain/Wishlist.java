package login.domain;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Wishlist {

private int user_id;
private ArrayList<Item> itemlist;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<Item> itemlist) {
        this.itemlist = itemlist;
    }
}
