package spoonaccular;

import java.util.List;

public class ShoppingListResponse {

    private List<ShoppingListResponseAisle> aisles;
    private Integer cost;
    private Integer startDate;
    private Integer endDate;

    public ShoppingListResponse() {
    }

    public List<ShoppingListResponseAisle> getAisles() {
        return aisles;
    }

    public void setAisles(List<ShoppingListResponseAisle> aisles) {
        this.aisles = aisles;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
}
