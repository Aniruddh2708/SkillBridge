package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import model.Trainee;
import model.Skill;
import service.PortfolioExporter;

import java.io.IOException;

/**
 * Trainee Dashboard — the main screen for an authenticated Trainee.
 *
 * Features:
 *   1. Display trainee's name and enrollment year.
 *   2. Show a list of assigned skills with their status and scores.
 *   3. Show certificate eligibility status.
 *   4. Button to export portfolio as a text file.
 *
 * CONCEPTS DEMONSTRATED: JavaFX, calling service layer (PortfolioExporter),
 * conditional UI (show certificate badge if eligible).
 */
public class TraineeDashboard {

    private Trainee trainee;

    // TODO-1: Write a constructor TraineeDashboard(Trainee trainee).

    // TODO-2: Write public void show(Stage stage):
    //   a) Create a BorderPane root.
    //
    //   b) TOP: Label with "Hello, " + trainee.getName()
    //           + " | Enrolled: " + trainee.getEnrollmentYear()
    //
    //   c) CENTER: A ListView<String> showing each skill as:
    //      skill.toString()  (uses the toString you write in Skill.java)
    //      Loop through trainee.getSkills() to populate it.
    //
    //   d) Build a VBox for the bottom area:
    //      - A Label showing "Certificate Status: ELIGIBLE ✅" or "NOT YET ⏳"
    //        based on trainee.isEligibleForCertificate().
    //      - An "Export Portfolio" button.
    //
    //   e) On Export button click, call handleExport().

    // TODO-3: Write private void handleExport():
    //   a) Create a PortfolioExporter.
    //   b) Call exporter.exportToText(trainee).
    //   c) Catch IOException and show an error label.
    //   d) On success, show a "Portfolio saved!" confirmation label.
}
