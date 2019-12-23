package items;

public abstract class light_source extends items implements Light_interface {
    protected boolean isLIT;
    protected static String type;
    public light_source(int x, int y, boolean isLIT){
        super(x,y);
        this.isLIT = isLIT;

    }
    public void Activate(){
        this.isLIT = true;
    }
    public void Deactivate(){
        this.isLIT = false;
    }
    public boolean isActive(){
        return isLIT;
    }
    public void emitLight(){
        if (isLIT){
            //what how
        }//constant check -> recheck
    }

}
