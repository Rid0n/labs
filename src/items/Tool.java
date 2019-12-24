package items;

public class Tool extends items {
    private String use;
    public Tool(int x,int y,String use){
        super(x,y);
        this.use = use;
    };
    public void setUse(String use){
        this.use = use;
    }
    public String getUse() {
        return use;
    }

}
