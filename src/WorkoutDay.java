import java.util.ArrayList;


public class WorkoutDay {

	// creates a name variable that THIS class only will hold and know
	private String name;
	
	// creates an array list of objects, specifically exercises, that each workout day will get in it
	private ArrayList<Exercise> exerciseList = new ArrayList<>();
	
	// this returns the length of the exercise list, to be used for things like for loops and stuff 
	int getWorkoutLength() {
		return exerciseList.size();
	}
	
	// for encapsulation, this returns a specific exercise in the Exercise ArrayList
	Exercise getExercise(int i) {
		return exerciseList.get(i);	
	}
	
	// this is a function to populate the exerciseList for each object of workout day all at once.
	void addExercise(Exercise...exercise ) {
		
		for(int i = 0, n = exercise.length; i < n; i++) {
			exerciseList.add(exercise[i]);
		}
	}
	
	
	
	public WorkoutDay(String name) {
		setName(name);
	}

	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
}
