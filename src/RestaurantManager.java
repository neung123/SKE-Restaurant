import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The Restaurant Manager
 * It can retrieves the menu and prices from the file
 * It records the orders for the chef
 *
 * @author Pornpavee Seri-umnuoy
 *
 */

public class RestaurantManager {

    private String[] menuList;
    private double[] unitPrice;
    public final String ORDERS_FILE = "data/orders.txt";
    public final String MENU_FILE = "data/menu.txt";
    private int orderNumber = 0; //for store old order's number in order.txt
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();


    public void init() {

        ClassLoader loader = RestaurantManager.class.getClassLoader();
        InputStream text = loader.getResourceAsStream(MENU_FILE);

        if (text == null) {
            System.out.println("Could not access file " + MENU_FILE);
            return;
        }

        Scanner reader = new Scanner(text);
        int countLine = 0;
        ArrayList<String> menu = new ArrayList<String>( );
        ArrayList<Double> price = new ArrayList<Double>( );

        while (reader.hasNextLine()) {

            String sCurrentLine = reader.nextLine();
            countLine++;
            if (checkMenu(sCurrentLine)) {
                String[] item = sCurrentLine.split(";");

                double menuPrice;
                try {
                    menuPrice = Double.parseDouble(item[1]);
                }catch (NumberFormatException ex){
                    System.out.printf("%s error:%d",MENU_FILE,countLine);
                    return;
                }

                menu.add(item[0]);
                price.add(menuPrice);
            }
        }
        reader.close();

        menuList = new String[menu.size()];
        unitPrice = new double[price.size()];

        menu.toArray(menuList);
        for(int k=0; k<unitPrice.length; k++) unitPrice[k] = price.get(k);
    }

    public String[] getMenuItems(){
        return menuList;
    }

    public double[] getPrices(){
        return unitPrice;
    }



    public static boolean checkMenu (String arg){

        if (!arg.equals("")) {
            if (arg.charAt(0) == '#') {
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * for send the order to the chef
     *
     * orderNumber ref. receipt no.
     * @param item customer's order
     * @param quantity customer's order
     */
    public void recordOrder(ArrayList<String> item,ArrayList<Integer> quantity,double total){

        File file = new File(ORDERS_FILE);
        String pathname = file.getParent();
        if (! pathname.isEmpty() ) {
            File parent = new File(pathname);
            parent.mkdirs();
        }

        boolean append = file.exists();
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(file, append);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintStream pout = new PrintStream(out);
        runOrderNumber();
        pout.printf("\n#%05d\n",orderNumber);
        pout.println(dateFormat.format(date));
        for(int i = 0; i < item.size(); i++) pout.printf("%-20s %d\n",item.get(i),quantity.get(i));
        pout.printf("\nTotal: %.2f\n",total);
        pout.println("--------------------------");

        pout.close();


    }

    public void runOrderNumber(){

        ClassLoader loader = RestaurantManager.class.getClassLoader();
        InputStream text = loader.getResourceAsStream(ORDERS_FILE);

        Scanner reader = new Scanner(text);


        while (reader.hasNextLine()) {
            String sCurrentLine = reader.nextLine();
            if (sCurrentLine.startsWith("#")){
                orderNumber = Math.max(Integer.parseInt(sCurrentLine.substring(1).trim()),orderNumber);
            }

        }
        reader.close();
        orderNumber+=1;

    }

    public static void main(String[] args){

        RestaurantManager rm = new RestaurantManager();
        rm.init();

        for(int k = 0; k < rm.menuList.length ; k++)System.out.printf("[%d] %-20.20s  %6.2f Baht.\n",k+1,rm.menuList[k], rm.unitPrice[k]);

    }

}