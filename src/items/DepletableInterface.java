package items;

public interface DepletableInterface {
    void refuel(Firewood burnTime, int amount);
    void refuel(Firewood burnTime);
    boolean fueled();
    int getFuelAmount();
    int getMaxCapacity();
}
