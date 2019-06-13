package model;

public class ManMagician extends Hero {

    private String name = "Man Magician";
    public ManMagician() {
        super(30, 13, 15);
    }

    public boolean actionSpecialAction() {
        return true;
    }

    @Override
    public String toString() {
        return name + super.toString();
    }
}
