import java.util.ArrayList;


public class User {

    private String name;

    private ArrayList<Split> userSplits = new ArrayList<>();

    private ArrayList<CompletedDay> userHistory = new ArrayList<>();

    void addSplit(Split... splits) {
        for (int i = 0, n = splits.length; i < n; i++) {
            userSplits.add(splits[i]);
        }
    }

    void addCompletedDay(CompletedDay... completedDays) {
        for (int i = 0, n = completedDays.length; i < n; i++) {
            userHistory.add(completedDays[i]);
        }
    }

    Split getSplit(int i) {
        return userSplits.get(i);
    }

    int getSplitCount() {
        return userSplits.size();
    }

    CompletedDay getCompletedDay(int i) {
        return userHistory.get(i);
    }
}
