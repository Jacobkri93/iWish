package login.domain;

public class ItemController {


    private DataFacade facade = null;

    public ItemController(DataFacade facade) {
        this.facade = facade;
    }

    public Item getItem(String name)  {
        return this.facade.getItem(name);

    }

    public Item createItem(Item item) {
        return this.facade.createItem(item);
    }

}
