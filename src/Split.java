import java.util.ArrayList;

public class Split {

	private String name;
	
	// creates an arraylist of workout days, in the split class because split objects will each have a set of workout days
	// use an array list because arraylists can automatically resize as elements are added and removed, so user can choose
	// dayList is private because we want only Split.java to be able to work with the dayList directly, encapsulation.
	private ArrayList<WorkoutDay> dayList = new ArrayList<>();
	
	// populates the split's ArrayList of days with all the different workout days
	void addDay(WorkoutDay...day) {
		for(int i = 0, n = day.length; i < n; i++) {
			dayList.add(day[i]);
		}
	}
	
	WorkoutDay getWorkoutDay(int i) { return dayList.get(i); }
	
	int getSplitLength() { return dayList.size(); }
	
	public Split(String name) { setName(name); }
	
	void setName(String name) { this.name = name; }
	
	String getName() { return name; }
}
