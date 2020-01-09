import entities.*;
import items.BirchFirewood;
import items.*;
//import mapping.Prostranstvo;


public class Main {
    public static void main(String[] args){
        Action act = new Action();

        Karlson karl= new Karlson(1,1);
        Fireplace fireplace = new Fireplace(1,1,true,50);
        act.addLightToList(fireplace);

        BirchFirewood birch = new BirchFirewood(1,1,2);

        KerosineLamp lamp = new KerosineLamp(2,2,false,50);
        act.addLightToList(lamp);

        Workbench workbench = new Workbench(6,6,2); //learn to map big objects

        Tool hammer = new Tool(2,6,"hammer","To provide strong blunt force");
        Tool scissors = new Tool(1,6, "scissors","To cut through surfaces");

        workbench.addItem(hammer, 1);
        workbench.addItem(scissors, 2);

        room room = new room();

//        Prostranstvo Map = new Prostranstvo();
//        Map.AddOnMap(lamp);
//        Map.AddMultlObjOnMap(workbench);
//        Map.AddOnMap(birch);
//        Map.ShowMap();
//        Map.AddIstSveta(fireplace,3);

        //light_map Light_map = new light_map();
        //karl.go
        act.refresh_env();

        fireplace.refuel(birch,1);
        act.refresh_env();
        fireplace.refuel(birch);
        act.refresh_env();

//        while(fireplace.isActive()){
//            fireplace.burn_fuel();
//            //fireplace.emitLight(Light_map);
//        }
        //change lighting
        //Karlson go to lamp
        lamp.activate();
        act.refresh_env();

        //System.out.println(act.actions(karl::getX));
        //change lighting
    }

}
