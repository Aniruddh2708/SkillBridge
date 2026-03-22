package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import model.Trainer;
import model.Trainee;
import model.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Trainer Dashboard — the main screen for an authenticated Trainer.
 *
 * Features (each is one TODO block):
 *   1. Display trainer's name and code in the header.
 *   2. Show a list of enrolled trainees.
 *   3. Allow enrolling a new trainee (input fields + button).
 *   4. Allow assigning a skill to the selected trainee.
 *
 * CONCEPTS DEMONSTRATED: JavaFX layouts (BorderPane, VBox, HBox),
 * ListView, event handlers, ArrayList usage.
 */
public class TrainerDashboard {

    private Trainer trainer;
    private List<Trainee> traineeRoster = new ArrayList<>();

    // TODO-1: Write a constructor TrainerDashboard(Trainer trainer).
    //   Assign the trainer field.

    // TODO-2: Write public void show(Stage stage):
    //   a) Create a BorderPane as the root layout.
    //      BorderPane divides the screen into top/left/center/right/bottom.
    //
    //   b) TOP: A Label showing "Welcome, " + trainer.getName()
    //      Place it in a HBox with padding.
    //
    //   c) CENTER: A ListView<String> showing trainee names.
    //      Populate it by looping through traineeRoster.
    //
    //   d) BOTTOM: A row of controls to enroll a new trainee:
    //      TextField idField, TextField nameField, Button enrollButton.
    //      On enrollButton click, call handleEnroll(idField, nameField, listView).
    //
    //   e) Build and show the scene (width 600, height 450).

    // TODO-3: Write private void handleEnroll(TextField idField,
    //                                          TextField nameField,
    //                                          ListView<String> listView):
    //   a) Read id and name from the text fields.
    //   b) Create a new Trainee object (placeholder password for now).
    //   c) Add to traineeRoster.
    //   d) Refresh the ListView: listView.getItems().add(name).
    //   e) Clear the text fields.

    // TODO-4: Write private void handleAssignSkill(Trainee trainee, String skillName):
    //   a) Create a Skill with a generated ID, skillName, and a category.
    //   b) Call trainee.addSkill(skill).
    //   c) Show a confirmation Label or Alert.
    //   (In M3 you'll also persist this to the DB via a SkillDAO.)
}
