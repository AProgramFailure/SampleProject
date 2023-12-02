package groupNumber.uno.client.application;

import groupNumber.uno.client.controller.game.mode.NormalUnoMode;
import groupNumber.uno.client.controller.game.mode.QuickUnoMode;
import groupNumber.uno.client.controller.game.mode.SevenZeroUnoMode;
import groupNumber.uno.client.model.game.Game;
import groupNumber.uno.client.model.player.ComputerPlayer;
import groupNumber.uno.client.model.player.HumanPlayer;
import groupNumber.uno.client.model.player.base.Player;
import groupNumber.uno.client.view.tui.TUI;

import java.util.ArrayList;
import java.util.Scanner;

public class UNO {
    //Main method to run the game
    public static void main(String[] args) {
        final TUI TUI = new TUI();
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        TUI.log("Welcome to UNO, How many players you wish to have? \nMax can only be 10\nMinimum can be 4");
        Integer number_of_players = 0;
        try {
            number_of_players = Integer.parseInt(scanner.nextLine());
            if(number_of_players > 10 || number_of_players < 4){
                throw new IllegalArgumentException("Bounds of players have not been met, so we stop the game :(");
            }
        } catch (Exception e){
            System.out.println("please put a number");
        }

        TUI.log("How many should be NPCs?");
        Integer number_of_computers = 0;
        try {
            number_of_computers = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.out.println("please put a number");
        }

        for (int i = 0; i < (number_of_players - number_of_computers); i++) {
            TUI.log("Enter names of player "+ (i+1) +" to begin playing");
            String[] input = scanner.nextLine().split(" ");
            while(input.length <2){
                TUI.log("Enter both your first name and last name to begin playing");
                input = scanner.nextLine().split(" ");
            }

            Player p1 = new HumanPlayer(input[0], input[1]);
            players.add(p1);
        }

        for (int i = 0; i < number_of_computers; i++) {
            Player cpu = new ComputerPlayer();
            players.add(cpu);
        }

        TUI.printState("Enter the mode which you wish to play");
        TUI.printState("Normal -> type normal\nQuick -> type quick\nSeven Zero-> type sevenzero\nAny other answer will trigger a normal game\n--------------------------------");
        String inputMode = scanner.nextLine();

        switch(inputMode) {
            case("quick"): {
                QuickUnoMode quickUnoMode = new QuickUnoMode();

                Game game = new Game(quickUnoMode, players);
                break;
            }
            case("sevenzero"): {
                SevenZeroUnoMode sevenZeroUnoMode = new SevenZeroUnoMode();
                Game game = new Game(sevenZeroUnoMode, players);
                break;
            }
            default:{
                NormalUnoMode normalUnoMode = new NormalUnoMode();
                Game game = new Game(normalUnoMode, players);
                break;
            }
        }

    }
}

