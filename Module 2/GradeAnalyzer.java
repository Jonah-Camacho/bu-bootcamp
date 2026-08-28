import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {

    public static int skipInt = 0;
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores("scores.txt");

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }

        if (scores.isEmpty()) {
            high = 0;
            low = 0;
        }

        // Step 3: write and print report

        writeReport(scores, avg, high, low, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    skipInt++;
                } else {
                    try {
                        int score = Integer.parseInt(line);
                        scores.add(score);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid value at: " + line);
                        skipInt++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return scores;

    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        
        for (int score : scores) {
            sum += score;
        }

        return sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        // your code here
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int f = 0;

        for (int score : scores) {
            if (score >= 90) {
                a++;
            } else if (score >= 80) {
                b++;
            } else if (score >= 70) {
                c++;
            } else if (score >= 60) {
                d++;
            } else {
                f++;
            }
        }
        try (BufferedWriter writer =
            new BufferedWriter(new FileWriter(outputFile))) {

        writer.write("=== Grade Analysis Report ===\n");
        writer.write(String.format("Total scores processed: %d%n", scores.size()));
        writer.write(String.format("Invalid lines skipped: %d%n", skipInt));
        writer.newLine();

        writer.write(String.format("Average score: %.2f%n", avg));
        writer.write(String.format("Highest score: %d%n", high));
        writer.write(String.format("Lowest score: %d%n", low));
        writer.newLine();

        writer.write("Grade distribution:\n");
        writer.write(String.format("A (90-100): %d%n", a));
        writer.write(String.format("B (80-89): %d%n", b));
        writer.write(String.format("C (70-79): %d%n", c));
        writer.write(String.format("D (60-69): %d%n", d));
        writer.write(String.format("F (below 60): %d%n", f));

    } catch (IOException e) {
        System.out.println("Could not write file: " + e.getMessage());
    }

    System.out.println("=== Grade Analysis Report ===");
    System.out.println("Total scores processed: " + scores.size());
    System.out.println("Invalid lines skipped: " + skipInt);
    System.out.println();

    System.out.println(String.format("Average score: %.2f", avg));
    System.out.println(String.format("Highest score: %d", high));
    System.out.println(String.format("Lowest score: %d", low));
    System.out.println();

    System.out.println("Grade distribution:");
    System.out.println(String.format("A (90-100): %d", a));
    System.out.println(String.format("B (80-89): %d", b));
    System.out.println(String.format("C (70-79): %d", c));
    System.out.println(String.format("D (60-69): %d", d));
    System.out.println(String.format("F (below 60): %d", f));
    }
} 