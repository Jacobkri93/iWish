package login.data;

import login.domain.DataFacade;
import login.domain.LoginSampleException;
import login.domain.User;
import login.domain.Wishlist;

public class DataFacadeImpl implements DataFacade {
   private UserMapper userMapper = new UserMapper();

    public User login(String email, String password) throws LoginSampleException {
        return userMapper.login(email, password);
    }

    public User createUser(User user) throws LoginSampleException {
        userMapper.createUser(user);
        return user;
    }

    @Override
    public Wishlist createWishList(Wishlist wishlist) throws LoginSampleException {
        return null;
    }
}
