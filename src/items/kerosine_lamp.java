package items;

public class kerosine_lamp extends depletable_light_source { // lets be in percent
    private String type = "Kerosine lamp";
    public kerosine_lamp(int x,int y,boolean isLIT, int fuel_amount, int maxCapacity){
        super(x,y, isLIT, fuel_amount,maxCapacity);
    }
    //func for fuel amount change(fuel type)
    public kerosine_lamp(int x,int y,boolean isLIT, int fuel_amount){
        super(x,y, isLIT, fuel_amount);
    }
    @Override
    public String getType() {
        return type;
    }
}
