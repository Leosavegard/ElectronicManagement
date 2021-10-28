package Project.Products;

import Project.Methods.Methods;

public class Phone extends ElectronicProducts {
    private double size;
    private int memory;

    public Phone(double price, String model, String brand, double size, int memory) {
        super(price, model, brand);
        this.size = size;
        this.memory = memory;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }


    @Override
    public String toString() {
        return super.toString() + "     Size:" + Methods.fixString(40, String.valueOf(size) + "            " +  " Memory:" + Methods.fixString(10, String.valueOf(memory)));
    }


}
