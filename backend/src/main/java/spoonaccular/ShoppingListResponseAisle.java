package spoonaccular;

import java.util.List;

public class ShoppingListResponseAisle {

    private String aisle;
    private List<ShoppingListResponseItem> items;


    public ShoppingListResponseAisle() {
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public List<ShoppingListResponseItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingListResponseItem> items) {
        this.items = items;
    }
}
