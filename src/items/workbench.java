package items;

import mapping.Prostranstvo;

import java.util.ArrayList;
import java.util.List;

public class Workbench extends ItemMultiplied {
    //items on it? !LIST! add/remove
    // SIZE??
    private static String name = "Workbench";
    private List<Matter> ItemList = new ArrayList<Matter>();
    public Workbench(int x1,int x2,int y1,int y2,String name){
        super(x1,x2,y1,y2,name);

    }
    public void addItem(Matter item, int workbenchX, Prostranstvo map){
        int justAboveWorkbench = getY2()+1;
        map.moveObj(item,(getX() + workbenchX),justAboveWorkbench);
        ItemList.add(item);
    }
    public List<Matter> getItemlist(){
        return ItemList;
    }
    public void removeItem(Matter item){
        ItemList.remove(item);
        System.out.println(item.getName() + " was removed from the workbench !");
    }
}
