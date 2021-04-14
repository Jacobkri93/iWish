package login.domain;

public class WishListController {

    private DataFacade facade = null;

    public WishListController(DataFacade facade) {
        this.facade = facade;
    }

    public Wishlist getWishlist(User user)  {
        return this.facade.getWishlist(user);
        // By default, new users are customers
       // Wishlist wishlist = new Wishlist(listname, description);
       // facade.createWishList(wishlist);
      //  return wishlist;
    }

}
