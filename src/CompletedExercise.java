import java.util.ArrayList;

public class CompletedExercise {
	
	Exercise exercise;
	
	String name;
	 
	ArrayList<CompletedSet> completedSetList = new ArrayList<>();
	
	public CompletedExercise(Exercise exercise) {
		this.exercise = exercise;
		name = exercise.getName();
	}
	
	// adds completed sets to this exercise's set list, the input for them is handled in Main
	void addCompletedSet(CompletedSet...sets) {
		for(int i = 0, n = sets.length; i < n; i++) {
			completedSetList.add(sets[i]);
		}
	}
	
	CompletedSet getCompletedSet(int i ) {
		return completedSetList.get(i);
	}
	
	int getCompletedSetCount(){
		return completedSetList.size();
	}
	
	String getName() {
		return name;
	}
}
