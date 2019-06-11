package model;

public abstract class Hero {

    private int endurance;
    private int fastDescentCost;
    private int specialActionCost;

    public Hero(int endurance, int fastDescentCost, int specialActionCost) {
        this.endurance = endurance;
        this.fastDescentCost = fastDescentCost;
        this.specialActionCost = specialActionCost;
    }
}
