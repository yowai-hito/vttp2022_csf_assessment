package vttp2022.assessment.csf.orderbackend.models;

import java.util.LinkedList;
import java.util.List;

public class PizzaToppings {
    // chicken: this.fb.control<boolean>(false),
    // seafood: this.fb.control<boolean>(false),
    // beef: this.fb.control<boolean>(false),
    // vegetables: this.fb.control<boolean>(false),
    // cheese: this.fb.control<boolean>(false),
    // arugula: this.fb.control<boolean>(false),
    // pineapple: this.fb.control<boolean>(false),

    private boolean chicken;
    private boolean seafood;
    private boolean beef;
    private boolean vegetables;
    private boolean cheese;
    private boolean arugula;
    private boolean pineapple;

    public boolean isChicken() {
        return chicken;
    }
    public void setChicken(boolean chicken) {
        this.chicken = chicken;
    }
    public boolean isSeafood() {
        return seafood;
    }
    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }
    public boolean isBeef() {
        return beef;
    }
    public void setBeef(boolean beef) {
        this.beef = beef;
    }
    public boolean isVegetables() {
        return vegetables;
    }
    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }
    public boolean isCheese() {
        return cheese;
    }
    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }
    public boolean isArugula() {
        return arugula;
    }
    public void setArugula(boolean arugula) {
        this.arugula = arugula;
    }
    public boolean isPineapple() {
        return pineapple;
    }
    public void setPineapple(boolean pineapple) {
        this.pineapple = pineapple;
    }

    public List<String> toLinkedList() {
        List<String> toppings = new LinkedList<>();
        if (this.isChicken()){
            toppings.add("chicken");
        }
        if (this.isBeef()){
            toppings.add("beef");
        }
        if (this.isArugula()){
            toppings.add("arugula");
        }
        if (this.isCheese()){
            toppings.add("cheese");
        }
        if (this.isPineapple()){
            toppings.add("pineapple");
        }
        if (this.isSeafood()){
            toppings.add("seafood");
        }
        if (this.isVegetables()){
            toppings.add("vegetables");
        }
        return toppings;
    }
}
