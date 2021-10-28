package Project.Products;


import Project.Methods.Methods;

import static Project.ElectronicProductManagement.*;

import java.io.Serializable;
import java.text.DecimalFormat;


public abstract class ElectronicProducts implements Comparable<ElectronicProducts>, Serializable {




    public static DecimalFormat x = new DecimalFormat("#0.00");
    private double price;
    private String model;
    private String brand;
    private int productId;
    boolean salePrice = false;

    static int productIdGenerator = 100;

    public ElectronicProducts(double price, String model, String brand) {

        if(products.size()!=0) {
            productIdGenerator= products.get(products.size() - 1).productId + 1;}
        this.price = price;
        this.model = model;
        this.brand = brand;
        this.productId = productIdGenerator++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isSalePrice() {
        return salePrice;


    }

    public void setSalePrice() {
        String date = java.time.LocalDate.now().toString();
        if (date.substring(5, 7).equals("09")) {

            salePrice = true;
        } else if (date.substring(5, 7).equals("12")) {
            salePrice = true;
        } else salePrice = false;

    }

    public double getPrice() {
        setSalePrice();


        if (isSalePrice()) {
            return (0.5 * price);

        } else {
            return price;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return  "ID:" + Methods.fixString(10,String.valueOf(productId)) + "  " +
                "Brand:" + Methods.fixString(10,String.valueOf(brand))+ "      " +
                "Model:" + Methods.fixString(15,model) +"    " +
                "Price:" + Methods.fixString(10,x.format(getPrice()));

    }

    public double getFullPrice() {
        return price;

    }
    public int compareTo(ElectronicProducts o) {
        if (this.getPrice() > o.getPrice())
            return 1;
        else if (this.getPrice()==o.getPrice())
            return 0;
        else return -1;

    }
}