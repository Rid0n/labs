import entities.*;

import items.*;
import mapping.Prostranstvo;


public class Main {
    public static void main(String[] args){
        Action act = new Action();

        Karlson karl= new Karlson(6,3,"карлсон");
        Fireplace fireplace = new Fireplace(1,1,true,3);
        act.addLightToList(fireplace);

        BirchFirewood birch1 = new BirchFirewood(15,11,2);
        BirchFirewood birch2 = new BirchFirewood(16,12,2);

        KerosineLamp lamp = new KerosineLamp(48,22,false,10);


        Workbench workbench = new Workbench(35,49,1,7,"workbench"); //learn to map big objects

        Tool hammer = new Tool(5,6,"hammer","To provide strong blunt force");
        Tool scissors = new Tool(7,6, "scissors","To cut through surfaces");

        SittableOnItem chair = new SittableOnItem(31,35,1,4,"Wood","chair",4);

        Prostranstvo map = new Prostranstvo();
        map.addOnMap(birch1);
        map.addOnMap(birch2);
        map.addOnMap(hammer);
        map.addMultlObjOnMap(chair);
        map.addOnMap(scissors);
        map.addMultlObjOnMap(workbench);
        map.addIstSveta(fireplace);

        map.addOnMap(karl);

        workbench.addItem(hammer, 1,map);
        workbench.addItem(scissors, 2,map);

        map.moveObj(karl, 2,1);
        System.out.println("Карлсон подошел к Камину");


        act.refreshEnvironment(); // взял за руку

        //karl.action(birch,1,fireplace::);
        fireplace.refuel(birch1,1); // уверенно сказал
        map.deleteObj(birch1);
        System.out.println("Карлсон вкинул бревно");
        map.showLightMap();
        act.refreshEnvironment();
        fireplace.refuel(birch1);
        System.out.println("Карлсон вкинул бревно");
        map.deleteObj(birch2);
        map.showLightMap();
        act.refreshEnvironment();


        while(fireplace.isActive()){
            map.showLightMap();
            act.refreshEnvironment();
        }
        System.out.println("Камин прогорел");


        map.moveObj(karl,lamp.getX(),lamp.getY()-1);
        System.out.println("Карлсон подлетел к лампе");
        //!!!!!
        karl.action(lamp::activate);
        System.out.println("Карлсон включил лампу");
        act.addLightToList(lamp);
        map.leaveLightFrom(lamp);

        act.refreshEnvironment();
        map.showLightMap();


    }

}
