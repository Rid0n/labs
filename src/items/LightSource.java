package items;

import java.util.Objects;

public abstract class LightSource extends Item implements LightInterface {
    private boolean isLIT;

    private int intensity;
    public LightSource(int x, int y, boolean isLIT, String name){
        super(x,y,name);
        this.isLIT = isLIT;

    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getIntensity() {
        return intensity;
    }

    public void activate(){
        this.isLIT = true;
    }
    public void deactivate(){
        this.isLIT = false;
    }
    public boolean isActive(){
        return isLIT;
    }
//    public void emitLight(map map){
//        if (isLIT){
//            for (int i = 0;i<sizex;i++){
//                for (int j = 0;j<sizey;j++){
//                    int d = ((getX()+getY())-(i+j));
//                    map[i][j] = intensity/d/d; // light intensity decreases with square of distance
//                }
//            }
//        }//constant check -> recheck
//    }
    public void emitLight() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightSource that = (LightSource) o;
        return getX() == that.getX() && getY() == that.getY() && isLIT == that.isLIT && getName().equals(that.getName());
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(getX(), getY());
        result = 31 * result + getName().hashCode();
        result = 31 * result + Boolean.valueOf(isLIT).hashCode();
        return result;
    }
    @Override
    public String toString() {
        return ("Light source type is " + getName() + " and it is at x" + getX() + "y" + getY());
    }
}
