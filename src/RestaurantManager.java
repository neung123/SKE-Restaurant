import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Reading menufile
 *
 * @author Pornpavee Seri-umnuoy
 *
 */

public class RestaurantManager {

    public static String[] menuList;
    public static double[] unitPrice;

    public static void init() {

        String file = "data/menu.txt";
        ClassLoader loader = RestaurantManager.class.getClassLoader();
        InputStream text = loader.getResourceAsStream(file);

        if (text == null) {
            System.out.println("Could not access file "+file);
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
                    System.out.printf("%s error:%d",file,countLine);
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

    public static String[] getMenuItems(){
        return menuList;
    }

    public static double[] getPrices(){
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

    public static void main(String[] args){

        init();

        for(int k = 0; k < menuList.length ; k++)System.out.printf("[%d] %-20.20s  %6.2f Baht.\n",k+1,menuList[k], unitPrice[k]);

    }

}
