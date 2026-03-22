package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import db.UserDAO;
import model.User;
import model.Trainer;
import model.Trainee;
import service.AuthException;

/**
 * JavaFX login screen — the entry point UI for SkillBridge.
 *
 * JavaFX Crash Course:
 *   - Application  : base class for every JavaFX app; override start(Stage).
 *   - Stage        : the OS window.
 *   - Scene        : the content inside the window.
 *   - Node/Control : UI elements (Label, TextField, Button, etc.).
 *   - Layout panes : VBox (vertical stack), HBox (horizontal), etc.
 *
 * CONCEPTS DEMONSTRATED: JavaFX Application lifecycle, event handlers
 * (lambda expressions), role-based navigation, try/catch in UI context.
 */
public class LoginApp extends Application {

    // --- start() --------------------------------------------------------
    // TODO-1: Override start(Stage primaryStage):
    //   This is called by the JavaFX runtime when the app launches.
    //   Set the title: primaryStage.setTitle("SkillBridge — Login");

    // TODO-2: Create UI controls:
    //   Label titleLabel   = new Label("SkillBridge 🎓");
    //   Label usernameLabel = new Label("Username:");
    //   TextField usernameField = new TextField();
    //   Label passwordLabel = new Label("Password:");
    //   PasswordField passwordField = new PasswordField();
    //   Button loginButton  = new Button("Log In");
    //   Label statusLabel   = new Label("");   ← shows error messages

    // TODO-3: Arrange controls in a VBox (vertical box):
    //   VBox root = new VBox(10, titleLabel, usernameLabel, usernameField,
    //                            passwordLabel, passwordField, loginButton, statusLabel);
    //   root.setAlignment(Pos.CENTER);
    //   root.setPadding(new Insets(20));

    // TODO-4: Attach a login action to loginButton:
    //   loginButton.setOnAction(event -> handleLogin(
    //       usernameField.getText(),
    //       passwordField.getText(),
    //       primaryStage,
    //       statusLabel));

    // TODO-5: Build and show the scene:
    //   Scene scene = new Scene(root, 350, 300);
    //   primaryStage.setScene(scene);
    //   primaryStage.show();

    // --- handleLogin() --------------------------------------------------
    // TODO-6: Write private void handleLogin(String username, String password,
    //                                        Stage stage, Label statusLabel):
    //   a) Create a UserDAO and call findByCredentials(username, password).
    //   b) If user is a Trainer, open TrainerDashboard.
    //   c) If user is a Trainee, open TraineeDashboard.
    //   d) Catch AuthException and set statusLabel.setText(e.getMessage()).
    //   e) Catch SQLException and set statusLabel.setText("Database error.").
}
