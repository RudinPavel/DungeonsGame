package model;

public abstract class Hero implements SpecialActionable {

    protected int currentLevel = 1;

    protected int maxEndurance;
    protected int currentEndurance;
    protected int descentCost = 5;
    protected int restCost = 0;
    protected int enduranceRestore = 2;
    protected int restEnduranceRestore = 3;
    protected int fastDescentCost;
    protected int specialActionCost;
    protected int levelLock = 25;

    public int getLevelLock() {
        return levelLock;
    }

    public void setLevelLock(int levelLock) {
        this.levelLock = levelLock;
    }

    public Hero(int maxEndurance, int fastDescentCost, int specialActionCost) {
        this.maxEndurance = maxEndurance;
        this.currentEndurance = maxEndurance;
        this.fastDescentCost = fastDescentCost;
        this.specialActionCost = specialActionCost;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getMaxEndurance() {
        return maxEndurance;
    }

    public void setMaxEndurance(int maxEndurance) {
        this.maxEndurance = maxEndurance;
    }

    public int getCurrentEndurance() {
        return currentEndurance;
    }

    public void setCurrentEndurance(int currentEndurance) {
        this.currentEndurance = currentEndurance;
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

    public void restoreEndurance(){
        actionRestoreEndurance(enduranceRestore);
    }

    protected boolean changeLevel(int stepSize){

        if (this.currentLevel >= levelLock)
        {
            this.currentLevel += stepSize;
            return true;
        }
        else {
            this.currentLevel += stepSize;
            if (this.currentLevel >= levelLock)
                this.currentLevel = levelLock - 1;
            return true;
        }
    }

    protected boolean ableToDoAction(int cost){
        if (currentEndurance < cost) return false;
        return true;
    }

    private void actionRestoreEndurance(int endurance)
    {
        this.currentEndurance += endurance;
        if (this.currentEndurance > this.maxEndurance){
            this.currentEndurance = this.maxEndurance;
        }
    }

    public boolean actionRest()
    {
        if (ableToDoAction(restCost)) {
            actionRestoreEndurance(restEnduranceRestore);
            return true;
        }
        else {
            System.out.println("Not enough endurance for the rest!");
            return false;
        }
    }

    public boolean actionDescent()
    {
        if (ableToDoAction(this.descentCost)){
            this.currentEndurance -= this.descentCost;
            changeLevel(1);
            return true;
        }
        else {
            System.out.println("Not enough endurance for descent!");
            return false;
        }
    }

    public boolean actionFastDescent()
    {
        if (ableToDoAction(this.fastDescentCost)){
            this.currentEndurance -= this.fastDescentCost;
            changeLevel(2);
            return true;
        }
        else {
            System.out.println("Not enough endurance for fast descent!");
            return false;
        }
    }

    @Override
    public String toString() {
        return  "{currentLevel=" + currentLevel +
                ", currentEndurance=" + currentEndurance +
                '}';
    }
}
