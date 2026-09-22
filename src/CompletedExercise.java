import java.util.ArrayList;
import java.util.Scanner;

public class CompletedExercise {
	
	Scanner scanner = new Scanner(System.in);
	
	Exercise _exercise;
	
	String name;
	 
	ArrayList<CompletedSet> completedSetList = new ArrayList<>();
	
	public CompletedExercise(Exercise exercise) {
		_exercise = exercise;
		name = _exercise.get_name();
	}
	
	void populate_completed_set_list() {
		System.out.println("\n");
		System.out.println(name + "\n");
		System.out.println("Enter the weight and rep counts for each set in this format one at a time ( WEIGHT(lbs), # OF REPS )");
		System.out.println("Type 'done' when you have finished logging this exercise");
		
		do {
			
			String[] parts = scanner.nextLine().split("," );
			
			if (parts[0].equals("done")) {
				break;
			}
			
			int weight = Integer.parseInt(parts[0].trim());
			int repCount = Integer.parseInt(parts[1].trim());
			
			CompletedSet set = new CompletedSet(repCount, weight);
			
			completedSetList.add(set);
			
		} while(true);  
	}
	
	CompletedSet get_completed_set(int i ) {
		return completedSetList.get(i);
	}
	
	int get_completed_set_count(){
		return completedSetList.size();
	}
	
	String get_name() {
		return name;
	}
}
