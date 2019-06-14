import game.Game;
import game.Player;
import model.DwarfWarrior;
import model.ElfScout;
import model.Hero;
import model.ManMagician;
import persistence.GameDAO;
import utils.Log;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        Scanner cin = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Welcome to Dungeons Game!");
        Log.addAction("Welcome to Dungeons Game!");

        System.out.println("Input name for player 1 :");
        Player player1 = new Player(cin.nextLine());
        Log.addAction("Input name for player 1 :");
        Log.addAction(player1.getName());

        System.out.println("Input name for player 2 :");
        Player player2 = new Player(cin.nextLine());
        Log.addAction("Input name for player 2 :");
        Log.addAction(player2.getName());

        System.out.println("player 1 : " + player1.getName());
        System.out.println("player 2 : " + player2.getName());

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
        Log.addAction(player1HasFirstStep ? player1.getName() + " has first step!"
                : player2.getName() + " has first step!");

        Player currentPlayer;
        Player secondPlayer;
        int count = 0;

        if (player1HasFirstStep) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        while (count < 2) {

            System.out.println();
            System.out.println(currentPlayer.getName() + " select your hero:");
            Log.addAction(currentPlayer.getName() + " select your hero:");
            System.out.println("1. Dwarf Warrior");
            System.out.println("2. Elf Scout");
            System.out.println("3. Man Magician");

            int choice = Integer.parseInt(cin.nextLine());
            Log.addAction(String.valueOf(choice));
            switch (choice) {
                case 1:
                    int dwarfWarriorIndex = heroesPull.indexOf(dwarfWarrior);
                    if (dwarfWarriorIndex == -1) {
                        System.out.println("Hero is not available. Choose another.");
                        Log.addAction("Hero is not available. Choose another.");
                        continue;
                        // throw new Exception("Hero is not available");
                    }
                    currentPlayer.setHero(heroesPull.get(dwarfWarriorIndex));
                    Log.addAction(currentPlayer.toString());
                    heroesPull.remove(dwarfWarriorIndex);
                    break;
                case 2:
                    int elfScoutIndex = heroesPull.indexOf(elfScout);
                    if (elfScoutIndex == -1) {
                        System.out.println("Hero is not available. Choose another.");
                        Log.addAction("Hero is not available. Choose another.");
                        continue;
                        //throw new Exception("Hero is not available");
                    }
                    currentPlayer.setHero(heroesPull.get(elfScoutIndex));
                    Log.addAction(currentPlayer.toString());
                    heroesPull.remove(elfScoutIndex);
                    break;
                case 3:
                    int manMagicianIndex = heroesPull.indexOf(manMagician);
                    if (manMagicianIndex == -1) {
                        System.out.println("Hero is not available. Choose another.");
                        Log.addAction("Hero is not available. Choose another.");
                        continue;
                        //throw new Exception("Hero is not available");
                    }
                    currentPlayer.setHero(heroesPull.get(manMagicianIndex));
                    Log.addAction(currentPlayer.toString());
                    heroesPull.remove(manMagicianIndex);
                    break;
                    default:
                        System.out.println("No hero for this number!");
                        Log.addAction("No hero for this number!");
                        continue;
            }

            count++;
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }
            else {
                currentPlayer = player1;
            }
        }

        System.out.println(player1.toString());
        Log.addAction(player1.toString());
        System.out.println(player2.toString());
        Log.addAction(player2.toString());

        if (player1HasFirstStep) {
            currentPlayer = player1;
            secondPlayer = player2;
        } else {
            currentPlayer = player2;
            secondPlayer = player1;
        }

        Game game = new Game(player1, player2);
        Log.addAction("The game begin!");
        while (!game.isEnd()){
            Log.addAction(currentPlayer.getName() + " step :");
            currentPlayer.getHero().restoreEndurance();
            Log.addAction(currentPlayer.getName() + " restore endurance");
            secondPlayer.getHero().setLevelLock(25);
            Log.addAction(secondPlayer.getName() + " get level lock");
            boolean stepContinue = true;
            while (stepContinue) {
                System.out.println();
                System.out.println(currentPlayer.getName() + " step:");
                System.out.println("1. Rest");
                System.out.println("2. Descent");
                System.out.println("3. Fast Descent");
                System.out.println("4. Special Action");
                System.out.println(currentPlayer.getName() + " input number for action : ");
                Log.addAction(currentPlayer.getName() + " input number for action : ");
                int choose = Integer.parseInt(cin.nextLine());
                Log.addAction(String.valueOf(choose));
                switch (choose){
                    case 1:
                        if (currentPlayer.getHero().actionRest()) {
                            stepContinue = false;
                            Log.addAction(currentPlayer.getHero() + " do rest ");
                        }
                        else continue;
                        break;
                    case 2:
                        if (currentPlayer.getHero().actionDescent()) {
                            stepContinue = false;
                            Log.addAction(currentPlayer.getHero() + " do descent ");
                        }
                        else continue;
                       break;
                    case 3:
                        if (currentPlayer.getHero().actionFastDescent()) {
                            stepContinue = false;
                            Log.addAction(currentPlayer.getHero() + " do fast descent action ");
                        }
                        else continue;
                        break;
                    case 4:
                        if (currentPlayer.getHero().actionSpecialAction(secondPlayer)) {
                            stepContinue = false;
                            Log.addAction(currentPlayer.getHero() + " do special action ");
                        }
                        else continue;
                        break;
                        default:
                            System.out.println("No action for this number!");
                            Log.addAction("No action for this number!");
                            continue;
                }
                break;
            }
            game.print();
            System.out.println(currentPlayer.toString());
            Log.addAction(currentPlayer.toString());
            System.out.println(secondPlayer.toString());
            Log.addAction(secondPlayer.toString());
            if (currentPlayer == player1) {
                currentPlayer = player2;
                secondPlayer = player1;
            }
            else {
                currentPlayer = player1;
                secondPlayer = player2;
            }
        }
        System.out.println("Good luck!");
        System.out.println();

        Log.addAction("Good luck!");
        System.out.println(Log.getLog());

//        fixme Этот код работает с базой данных PostgreSQL и записывает ход игры в таблицу games
//        game.setLog(Log.getLog());
//        System.out.println(game.getLog());
//        GameDAO gameDAO = new GameDAO();
//        gameDAO.add(game);
//        System.out.println(gameDAO.findAll());

//         fixme Для создания таблицы использовался следующий код
//        create table games(
//            id serial primary key,
//            log text not null
//        );
//        fixme Для удаления таблицы использовался следующий код
//        drop table games;

    }
}
