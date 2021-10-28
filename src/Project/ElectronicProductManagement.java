package Project;

import Project.Products.ElectronicProducts;
import Project.Products.Monitor;
import Project.Products.Phone;
import Project.Products.Speaker;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;


import static Project.UI.*;
import static Project.Methods.Methods.*;
import static Project.Products.ElectronicProducts.x;

public class ElectronicProductManagement {

    public static ArrayList<ElectronicProducts> products = new ArrayList<>();

    static DoubleSummaryStatistics stat = products.stream().mapToDouble(e -> e.getPrice()).summaryStatistics();
    static Comparator<ElectronicProducts> sortIdIncreasing = (o1, o2) -> o1.getProductId() - o2.getProductId();


    public static void addProductOptions() {
        boolean addProductLoop = true;
        while (addProductLoop) {
            addProductMenu();
            int choice = readInt();
            switch (choice) {

                case 1 -> addProduct(createMonitor());
                case 2 -> addProduct(createPhone());
                case 3 -> addProduct(createSpeaker());
                case 0 -> addProductLoop = false;

            }
        }

    }

    public static Phone createPhone() {


        System.out.print("Brand:");
        String brand = readString();

        System.out.print("Price: ");
        double price = readDouble();


        System.out.print("Model:");
        String model = readString();

        System.out.print("size:");
        double size = readDouble();

        System.out.print("Memory: ");
        int memory = readInt();

        return new Phone(price, brand, model, size, memory);


    }

    public static Monitor createMonitor() {

        System.out.print("Brand:");
        String brand = readString();

        System.out.print("Price: ");
        double price = readDouble();


        System.out.print("Model:");
        String model = readString();

        System.out.print("size:");
        double size = readDouble();

        System.out.print("Refresh rate:");
        double refreshRate = readDouble();

        return new Monitor(price, model, brand, size, refreshRate);

    }

    public static void showAllElectronics() {
        showAllHeader();
        for (ElectronicProducts abc : products) {

            System.out.println(abc);
        }
        showAllFooter();
        pressAnyKeyToContinue();
    }

    public static void addProduct(ElectronicProducts m) {
        products.add(m);
    }

    public static Speaker createSpeaker() {

        System.out.print("Brand:");
        String brand = readString();

        System.out.print("Price: ");
        double price = readDouble();

        System.out.print("Model:");
        String model = readString();

        System.out.print("Battery time:");
        int batteryTime = readInt();

        System.out.print("weight:");
        int weight = readInt();

        return new Speaker(price, model, brand, batteryTime, weight);
    }

