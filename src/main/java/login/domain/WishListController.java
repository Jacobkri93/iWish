package login.domain;

public class WishListController {

    private DataFacade facade = null;

    public WishListController(DataFacade facade) {
        this.facade = facade;
    }

    public Wishlist createWishList(String listname, String description) throws LoginSampleException {
        return facade.createWishList(listname, description);
        // By default, new users are customers
       // Wishlist wishlist = new Wishlist(listname, description);
       // facade.createWishList(wishlist);
      //  return wishlist;
    }

}
