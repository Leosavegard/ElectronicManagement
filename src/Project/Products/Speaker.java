package Project.Products;

import Project.Methods.Methods;

public class Speaker extends ElectronicProducts {

    private int batteryTime;
    private int weight;

    public Speaker(double price, String model, String brand, int batteryTime, int weight) {
        super(price, model, brand);
        this.batteryTime = batteryTime;
        this.weight = weight;
    }

    public int getBatteryTime() {
        return batteryTime;
    }

    public void setBatteryTime(int batteryTime) {
        this.batteryTime = batteryTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + "     Weight:" + Methods.fixString(40,weight + "             " + "Battery time:"
                + Methods.fixString(10, batteryTime + " "));
    }


}