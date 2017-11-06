import java.util.Scanner;

/**
 *  The main class of SKE Restaurant.
 *
 * @author Pornpavee Seri-umnuoy
 *
 */

public class SkeRestaurant {

    private static Scanner scan = new Scanner(System.in);
    private static int discount = 100;
    private static double realPrice;
    private static int[] quantity;

    private static void PrintTotal(){

        System.out.println("========= Menu =========+= Quantity =+======= Price =======");

        printEach();
        double total = total()* (discount/ 100.0);

        System.out.println("============+===========+============+=====================");
        System.out.printf("| %-9s |", "Total");
        if(discount==100){
            System.out.printf(" %37.2f Baht. |\n",total);
        }
        else {
            System.out.printf(" %5s-%d%% | %25.2f Baht. |\n","",100-discount,total);
        }
        System.out.println("============+==============================================");
    }

    private static void printEach(){
        for(int k = 0; k < quantity.length ; k++){
            if (quantity[k]>0){System.out.printf("| %-21.20s | %10d | %12.2f Baht. |\n", RestaurantManager.menuList[k],quantity[k],quantity[k]* RestaurantManager.unitPrice[k]); }
        }
    }

    private static double total() {
        double all = 0.0;
        for(int k = 0; k < quantity.length; k++){ all += quantity[k]*RestaurantManager.unitPrice[k];}
        realPrice = all;
        return all;
    }

    private static boolean checkQuantity(){
        int countQuan = 0;
        for(int k = 0; k < quantity.length ; k++) countQuan += quantity[k];

        if (countQuan==0){ return true; }
        else { return false; }
    }

    private static void checkOrder(){

        if( realPrice >0) {
            if(realPrice >= 2500){
                System.out.println("Your orders are more than 2500 Baht. : 10% discount");
                discount-=10;
                PrintTotal();
            }
        }
    }

    /** change() ===> change quantity
     * if you put a negative number this method will minus the quantity anyway**/

    private static void change(){

        if(checkQuantity()){
            System.out.println("Sorry, You didn't order yet.");
        }
        else {
            for(int k = 0; k < quantity.length ; k++){
                if (quantity[k]>0){System.out.printf("\n[%d] %-20.20s",k+1,RestaurantManager.menuList[k]);}
            }
            String change = UserInput("\nWhat menu do to want to Change? : ");
            int numChange = Math.abs(Integer.parseInt(UserInput("Remove: ")));
            quantity[Integer.parseInt(change) - 1] = quantity[Integer.parseInt(change) - 1] - numChange;

            /** change quantity to 0 if it's a negative number **/
            for(int k = 0; k < quantity.length ; k++){
                if(quantity[k]<0) quantity[k] = 0;
            }
        }
    }

    /** order() is the main method
     * to order menu,print receipt and exit
     * choice t,c and x
     * work with small and capital letter
     **/
    private static void order(){
        String choice,quan;
            do {
                choice = UserInput("\nEnter your choice: ");
                if (isNumber(choice)) {
                    if(Integer.parseInt(choice) <= RestaurantManager.menuList.length && Integer.parseInt(choice) > 0) {
                        quan = UserInput("Enter Quantity: ");
                        while (!isNumber(quan)){
                            System.out.println("\nInput invalid");
                            quan = UserInput("Enter Quantity: ");
                        }
                        if (Integer.parseInt(quan) < 0) {
                            quan = "0";
                        }
                        quantity[Integer.parseInt(choice) - 1] = quantity[Integer.parseInt(choice) - 1] + Integer.parseInt(quan);
                    }
                    else {
                        System.out.printf("Sorry,but our restaurant have %d menus\n",RestaurantManager.menuList.length);
                    }
                } else {
                    if(choice.equalsIgnoreCase("t")){PrintTotal();}
                    else if(choice.equalsIgnoreCase("c")){change();}
                    else if(choice.equals("?")){allChoice();}
                    else{
                        System.out.println("Enter ? for help");
                    }
                }
            }while (!choice.equalsIgnoreCase("x"));
        }


    private static String UserInput(String statement){
        System.out.print(statement);
        return scan.nextLine();
    }

    private static boolean isNumber(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }
    private static void allChoice(){
        for(int k = 0; k < RestaurantManager.menuList.length ; k++)System.out.printf("\n[%d] %-20.20s  %6.2f Baht.",k+1,RestaurantManager.menuList[k],RestaurantManager.unitPrice[k]);
        System.out.println("\n\n[t] Total\n[c] Change menu\n[x] Exit");
    }

    public static void main(String[] args) {

        System.out.println("========= WELCOME TO SKE RESTAURANT =========");

        RestaurantManager.init();
        quantity = new int[RestaurantManager.unitPrice.length];

        allChoice();

        order();
        PrintTotal();
        checkOrder();

        System.out.println("======================== THANK YOU ========================");
    }
}

