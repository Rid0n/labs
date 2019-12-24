package items;

import java.util.ArrayList;

public class workbench extends items {
    //items on it? !LIST! add/remove
    // SIZE??
    private ArrayList<items> ItemList = new ArrayList<items>();
    public workbench(int x,int y,int size){
        super(x,y);
    }
    public void addItem(items Item,int workbenchX){
        Item.setPosition(workbenchX,this.getY()+1);
        ItemList.add(Item);
        System.out.println("Added to the bench !");
    }
    public ArrayList<items> getItemlist(){
        return ItemList;
    }
    public void removeItem(items Item){
        ItemList.remove(Item);
        System.out.println("Removed from the bench !");
    }
}
