package Project;

public class UI {
    public static void showMainMenu() {
        System.out.println("""
                _______________________________________________________
                                   Management menu
                _______________________________________________________
                  
                1. Add product
                2. Show all products
                3. Search for a product
                4. Remove product
                5. Update product
                6. Statistics
                7. Sort products
                0. Exit program
                """);
        System.out.print("\nEnter a number: ");
    }

    public static void updateMenu() {
        System.out.println("""
                 _______________________________________________________
                                     Update product
                 _______________________________________________________
                 1. Update price
                 2. Update model
                 0. Return
                """);
    }

    public static void statisticsMenu() {
        System.out.println("""
                 _______________________________________________________
                                        Statistics
                 _______________________________________________________
                 1. Show highest product price
                 2. Show lowest product price
                 3. Total value of products
                 4. Average price
                 0. Return
                """);
    }

    public static void addProductMenu() {
        System.out.println("""
                 _______________________________________________________
                                        Add product
                 _______________________________________________________
                 What type of product would you like to add?
                 1. Monitor
                 2. Phone
                 3. Speaker
                 0. Return
                """);
    }

    public static void searchProductMenu() {
        System.out.println("""
                 _______________________________________________________
                                  Search for product
                 _______________________________________________________
                 How would you like to search?
                 1. ID
                 2. Product type
                 0. Return
                                 """ );
    }



    public static void showAllHeader(){
        System.out.println("""
            ========================================================================================================================================
            |                                                                                                                                      |
            |[ID]              [BRAND]                   [MODEL]                      [PRICE]               [SIZE &]            [SPECIFICATIONS]   |
            |                                                                                               [WEIGHT]                               |
            ========================================================================================================================================
            """);
    }

    public static void showAllFooter(){
        System.out.println("=======================================================================================================================================");
    }


    public static void sortMenu() {
        System.out.println("""
                 _______________________________________________________
                                     Sort products
                 _______________________________________________________
                 1. Price increasing
                 2. Price falling
                 3. ID Increasing
                 4. ID Falling
                 0. Return
                """);
    }}