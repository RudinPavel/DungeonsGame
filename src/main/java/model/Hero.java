package model;

public abstract class Hero implements SpecialActionable {

    private int currentLevel = 1;

    private int endurance;
    private int fastDescentCost;
    private int specialActionCost;

    public Hero(int endurance, int fastDescentCost, int specialActionCost) {
        this.endurance = endurance;
        this.fastDescentCost = fastDescentCost;
        this.specialActionCost = specialActionCost;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }


    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getFastDescentCost() {
        return fastDescentCost;
    }

    public void setFastDescentCost(int fastDescentCost) {
        this.fastDescentCost = fastDescentCost;
    }

    public int getSpecialActionCost() {
        return specialActionCost;
    }

    public void setSpecialActionCost(int specialActionCost) {
        this.specialActionCost = specialActionCost;
    }

    public void actionRestoreEndurance()
    {
        this.endurance += 2;
    }

    public void actionRest()
    {
        actionRestoreEndurance();
        this.endurance += 3;
    }

    public void actionDescent()
    {
        actionRestoreEndurance();
        this.endurance -= 5;
        this.currentLevel += 1;
    }

    public void actionFastDescent()
    {
        actionRestoreEndurance();
        this.endurance -= fastDescentCost;
        this.currentLevel += 2;
    }

}
