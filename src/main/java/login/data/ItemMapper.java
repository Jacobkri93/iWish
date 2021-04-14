package login.data;

import login.domain.Item;
import login.domain.LoginSampleException;
import login.domain.User;

import java.io.FileNotFoundException;
import java.sql.*;

public class ItemMapper {

    public void createItem(Item item) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO item (`name`,`price`,`description`) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setString(3, item.getDescription());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            item.setId(id);
        } catch (SQLException | FileNotFoundException ex) {
        }
    }

    public Item getItem(String name) {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "SELECT id, name, price, description FROM item where name = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String description = rs.getString("description");
                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                Item item = new Item(name, description, price);
                item.setId(id);
                return item;
            }
        } catch (SQLException | FileNotFoundException ex) {
        }
        return null;
    }
}