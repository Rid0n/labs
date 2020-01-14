package items;

public class ItemMultiplied extends Matter {
    private String name;
    private int y2;
    private int x2;
    public ItemMultiplied(int x1, int x2,int y1, int y2,String name) {
        super(x1,y1, name);
        this.x2=x2;
        this.y2=y2;
    }
    public int getY2() {
        return y2;
    }
    public int getX2() {
        return x2;
    }
    @Override
    public int[] getPosition(){
        int[] pose = new int[4];
        pose[0] = getX();
        pose[1] = x2;
        pose[2] = getY();
        pose[3] = y2;
        return pose;
    }
    public void setPosition(int x,int x2,int y,int y2){
        setX(x);
        this.x2 = x2;
        setY(y);
        this.y2 = y2;
    }
}
