public class ConsoleUI {

    static void run() {
        // user1 is a variable that points to a User type object
        User user1 = new User();

        while (true) {
            // this will later determine what will happen during this program usage
            int iniResponse = InputReader.readInt("Would you like to (1) make a split, (2) view a split, (3) log a workout, (4) quit");

            // user inputs 1, so they will be able to create a split
            if (iniResponse == 1) {
                Split newSplit = createSplit();
                user1.addSplit(newSplit);
                displaySplit(newSplit);
            }
            // user inputs 2, so they will choose a split and then that split will be displayed
            else if (iniResponse == 2) {
                if (user1.getSplitCount() == 0) {
                    System.out.println("no splits to display kid :(");
                    continue;
                }
                System.out.print("Which split do you want to display? ");
                for (int i = 0, n = user1.getSplitCount(); i < n; i++) {
                    System.out.print(" (" + (i + 1) + ") " + user1.getSplit(i).getName());
                }
                // readInt("") prints the newline that ends the list above
                int splitIdentifier = InputReader.readInt("", 1, user1.getSplitCount()) - 1;
                displaySplit(user1.getSplit(splitIdentifier));
            }
            //user inputs 3, so they will have the option to log a workout
            else if (iniResponse == 3) {
                if (user1.getSplitCount() == 0) {
                    System.out.println("create a split before you can log a workout!");
                    continue;
                }
                System.out.print("Which split are you logging for? ");
                for (int i = 0, n = user1.getSplitCount(); i < n; i++) {
                    System.out.print(" (" + (i + 1) + ") " + user1.getSplit(i).getName());
                }
                // readInt("") prints the newline that ends the list above
                int splitIdentifier = InputReader.readInt("", 1, user1.getSplitCount()) - 1;
                Split selectedSplit = user1.getSplit(splitIdentifier);
                CompletedDay completedDay = logWorkout(selectedSplit);
                user1.addCompletedDay(completedDay);
                displayLog(completedDay);
            } else if (iniResponse == 4) {
                System.out.println("Sorry to see u go :(");
                break;
            } else {
                System.out.println("Invalid Response");
            }
        }

    }


    //creates the split and returns back a new split to a variable in the main method
    static Split createSplit() {
        // gets input for name of the new split and then make a new split object with that name
        System.out.println("Name your split below:");
        String splitName = InputReader.scanner.nextLine();
        Split split1 = new Split(splitName);

        // get user input for the count of days in the new split and then populate the newly-made split object with that number of workout days
        int splitLength = InputReader.readInt("How many different days are in your split cycle.");

        // gets a name for each day, makes a WorkoutDay object with that name, and adds it to the split
        for (int i = 0; i < splitLength; i++) {
            System.out.println("Make a name for day " + (i + 1) + ":");
            String dayName = InputReader.scanner.nextLine();
            split1.addDay(new WorkoutDay(dayName));
        }

        // this loops for the amount of days there are and populates each of its workout days
        for (int i = 0; i < splitLength; i++) {
            int workoutLength = InputReader.readInt("How many different exercises are on " + split1.getWorkoutDay(i).getName() + " day:");

            populateWorkoutDay(split1.getWorkoutDay(i), workoutLength);
        }
        return split1;
    }

    // gets input for each exercise on a workout day (name and number of sets) and adds them to that workout day
    static void populateWorkoutDay(WorkoutDay day, int workoutLength) {
        for (int i = 0; i < workoutLength; i++) {
            day.addExercise(InputReader.readExercise());
        }
    }

    //displays the split
    static void displaySplit(Split split1) {
        System.out.println(split1.getName() + "!");
        for (int i = 0, n = split1.getSplitLength(); i < n; i++) {
            System.out.println(split1.getWorkoutDay(i).getName() + ":");
            for (int j = 0, m = split1.getWorkoutDay(i).getWorkoutLength(); j < m; j++) {
                System.out.println(split1.getWorkoutDay(i).getExercise(j).getSetsQuantity() + " sets of " + split1.getWorkoutDay(i).getExercise(j).getName());
            }
        }
    }

    //logs a workout
    static CompletedDay logWorkout(Split split1) {
        //gets the date that will be used as an attribute of each CompletedDay
        System.out.println("What's the date?");
        String date = InputReader.scanner.nextLine();

        //get input for which day it was that they just worked out
        System.out.print("Which workout did you do? ");
        for (int i = 0, n = split1.getSplitLength(); i < n; i++) {
            System.out.print(" (" + (i + 1) + ") " + split1.getWorkoutDay(i).getName());
        }
        // readInt("") prints the newline that ends the list above
        int dayIdentifier = InputReader.readInt("", 1, split1.getSplitLength()) - 1;
        // create new completedDay
        CompletedDay completedDay1 = new CompletedDay(date, split1.getWorkoutDay(dayIdentifier));

        completedDay1.autofillCompletedExercises();

        for (int i = 0, n = split1.getWorkoutDay(dayIdentifier).getWorkoutLength(); i < n; i++) {
            populateCompletedSetList(completedDay1.getCompletedExercise(i));
        }
        return completedDay1;
    }

    // gets input for each set of a completed exercise (weight and reps) until the user types done
    static void populateCompletedSetList(CompletedExercise completedExercise) {
        System.out.println(completedExercise.getName());
        System.out.println("Enter the weight and rep counts for each set in this format one at a time ( WEIGHT(lbs), # OF REPS )");
        System.out.println("Enter \"done\" when you are finished");

        while (true) {
            String[] parts = InputReader.scanner.nextLine().split(",");

            if (parts.length > 0 && parts[0].trim().toLowerCase().equals("done")) {
                break;
            }
            if (parts.length != 2 || parts[0].trim().isEmpty()) {
                System.out.println("Your input should be a comma separated list \n Example \"135, 3\"");
                continue;
            }
            try {
                int weight = Integer.parseInt(parts[0].trim());
                int repCount = Integer.parseInt(parts[1].trim());
                if (weight < 0 || repCount < 0) {
                    System.out.println("How'd you move negative weight?!");
                    continue;
                }
                completedExercise.addCompletedSet(new CompletedSet(repCount, weight));
            } catch (NumberFormatException e) {
                System.out.println("Should be two numbers");
            }
        }
    }

    //display previously logged workout
    static void displayLog(CompletedDay completedDay1) {
        System.out.println(completedDay1.getDate() + " - " + completedDay1.getName());

        for (int i = 0, n = completedDay1.getWorkoutLength(); i < n; i++) {
            System.out.println("\n Exercise " + (i + 1) + ": " + completedDay1.getCompletedExercise(i).getName());
            for (int j = 0, m = completedDay1.getCompletedExercise(i).getCompletedSetCount(); j < m; j++) {
                System.out.println("Set " + (j + 1) + ": " + completedDay1.getCompletedExercise(i).getCompletedSet(j).getWeight() + "lbs for " +
                        completedDay1.getCompletedExercise(i).getCompletedSet(j).getRepCount() + " reps");
            }
        }
    }
}
