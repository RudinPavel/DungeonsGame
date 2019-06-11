package game;

public class Game {

    public void print(){

        String result = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                result += "[  ] ";
            }
            result += (i+1) + " level";
            result += '\n';
            result += " ||   || ";
            result += '\n';
        }

        System.out.println(result);
    }
}
