package items;

public class fireplace extends depletable_light_source {
    private String type = "Fireplace";
    public fireplace(int x,int y, boolean isLIT, int fuel_amount,int maxCapacity) {
        super(x,y, isLIT, fuel_amount, maxCapacity);
    }
    public fireplace(int x,int y, boolean isLIT, int fuel_amount) {
        super(x,y, isLIT, fuel_amount);
    }
}


