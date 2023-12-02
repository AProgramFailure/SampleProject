package groupNumber.uno.client.view;

public interface UI {
    /**
     * Method showcases an error message to the user in the terminal
     * @param object object to be printed in the terminal
     */
    void log(Object object);

    /**
     * Method warns the user in the terminal
     * @param object object to be printed in the terminal
     */
    void warn(Object object);

    /**
     * Method showcases an error message to the user in the terminal
     * @param object object to be printed in the terminal
     */
    void error(Object object);

    /**
     * Method showcases the state of particular object to the user in the terminal
     * @param object object to be printed in the terminal
     */
    void printState(Object object);
}
