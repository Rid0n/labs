package mapping;
import items.Item;

import java.lang.*;

public class Prostranstvo {
    private Item[][] myMap;
    private Enum[][] enumMap;
    private int sizeX;
    private int sizeY;
    private LightLevel[][] svetMap;
    String Light;
    public Prostranstvo() {
        this(50, 50);
    }
//    public Prostranstvo(int sizeX, int sizeY,String Light) {
//        this.sizeX = sizeX;
//        this.sizeY = sizeY;
//        this.svetMap = new Svetimost[sizeX][sizeY];
//        for (int i = 0; i <= sizeY - 1; i++) {
//            for (int j = 0; j <= sizeX - 1; j++) {
//
//
//                    if (((getSizeX()+getSizeY())-(i+j))<5){ // distance from light source to point
//                        this.svetMap[i][j] = Svetimost.OchBlizko; //light intensity
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<10){
//                        this.svetMap[i][j] = Svetimost.Blizko;
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<15){
//                        this.svetMap[i][j] = Svetimost.NetakNeedak;
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<20){
//                        this.svetMap[i][j] = Svetimost.Daleko;
//                    }
//                    if (((getSizeX()+getSizeY())-(i+j))<25){
//                        this.svetMap[i][j] = Svetimost.OchenDaleko;
//                    }
//                }
//
//        }
//    }



            //constant check -> recheck



    public Prostranstvo(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.myMap = new Item[sizeX][sizeY];
        this.enumMap = new Enum[sizeX][sizeY];
        this.svetMap = new LightLevel[sizeX][sizeY];

        for (int i = 0; i <= sizeY-1; i++) {
            for (int j = 0; j <= sizeX-1 ; j++) {
                this.enumMap[i][j] = Enum.Air;
                if (j == 0) {
                    this.enumMap[i][j] = Enum.Surface;
                }else {
                    if (i == 0 | i == sizeX-1) {
                        this.enumMap[i][j] = Enum.Wall;
                    }
                }
            }
        }

    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
    public void AddIstSveta(Item obj, int svetimost){
        for (int i = 0; i <= sizeY - 1; i++) {
            for (int j = 0; j <= sizeX - 1; j++) {

                if (i==obj.getY() && j ==obj.getX()){
                this.svetMap[i][j] = LightLevel.Daleko;
                }else {
                    if ((Math.abs(-obj.getX() - obj.getY() + (i + j))) < 3) { // distance from light source to point
                        this.svetMap[i][j] = LightLevel.OchBlizko; //light intensity
                    } else if ((Math.abs(-obj.getX() - obj.getY() + (i + j))) < 2 * svetimost) {
                        this.svetMap[i][j] = LightLevel.Blizko;
                    } else if ((Math.abs(-obj.getX() - obj.getY() + (i + j))) < 4 * svetimost) {
                        this.svetMap[i][j] = LightLevel.NetakNeedak;
                    } else if ((Math.abs(-(obj.getX() - obj.getY()) + (i + j))) < 6 * svetimost) {
                        this.svetMap[i][j] = LightLevel.Daleko;
                    } else if (((obj.getX() - obj.getY()) + (i + j)) < 500) {
                        this.svetMap[i][j] = LightLevel.OchenDaleko;
                    }
                }
            }

        }
        showLightMap();
    }

    public void AddMultlObjOnMap(Item obj) {

        for (int i = obj.getY2(); i >= obj.getY(); i--) {
            for (int j = obj.getX(); j < obj.getX2(); j++) {
                if (this.getObjInCoord(i,j) == null) {
                    this.myMap[i][j] = obj;
                }
                else{
                    System.out.println("Это Место уже занято(");
                }
            }
        }

    }

    public int getX1KoordOfMultObj(Item obj) {
        return obj.getX();
    }

    public int getX2KoordOfMultObj(Item obj) {
        return obj.getX2();
    }

    public int getY1KoordOfMultObj(Item obj) {
        return obj.getY();
    }

    public int getY2KoordOfMultObj(Item obj) {
        return obj.getY2();
    }

    public void AddOnMap(Item obj) {
        if (this.getObjInCoord(obj.getX(), obj.getY()) == null) {
            if(this.myMap[obj.getX()][obj.getY() - 1] != null) {
                //this.myMap[obj.getX()][obj.getY()] = obj;
                System.out.println(obj.toString() + " уже здесь!");
            }else if(this.enumMap[obj.getX()][obj.getY()-1] != Enum.Air){
                this.myMap[obj.getX()][obj.getY()] = obj;
                System.out.println(obj.toString() + " уже здесь!");
            } else {
                for (int i = obj.getY(); this.myMap[obj.getX()][i-1] == null;i--) {
                    if(this.enumMap[obj.getX()][i-1] == Enum.Air) {
                        this.myMap[obj.getX()][i] = obj;
                        System.out.println(obj.toString() + "Падает!");
                        showMap();
                        moveObj(obj.getX(), i, obj.getX(), i - 1);
                    }
                    else{
                        showMap();
                        break;
                    }
                }
            }
            System.out.println(obj.toString() + " уже здесь!");
            this.myMap[obj.getX()][obj.getY()] = obj;
        }
        else{
            System.out.println("Это место уже занято(");
        }
    }

    public Item getObjInCoord(int x, int y) {
        return this.myMap[x][y];
    }

    public Enum getEnumInCoord(int x, int y) {
        return this.enumMap[x][y];
    }
    public LightLevel getSvetimostInCoord(int x,int y){
        return this.svetMap[x][y];
    }
    public void moveObj(int x, int y, int xwant, int ywant) {
        Item obj = this.getObjInCoord(x, y);
        this.myMap[xwant][ywant] = obj;
        deleteObj(x,y);
    }

    public void deleteObj(int x, int y) {
        this.myMap[x][y] = null;
    }
    public void showLightMap(){
        String s = "";
        for (int i = this.sizeY-1; i >= 0; i--) {
            for (int j = 0; j < this.sizeX; j++) {
                String p = " ";
                LightLevel sv = this.getSvetimostInCoord(j, i);
                Enum en = this.getEnumInCoord(j, i);
                Object obj = this.getObjInCoord(j,i);
                if (obj != null) {
                    p = " " + obj.getClass().getSimpleName().toCharArray()[0]+" ";
                } else {
                    switch (en) {
                        case Wall:
                            p = "|";
                            break;
                        case Surface:
                            p = "‾‾‾";
                            break;
                        case Air:
                            switch (sv) {
                                case OchBlizko:
                                    p = " * ";
                                    break;
                                case Blizko:
                                    p = " & ";
                                    break;
                                case NetakNeedak:
                                    p = " @ ";
                                    break;
                                case Daleko:
                                    p = " . ";
                                    break;
                                case OchenDaleko:
                                    p = " / ";
                                    break;
                            };
                            break;
                    }

                    }
                s += p;
            }
            s += "\n";
        }
        System.out.println(s);
    }
    public void showMap() {

        String s = "";
        for (int i = this.sizeY-1; i >= 0; i--) {
            for (int j = 0; j < this.sizeX; j++) {
                String p = " ";
                Object obj = this.getObjInCoord(j, i);
                Enum en = this.getEnumInCoord(j, i);
                if (obj != null) {
                    p = " " + obj.getClass().getSimpleName().toCharArray()[0]+" ";
                } else {
                    switch (en) {
                        case Wall:
                            p = "|";
                            break;
                        case Surface:
                            p = "‾";
                            break;
                        case Air:
                            p = " . ";
                            break;
                    }
                }
                s += p;
            }
            s += "\n";
        }
        System.out.println(s);
    }
}