import java.util.ArrayList;


public class CompletedDay {

    private String date;
    private WorkoutDay workoutDay;
    private String name;
    private int workoutLength;

    private ArrayList<CompletedExercise> completedExerciseList = new ArrayList<>();

    public CompletedDay(String date, WorkoutDay workoutDay) {
        setDate(date);
        this.workoutDay = workoutDay;
        name = workoutDay.getName();
        workoutLength = workoutDay.getWorkoutLength();
    }

    //creates all completed exercise while passing in the regular Exercise as an argument
    void autofillCompletedExercises() {

        for (int i = 0, n = workoutDay.getWorkoutLength(); i < n; i++) {
            CompletedExercise completedExercise = new CompletedExercise(workoutDay.getExercise(i));

            completedExerciseList.add(completedExercise);
        }

    }

    void setDate(String date) {
        this.date = date;
    }

    CompletedExercise getCompletedExercise(int i) {
        return completedExerciseList.get(i);
    }

    String getDate() {
        return date;
    }

    WorkoutDay getWorkoutDay() {
        return workoutDay;
    }

    String getName() {
        return name;
    }

    int getWorkoutLength() {
        return workoutLength;
    }
}
