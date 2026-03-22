import javafx.application.Application;
import gui.LoginApp;

/**
 * Application entry point.
 *
 * WHY is Main separate from LoginApp?
 *   Some build setups (especially modular JavaFX with Java 11+) require
 *   the class containing main() to NOT directly extend Application, or
 *   the JVM throws an IllegalAccessError at runtime.
 *   Keeping a thin Main launcher avoids this edge case.
 *
 * CONCEPTS DEMONSTRATED: main() method, Application.launch().
 */
public class Main {

    // TODO-1: Write the main method:
    //   public static void main(String[] args) {
    //       Application.launch(LoginApp.class, args);
    //   }
    //
    //   Application.launch() is the JavaFX way to start the GUI.
    //   It creates the Stage, calls LoginApp.start(stage), and takes
    //   over the main thread for the JavaFX event loop.
}
