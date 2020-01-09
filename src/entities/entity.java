package entities;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Entity {
    int[] position = new int[2];
    public Entity(int x, int y){
        this.position[0] = x;
        this.position[1] = y;
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