    public static void searchForProduct() {
        boolean searchProductLoop = true;
        while (searchProductLoop) {
            searchProductMenu();

            int choice = readInt();

            if (choice == 1) {

                System.out.print("id:");
                int id = readInt();

                boolean found = false;

                for (ElectronicProducts a : products) {
                    if (a.getProductId() == id) {
                        System.out.println(a);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No product with matching id was found, try again.");
                }
                pressAnyKeyToContinue();

            } else if (choice == 2) {
                System.out.println("1. Monitor");
                System.out.println("2. Phone");
                System.out.println("3. Speaker");

                int choice2 = readInt();


                if (choice2 == 1) {
                    System.out.println("1. Brand ");
                    System.out.println("2. Price ");
                    int ch = readInt();


                    if (ch == 1) {
                        System.out.print("Brand: ");
                        String brand = readString();

                        boolean found = false;


                        for (ElectronicProducts a : products) {
                            if (a instanceof Monitor) {
                                if (a.getBrand().equalsIgnoreCase(brand)) {
                                    System.out.println(a);
                                    found = true;
                                }
                            }
                        }
                        if (!found) {
                            System.out.println("We cant find that brand. Try again!");
                        }
                        pressAnyKeyToContinue();

                    } else if (ch == 2) {
                        priceRange();
                        pressAnyKeyToContinue();
                    }

                } else if (choice2 == 2) {
                    System.out.println("1. Brand: ");
                    System.out.println("2. Price: ");
                    int ch = readInt();


                    if (ch == 1) {
                        System.out.print("Brand: ");
                        String brand = readString();

                        boolean found = false;


                        for (ElectronicProducts a : products) {
                            if (a instanceof Phone) {
                                if (a.getBrand().equalsIgnoreCase(brand)) {
                                    System.out.println(a);
                                    found = true;
                                }
                            }
                        }
                        if (!found) {
                            System.out.println("We cant find that brand. Try again!");
                        }
                        pressAnyKeyToContinue();

                    } else if (ch == 2) {
                        priceRange();
                        pressAnyKeyToContinue();
                    }
                } else if (choice2 == 3) {
                    System.out.println("1. Brand: ");
                    System.out.println("2. Price: ");
                    int ch = readInt();


                    if (ch == 1) {
                        System.out.print("Brand: ");
                        String brand = readString();

                        boolean found = false;


                        for (ElectronicProducts a : products) {
                            if (a instanceof Speaker) {
                                if (a.getBrand().equalsIgnoreCase(brand)) {
                                    System.out.println(a);
                                    found = true;
                                }
                            }
                        }
                        if (!found) {
                            System.out.println("We cant find that brand. Try again!");
                        }
                        pressAnyKeyToContinue();

                    } else if (ch == 2) {
                        priceRange();
                        pressAnyKeyToContinue();
                    }
                }
            } else if (choice == 0) {
                searchProductLoop = false;

            } else {
                System.out.println("No option selected");
                pressAnyKeyToContinue();
            }

        }
    }

    private static void priceRange() {
        System.out.print("Input maximum price: ");
        double max = readDouble();
        System.out.print("input minimum price: ");
        double min = readDouble();
        boolean found = false;


        for (ElectronicProducts a : products) {
            if (max > a.getPrice() && min < a.getPrice()) {
                System.out.println(a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("There were no product within that price range");
        }

    }


    public static void loadDb() {


        // MONITORS
        ElectronicProducts ep1 = new Monitor(2500, "XL2411", "BenQ", 24, 144);
        ElectronicProducts ep2 = new Monitor(2099, "XY441", "ASUS", 24, 144);
        ElectronicProducts ep3 = new Monitor(3600, "TY432", "MSI", 24, 250);
        ElectronicProducts ep4 = new Monitor(999.00, "PA2431", "DELL", 28, 60);
        ElectronicProducts ep5 = new Monitor(2700, "AMP54", "SAMSUNG", 24, 144);
        ElectronicProducts ep6 = new Monitor(2300, "BL2411", "ACER", 24, 144);
        ElectronicProducts ep7 = new Monitor(2200, "PPG2", "ASUS", 24, 144);
        ElectronicProducts ep8 = new Monitor(2630, "XL51851", "BenQ", 20, 120);
        ElectronicProducts ep9 = new Monitor(1299, "PG32T", "BenQ", 24, 60);

        // PHONES
        ElectronicProducts ep10 = new Phone(12900, "iPhone X", "apple", 1.50, 120);
        ElectronicProducts ep11 = new Phone(9999, "GALAXY S10", "SAMSUNG", 2, 250);
        ElectronicProducts ep12 = new Phone(6000, "7", "iPhone", 1.30, 30);
        ElectronicProducts ep13 = new Phone(4999, "P30 PRO", "HUAWEI", 1.50, 75);
        ElectronicProducts ep14 = new Phone(6000, "iPhone 7", "apple", 1.30, 30);
        ElectronicProducts ep15 = new Phone(1337, "3310", "NOKIA", 0.4, 1);
        ElectronicProducts ep16 = new Phone(6000, "iPhone 7 mini", "apple", 1.30, 30);

        // SPEAKERS
        ElectronicProducts ep17 = new Speaker(999, "SuperX20", "BOSE", 60, 4);
        ElectronicProducts ep18 = new Speaker(1299, "LargeS3", "JBL", 40, 3);
        ElectronicProducts ep19 = new Speaker(1899, "BassNKicks", "KLIPISCH", 30, 3);
        ElectronicProducts ep20 = new Speaker(3999, "lizzn", "KEF", 30, 2);
        ElectronicProducts ep21 = new Speaker(7249, "P2046", "FOCAL", 20, 2);
        ElectronicProducts ep22 = new Speaker(5099, "ALT30S", "QUESTED", 10, 1);

        addProduct(ep1);
        addProduct(ep2);
        addProduct(ep3);
        addProduct(ep4);
        addProduct(ep5);
        addProduct(ep6);
        addProduct(ep7);
        addProduct(ep8);
        addProduct(ep9);
        addProduct(ep10);
        addProduct(ep11);
        addProduct(ep12);
        addProduct(ep13);
        addProduct(ep14);
        addProduct(ep15);
        addProduct(ep16);
        addProduct(ep17);
        addProduct(ep18);
        addProduct(ep19);
        addProduct(ep20);
        addProduct(ep21);
        addProduct(ep22);

    }


    public static void updateProduct() {
        boolean updateProductLoop = true;
        while (updateProductLoop) {


            updateMenu();

            int choice = readInt();

            if (choice == 1) {

                System.out.print("id:");
                int id = readInt();

                System.out.print("New price:");
                double price = readDouble();

                for (ElectronicProducts a : products) {
                    if (a.getProductId() == id) {
                        a.setPrice(price);
                    }
                }
            } else if (choice == 2) {

                System.out.print("id:");
                int id1 = readInt();

                System.out.print("Update model to:");
                String model = readString();

                for (ElectronicProducts a1 : products) {
                    if (a1.getProductId() == id1) {
                        a1.setModel(model);

                    }

                }

            } else if (choice == 0) {
                updateProductLoop = false;
            } else
                System.out.println("You did not select any option.");

        }
    }

    public static void statisticsMethod() {
        DoubleSummaryStatistics stat = products.stream().mapToDouble(e -> e.getPrice()).summaryStatistics();
        boolean statsMenuLoop = true;
        while (statsMenuLoop) {
            statisticsMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    products.stream()
                            .filter(e -> e.getPrice() == stat.getMax()).forEach(e -> printMax(e));
                    pressAnyKeyToContinue();
                }

                case 2 -> {
                    products.stream()
                            .filter(e -> e.getPrice() == stat.getMin()).forEach(e -> printMin(e));
                    pressAnyKeyToContinue();


                }
                case 3 -> {
                    System.out.println("Sum of all products is : " + stat.getSum() + "kr");
                    pressAnyKeyToContinue();

                }
                case 4 -> {
                    System.out.println("Average price of all producs are " + x.format(stat.getAverage()) + "kr");
                    pressAnyKeyToContinue();
                }
                case 0 -> {
                    statsMenuLoop = false;
                }
            }

        }
    }

    public static void removeProduct() {

        System.out.println("Remove product with id:");

        int id = readInt();
        products.removeIf(e -> id == e.getProductId());

        System.out.println("All saved data from product id " + id + " has been deleted.");

        pressAnyKeyToContinue();
    }

    public static void sortPriceMethod() {
        boolean sortPriceLoop = true;
        while (sortPriceLoop) {
            sortMenu();
            int choice = readInt();

            if (choice == 1) {

                products.sort(null);
                System.out.println("                                                             [Price increasing]  ");
                showAllHeader();

                for (ElectronicProducts e : products) {
                    System.out.println(e);
                }
                showAllFooter();
                pressAnyKeyToContinue();

            } else if (choice == 2) {

                products.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
                System.out.println("                                                             [Price falling]  ");
                showAllHeader();

                for (ElectronicProducts e : products) {
                    System.out.println(e);

                }
                showAllFooter();
                pressAnyKeyToContinue();


            } else if (choice == 3) {
                products.sort(sortIdIncreasing);
                System.out.println("                                                              [ID increasing]   ");
                showAllHeader();

                for (ElectronicProducts e : products) {
                    System.out.println(e);
                }

                showAllFooter();
                pressAnyKeyToContinue();

            } else if (choice == 4) {
                products.sort(ElectronicProductManagement::SortIdFalling);
                System.out.println("                                                              [ID falling    ");

                showAllHeader();
                for (ElectronicProducts e : products) {
                    System.out.println(e);
                }

                showAllFooter();
                pressAnyKeyToContinue();


            } else if (choice == 0) {
                sortPriceLoop = false;


            } else {
                System.out.println("You did not choose an option");
            }

        }
    }


    public static void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\carl-\\IdeaProjects\\ElectronicManagement\\src\\Project\\ElectroniskaProdukter.txt");
        ObjectOutputStream destination = new ObjectOutputStream(fileOutputStream);
        destination.writeObject(products);

        destination.close();
        fileOutputStream.close();

    }


    public static void readFromFile() throws IOException {
        FileInputStream fileStream = new FileInputStream("C:\\Users\\carl-\\IdeaProjects\\ElectronicManagement\\src\\Project\\ElectroniskaProdukter.txt");

        try {
            ObjectInputStream source = new ObjectInputStream(fileStream);
            products = (ArrayList<ElectronicProducts>) source.readObject();

        } catch (EOFException | ClassNotFoundException eo) {
            System.out.println("finns inget att läsa in");
        }


    }

    private static void printMax(ElectronicProducts e) {
        DoubleSummaryStatistics stat = products.stream().mapToDouble(a -> a.getPrice()).summaryStatistics();
        System.out.println(e.getBrand() + " " + e.getModel() + " With the price of : " + stat.getMax() + "kr");
    }

    private static void printMin(ElectronicProducts e) {
        DoubleSummaryStatistics stat = products.stream().mapToDouble(a -> a.getPrice()).summaryStatistics();

        System.out.println(e.getBrand() + " " + e.getModel() + " With the price of : " + stat.getMin() + "kr");
    }

    public static int SortIdFalling(ElectronicProducts o1, ElectronicProducts o2) {
        return Integer.compare(o2.getProductId(), o1.getProductId());
    }






}