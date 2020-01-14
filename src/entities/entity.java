package entities;

import items.Matter;

public abstract class Entity extends Matter {
    public Entity(int x, int y,String name){
        super(x,y,name);
    }

    public String talk(String phrase){
        return phrase;
    }

}
