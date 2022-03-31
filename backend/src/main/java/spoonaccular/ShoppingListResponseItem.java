package spoonaccular;

import java.util.List;

public class ShoppingListResponseItem {
    private Long id;
    private String name;
    private List<MeasuresList> measures;
    private String usages;
    private String usageRecipeIds;
    private String pantryItem;
    private String aisle;
    private String cost;
    private String ingredientId;


    public ShoppingListResponseItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MeasuresList> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasuresList> measures) {
        this.measures = measures;
    }

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages;
    }

    public String getUsageRecipeIds() {
        return usageRecipeIds;
    }

    public void setUsageRecipeIds(String usageRecipeIds) {
        this.usageRecipeIds = usageRecipeIds;
    }

    public String getPantryItem() {
        return pantryItem;
    }

    public void setPantryItem(String pantryItem) {
        this.pantryItem = pantryItem;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }
}