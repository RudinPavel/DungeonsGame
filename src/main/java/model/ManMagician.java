package model;

public class ManMagician extends Hero {

    private String name = "Man Magician";
    public ManMagician() {
        super(30, 13, 15);
    }

    public void actionSpecialAction() {

    }

    @Override
    public String toString() {
        return name;
    }
}
