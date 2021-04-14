package login.domain;

public interface DataFacade {

    public User login(String email, String password) throws LoginSampleException;
    public User createUser(User user) throws LoginSampleException;
    public Item createItem(Item item);
    public Item getItem(String name);
    public Wishlist getWishlist(User user);
    public Wishlist addToList(User user, Item item);



}