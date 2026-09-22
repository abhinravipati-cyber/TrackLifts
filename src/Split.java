import java.util.ArrayList;
import java.util.Scanner;

public class Split {

	Scanner scanner = new Scanner(System.in);
	
	private String _name;
	
	// creates an arraylist of workout days, in the split class because split objects will each have a set of workout days
	// use an array list because arraylists can automatically resize as elements are added and removed, so user can choose
	// dayList is private because we want only Split.java to be able to work with the dayList directly, encapsulation.
	private ArrayList<WorkoutDay> dayList = new ArrayList<>();
	
	// populates the split's ArrayList of days with all the different workout days
	void add_day(WorkoutDay...day) {
		for(int i = 0, n = day.length; i < n; i++) {
			dayList.add(day[i]);
		}
	}
	
	// for loops ruins as many times as how many days there are, and then gets input for a name for the day and then makes a workoutDay object
	// and then adds that new workout day to the day List of the split
	void populate_split(int splitLength) {
		for(int i = 0; i < splitLength; i++) {
			System.out.println("Make a name for day " + (i + 1) + ":");
			String name = scanner.nextLine();
			WorkoutDay day = new WorkoutDay(name);
			
			dayList.add(day);
		}
	}
	
	WorkoutDay get_workout_day(int i) {
		return dayList.get(i);
	}
	
	int get_split_length() {
		return dayList.size();
	}
	
	public Split(String name) {
		set_name(name);
	}
	
	void set_name(String name) {
		_name = name;
	}
	
	String get_name() {
		return _name;
	}
}
