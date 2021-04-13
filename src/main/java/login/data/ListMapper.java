package login.data;

import login.domain.LoginSampleException;
import login.domain.User;
import login.domain.Wishlist;

import java.io.FileNotFoundException;
import java.sql.*;

public class ListMapper {



    public void createWishList (Wishlist wishlist) throws LoginSampleException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO wishlist (listname, description) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, wishlist.getListName());
            ps.setString(2, wishlist.getDescription());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            wishlist.setId(id);
        } catch (SQLException | FileNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
