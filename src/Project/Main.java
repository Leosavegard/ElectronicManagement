package Project;


import Project.Methods.Methods;

import java.io.IOException;

import static Project.ElectronicProductManagement.*;
import static Project.UI.showMainMenu;


public class Main  {
    public static boolean loop = true;


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        readFromFile();
        //loadDb();
        while (loop) {

            showMainMenu();

            int choice = Methods.readInt();

            switch (choice) {


                case 1 -> addProductOptions();
                case 2 -> showAllElectronics();
                case 3 -> searchForProduct();
                case 4 -> removeProduct();
                case 5 -> updateProduct();
                case 6 -> statisticsMethod();
                case 7 -> sortPriceMethod();
                case 0 -> {
                    writeToFile();
                    loop = false;
                }

            }

        }

    }

}

