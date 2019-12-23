package items;

public class kerosine extends items {
    private int size;
    private static int burniness = 40;
    public kerosine(int x,int y, int size){
        super(x,y);
        this.size = size;
    };
    public int getBurntime() {
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }
}
