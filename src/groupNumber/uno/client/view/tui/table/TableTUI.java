package groupNumber.uno.client.view.tui.table;

import groupNumber.uno.client.view.UI;

public class TableTUI implements UI {
    /**
     * Method showcases an error message to the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void log(Object object) {
        System.out.println("LOG |> TABLE: " + object);
    }

    /**
     * Method warns the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void warn(Object object) {
        System.out.println("WARN |> TABLE: " + object);
    }

    /**
     * Method showcases an error message to the user in the terminal
     *
     * @param object object to be printed in the terminal
     */
    @Override
    public void error(Object object) {
        System.out.println("ERR |> TABLE: " + object);
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
