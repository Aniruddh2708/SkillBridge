package service;

import model.Trainee;
import model.Skill;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;

/**
 * Handles exporting a Trainee's portfolio to disk.
 *
 * Two export formats:
 *   1. Human-readable text file (.txt) — for printing / emailing
 *   2. Binary serialized file (.ser)   — for loading back into the app
 *
 * CONCEPTS DEMONSTRATED: File I/O (BufferedWriter, FileWriter),
 * Object Serialization (ObjectOutputStream), IOException handling,
 * try-with-resources (auto-closes streams).
 */
public class PortfolioExporter {

    // TODO-1: Declare a private static final String BASE_PATH = "portfolios/";
    //   This is the folder where all exported files will be saved.
    //   (Create the folder manually or add mkdir logic in the methods below.)

    // --- Text export ----------------------------------------------------
    /**
     * Writes the trainee's profile and skill list to a plain text file.
     *
     * Output file: portfolios/<userId>_portfolio.txt
     *
     * @param trainee The trainee whose portfolio to export.
     * @throws IOException If the file cannot be written.
     */
    public void exportToText(Trainee trainee) throws IOException {
        // TODO-2: Build the file path: BASE_PATH + trainee.getUserId() + "_portfolio.txt"

        // TODO-3: Use try-with-resources to open a BufferedWriter:
        //   try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        //
        //   WHY BufferedWriter? It buffers characters in memory and flushes
        //   in bulk — much faster than writing one character at a time.
        //
        //   WHY try-with-resources? Java automatically calls writer.close()
        //   even if an exception is thrown. No finally block needed!

        // TODO-4: Inside the try block, write lines like:
        //   writer.write("=== SkillBridge Portfolio ===");
        //   writer.newLine();
        //   writer.write("Name: " + trainee.getName());
        //   writer.newLine();
        //   writer.write("Date: " + LocalDate.now());
        //   writer.newLine();
        //   writer.write("--- Skills ---");
        //   writer.newLine();
        //   Then loop through trainee.getSkills() and write each skill's toString().
    }

    // --- Binary / serialized export -------------------------------------
    /**
     * Serializes the entire Trainee object to a binary file.
     *
     * Output file: portfolios/<userId>_portfolio.ser
     *
     * @param trainee The trainee to serialize.
     * @throws IOException If serialization fails.
     */
    public void exportSerialized(Trainee trainee) throws IOException {
        // TODO-5: Build the file path: BASE_PATH + trainee.getUserId() + "_portfolio.ser"

        // TODO-6: Use try-with-resources with ObjectOutputStream:
        //   try (ObjectOutputStream oos =
        //           new ObjectOutputStream(new FileOutputStream(filePath))) {
        //       oos.writeObject(trainee);
        //   }
        //
        //   oos.writeObject() converts the entire Trainee (and its Skill list)
        //   into bytes and writes them to disk. This works because both
        //   Trainee and Skill implement Serializable.
    }
}
