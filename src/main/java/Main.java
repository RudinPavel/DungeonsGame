import game.Game;
import game.Player;
import model.DwarfWarrior;
import model.ElfScout;
import model.Hero;
import model.ManMagician;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        Scanner cin = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Welcome to Dungeons Game!");
        Game game = new Game();

        System.out.println("Input name for player 1 :");
        Player player1 = new Player(cin.nextLine());

        System.out.println("Input name for player 2 :");
        Player player2 = new Player(cin.nextLine());

        System.out.println("player 1 : "+ player1.getName());
        System.out.println("player 2 : "+ player2.getName());

        List<Hero> heroesPull = new ArrayList<Hero>();
        Hero dwarfWarrior = new DwarfWarrior();
        Hero elfScout = new ElfScout();
        Hero manMagician = new ManMagician();

        heroesPull.add(dwarfWarrior);
        heroesPull.add(elfScout);
        heroesPull.add(manMagician);

        boolean player1HasFirstStep = rnd.nextBoolean();

        System.out.println(player1HasFirstStep ? player1.getName() + " has first step!"
                : player2.getName() + " has first step!");

        Player currentPlayer;
        int count = 0;

        while (count < 2) {

            if (player1HasFirstStep) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }

            System.out.println("Select your hero:");
            System.out.println("1. Dwarf Warrior");
            System.out.println("2. Elf Scout");
            System.out.println("3. Man Magician");

            int choice = Integer.parseInt(cin.nextLine());
            switch (choice) {
                case 1:
                    int dwarfWarriorIndex = heroesPull.indexOf(dwarfWarrior);
                    if (dwarfWarriorIndex == -1) throw new Exception("Hero is not available");
                    currentPlayer.setHero(heroesPull.get(dwarfWarriorIndex));
                    heroesPull.remove(dwarfWarriorIndex);
                    break;
                case 2:
                    int elfScoutIndex = heroesPull.indexOf(elfScout);
                    if (elfScoutIndex == -1) throw new Exception("Hero is not available");
                    currentPlayer.setHero(heroesPull.get(elfScoutIndex));
                    heroesPull.remove(elfScoutIndex);
                    break;
                case 3:
                    int manMagicianIndex = heroesPull.indexOf(manMagician);
                    if (manMagicianIndex == -1) throw new Exception("Hero is not available");
                    currentPlayer.setHero(heroesPull.get(manMagicianIndex));
                    heroesPull.remove(manMagicianIndex);
                    break;
            }

            count++;
            player1HasFirstStep = !player1HasFirstStep;
        }

        System.out.println(player1.toString());
        System.out.println(player2.toString());

        //while (game.isNotEnd()){
        while (true){

            game.print();
            break;
        }
        System.out.println("Good luck!");
    }
}
