package login.data;

import login.domain.LoginSampleException;
import login.domain.Wishlist;

import java.io.FileNotFoundException;
import java.sql.*;

public class ListMapper {



    public Wishlist createWishList (String listname, String description) throws LoginSampleException {
        try {
            Connection con = DBManager.getConnection();
            String SQL = "INSERT INTO wishlist (listname, description) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, listname);
            ps.setString(2, description);

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            Wishlist wishlist = new Wishlist(listname, description);
            wishlist.setId(id);
            return wishlist;
        } catch (SQLException | FileNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }


    }

}
