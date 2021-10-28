package Project.Products;

import Project.Methods.Methods;

public class Monitor extends ElectronicProducts {

    private double size;
    private double refreshRate;

    public Monitor(double price, String model, String brand, double size, double refreshRate) {
        super(price, model, brand);
        this.size = size;
        this.refreshRate = refreshRate;
    }

    @Override
    public String toString() {
        return  super.toString() + "     Size:" + Methods.fixString(40, String.valueOf(size) + "            " + "RefreshRate:" + Methods.fixString(10,String.valueOf(refreshRate)));
    }



    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    @Override
    public double getPrice() {
        setSalePrice();


        if (isSalePrice()) {
            return (0.7 * getFullPrice());

        } else {
            return getFullPrice();
        }
    }

}
