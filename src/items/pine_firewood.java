package items;

public class pine_firewood extends firewood {
    private static int burniness = 5; //added time
    public pine_firewood(int x,int y, int size){
        super(x,y, size);
    }
    @Override
    public int getBurntime() {
        return burniness*this.size;
    }
}
