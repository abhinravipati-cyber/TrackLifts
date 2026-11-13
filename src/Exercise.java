
public class Exercise {

    private String name;
    private int setsQuantity;

    public Exercise(String name, int setsQuantity) {
        setName(name);
        setSetsQuantity(setsQuantity);
    }

    void setSetsQuantity(int setsQuantity) {
        this.setsQuantity = setsQuantity;
    }

    int getSetsQuantity() {
        return setsQuantity;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
