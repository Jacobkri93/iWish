package login.domain;

public interface DataFacade {

    public User login(String email, String password) throws LoginSampleException;
    public User createUser(User user) throws LoginSampleException;
    public Wishlist createWishList(Wishlist wishlist) throws LoginSampleException;


    Wishlist createWishList(String listname, String description) throws LoginSampleException;
}