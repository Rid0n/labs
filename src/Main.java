import entities.Karlson;
import items.birch_firewood;
import items.*;
public class Main {
    public static void main(String[] args){
        Karlson Karl= new Karlson(1,1);
        fireplace Fireplace = new fireplace(1,1,true,50);
        birch_firewood birch = new birch_firewood(1,1,2);
        kerosine_lamp Lamp = new kerosine_lamp(2,2,false,50);
        workbench WorkBench = new workbench(6,6,2); //learn to map big objects
        Tool Hammer = new Tool(2,6,"To provide strong blunt force");
        Tool Scissors = new Tool(1,6,"To cut through surfaces");
        WorkBench.addItem(Hammer, 1);
        WorkBench.addItem(Scissors, 2);
        room Room = new room();
        //Karl.go
        Fireplace.refuel(birch,1);
        Fireplace.refuel(birch);
        while(Fireplace.isActive()){
            Fireplace.burn_fuel();
            //Fireplace.emitLight(Light_map);
        }
        //change lighting
        //Karlson go to lamp
        //Lamp.Activate();
        //Lamp.burn_fuel();
        //Lamp.emitLight(Light_map);
        //change lighting
    }

}
