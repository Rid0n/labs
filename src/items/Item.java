package items;

public abstract class Item /*extends map*/{
    private int[] position = new int[2];
    private String name;
    public Item(int x, int y, String name){
        this.position[0] = x;
        this.position[1] = y;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setX(int x){
        this.position[0] = x;
    }
    public void setY(int y){
        this.position[0] = y;
    }
    public void setPosition(int x,int y){
        this.position[0] = x;
        this.position[1] = y;
    }
    public int getX(){
        return position[0];
    }
    public int getY(){
        return position[1];
    }

    public int[] getPosition() {
        return position;
    }

}