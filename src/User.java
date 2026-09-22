import java.util.ArrayList;


public class User {

	String _name;
	
	ArrayList<Split> userSplits = new ArrayList<>();
	
	ArrayList<CompletedDay> userHistory = new ArrayList<>();
	
	void add_split(Split...splits ) {
		for(int i = 0, n = splits.length; i < n; i++) {
			userSplits.add(splits[i]);
		}
	}
	
	void add_completed_day(CompletedDay...completedDays) {
		for(int i = 0, n = completedDays.length; i < n; i++) {
			userHistory.add(completedDays[i]);
		}
	}
	
	Split get_split(int i) {
		return userSplits.get(i);
	}
	
	int get_split_count() {
		return userSplits.size();
	}
	
	CompletedDay get_completed_day(int i) {
		return userHistory.get(i);
		}
	}
