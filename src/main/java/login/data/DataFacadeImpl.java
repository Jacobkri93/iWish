package login.data;

import login.domain.*;

public class DataFacadeImpl implements DataFacade {
   private UserMapper userMapper = new UserMapper();
   private ItemMapper itemMapper = new ItemMapper();
   private ListMapper listMapper = new ListMapper();


    public User login(String email, String password) throws LoginSampleException {
        return userMapper.login(email, password);
    }

    public User createUser(User user) throws LoginSampleException {
        userMapper.createUser(user);
        return user;
    }

    @Override
    public Item createItem(Item item) {
        itemMapper.createItem(item);
        return item;
    }

    @Override
    public Item getItem(String name) {
        return itemMapper.getItem(name);

    }

    @Override
    public Wishlist getWishlist(User user) {
        return listMapper.getWishlist(user);

    }


    @Override
    public Wishlist addToList(User user, Item item) {
        return null;
    }


}
