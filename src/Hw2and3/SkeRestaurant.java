package Hw2and3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  The main class of SKE Restaurant.
 *  you can order with this class
 *  quantity,price and items using an array
 *
 * @author Pornpavee Seri-umnuoy
 *
 */

public class SkeRestaurant {

    public static Scanner scan = new Scanner(System.in);
    private static int[] quantity;
    private static double[] prices;
    private static String[] items;
    public static RestaurantManager rm = new RestaurantManager();

    private static void print(){

        System.out.printf("%-21.20s  %10s  %12s Baht.\n","#Menu","Quantity","Price");
        for(int k = 0; k < quantity.length ; k++){
            if (quantity[k]>0){System.out.printf("%-21.20s  %10d  %12.2f Baht.\n", items[k],quantity[k],quantity[k]* prices[k]); }
        }

        System.out.printf("\nTotal: %.2f Baht.\n",getTotal());


    }


    /**
     * change() for changing the quantity
     * if you put a negative number
     * this method will minus the quantity anyway
     *
     **/

    private static void change() {

        int countQuan = 0;
        for (int n : quantity) countQuan += n;

        if (countQuan == 0) System.out.println("Sorry, You didn't order yet.");
        else for (int k = 0; k < quantity.length; k++)
            if (quantity[k] > 0){ System.out.printf("\n[%d] %-20.20s", k + 1, items[k]);}

        String change = UserInput("\nWhat menu do to want to Change? : ");
        String numChange = UserInput("Remove: ");
            if (isNumber(change) && isNumber(numChange) && Integer.parseInt(change) <= items.length && Integer.parseInt(change) > 0 ) {
                quantity[Integer.parseInt(change) - 1] = Math.max(quantity[Integer.parseInt(change) - 1] - Integer.parseInt(numChange), 0);
            } else System.out.println("Invalid input");

    }

    /**
     * order() is the main method
     * to order menu,print receipt and exit
     * choice t,c and x
     * work with small and capital letter
     *
     * minus quantity will be ignore
     **/
    private static void order(){
        String choice,quan;
        do {
            choice = UserInput("\nEnter your choice: ");

            if (isNumber(choice)) {
                if(Integer.parseInt(choice) <= items.length && Integer.parseInt(choice) > 0) {
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
                    System.out.printf("Sorry,but our restaurant have %d menus\n",items.length);
                }
            } else {
                if(choice.equalsIgnoreCase("t")) print();
                else if(choice.equalsIgnoreCase("c")) change();
                else if(choice.equalsIgnoreCase("x")) checkOut();
                else if(choice.equals("?")){allChoice();}
                else if (choice.equals("-")) break;
                else System.out.println("Enter ? for help");

            }
        }while (!choice.equalsIgnoreCase("-"));
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

    /**
     * check out method
     * for record old order and prepare for new order
     */
    private static void checkOut(){
        print();
        System.out.println("Thank you for purchasing");

        ArrayList<String> item = new ArrayList<>();
        ArrayList<Integer> quan = new ArrayList<>();

        for(int i = 0; i < quantity.length; i++) {
            if (quantity[i] > 0){
                item.add(items[i]);
                quan.add(quantity[i]);
            }
        }

        rm.recordOrder(item,quan,getTotal());

        //delete the old order
        quantity = new int[quantity.length];

    }

    private static double getTotal(){
        double total = 0.0;
        for(int k = 0; k < quantity.length; k++){ total += quantity[k]*prices[k];}
        return total;
    }

    private static void allChoice(){
        for(int k = 0; k < items.length ; k++)System.out.printf("\n[%d] %-20.20s  %6.2f Baht.",k+1,items[k],prices[k]);
        System.out.println("\n\n[t] Total\n[c] Change menu\n[x] Check out\n[-] Exit(without commit the current order)");
    }


    public static void main(String[] args) {

        rm.init();

        items = rm.getMenuItems();
        prices = rm.getPrices();
        quantity = new int[items.length];

        allChoice();
        order();

    }
}