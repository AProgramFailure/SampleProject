package groupNumber.uno.client.view.tui.player;

import groupNumber.uno.client.view.UI;

public class PlayerTUI implements UI {
    /**
     * Method showcases an error message to the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void log(Object object) {
        System.out.println("LOG |> PLAYER: " + object);
    }

    /**
     * Method warns the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void warn(Object object) {
        System.out.println("WARN |> PLAYER: " + object);
    }

    /**
     * Method showcases an error message to the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void error(Object object) {
        System.out.println("ERR |> PLAYER: " + object);
    }

    /**
     * Method showcases the state of particular object to the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void printState(Object object) {
        System.out.println(object);
    }
}
