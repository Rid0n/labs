package entities;

//do
import items.Matter;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Karlson extends Entity {
    public Karlson(int x,int y,String name){
        super(x,y,name);
    }

    public void action(Runnable method){
        method.run();
    }
    public void action(Matter item, Consumer<Matter> method){
        method.accept(item);
    }
    public void action(Matter item, int count, BiConsumer<Matter,Integer> method){
        method.accept(item,count);
    }
    // Consumer Supplier Runnable Function
    /* functions
    подкинуть полено - передать параметры полена
    зажечь лампу - передать колво топлива
    погасить
    ходить
    садиться
    вставать
    взять со стола
    поставить на стол
     */

}
