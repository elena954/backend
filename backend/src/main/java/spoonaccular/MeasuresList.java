package spoonaccular;

import java.util.List;

public class MeasuresList {
    private List<ListShopping> original;
    private List<ListShopping> metric;
    private List<ListShopping> us;


    public MeasuresList() {
    }

    public List<ListShopping> getOriginal() {
        return original;
    }

    public void setOriginal(List<ListShopping> original) {
        this.original = original;
    }

    public List<ListShopping> getMetric() {
        return metric;
    }

    public void setMetric(List<ListShopping> metric) {
        this.metric = metric;
    }

    public List<ListShopping> getUs() {
        return us;
    }

    public void setUs(List<ListShopping> us) {
        this.us = us;
    }
}
