import java.util.Scanner;

public class InputReader {

    static Scanner scanner = new Scanner(System.in);

    // prompts the user using the String value passed in and returns the input, input validates
    static int readInt(String prompt) {

        int res;
        while (true) {
            String input;
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            try {
                res = Integer.parseInt(input);
                return res;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input format. Please enter an integer in numeric form. \n Example: \"2\"");
            }
        }
    }

    // same as readInt(prompt), but keeps asking until the number is between min and max (inclusive)
    static int readInt(String prompt, int min, int max) {
        int res;
        while (true) {
            res = readInt(prompt);
            if (res < min || res > max) {
                System.out.println("choose from one of the options!");
            } else {
                return res;
            }
        }
    }

    // constructs and returns an exercise object from input
    static Exercise readExercise() {
        while (true) {
            System.out.println("Please enter a name and how many sets (NAME, # OF SETS):");
            String[] parts = scanner.nextLine().split(",");
            if (parts.length != 2 || parts[0].trim().isEmpty()) {
                System.out.println("Your input should be a comma separated list \n Example \"Bench Press, 3\"");
                continue;
            }
            String name = parts[0].trim();
            try {
                int sets = Integer.parseInt(parts[1].trim());
                if (sets < 1) {
                    System.out.println("Why do you have less than one set, try again.");
                    continue;
                }
                return new Exercise(name, sets);
            } catch (NumberFormatException e) {
                System.out.println("Your set count should be in numeric form");
            }
        }
    }
}
