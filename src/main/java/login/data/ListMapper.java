package login.data;

import login.domain.Item;
import login.domain.LoginSampleException;
import login.domain.User;
import login.domain.Wishlist;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

public class ListMapper {


    public Wishlist addItemToList(User user, Item item) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO wishlist (user_id, item_id) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setInt(2, item.getId());

            ps.executeUpdate();

        } catch (SQLException | FileNotFoundException ex) {
        }
        return getWishlist(user);
    }

    public Wishlist getWishlist(User user) {
        Wishlist list = new Wishlist();
        ArrayList<Item> itemlist = new ArrayList<Item>();
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT item.* FROM wishlist join item ON item.id=wishlist.item_id WHERE wishlist.user_id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String description = rs.getString("description");
                String name = rs.getString("name");
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                Item item = new Item(name, description, price);
                item.setId(id);
                itemlist.add(item);
            }
        } catch (SQLException | FileNotFoundException ex) {
        }
        list.setItemlist(itemlist);
        list.setUser_id(user.getId());
        return list;

    }
}
