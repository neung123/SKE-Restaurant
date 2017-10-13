import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    public static List<String> menuList = new ArrayList<String>( );
    public static List<Double> unitPrice = new ArrayList<Double>( );
    public static List<Integer> quantity = new ArrayList<Integer>( );
    private static final String MENU = "src\\menu.txt";


    public static void addMenu (){
        try (BufferedReader br = new BufferedReader(new FileReader(MENU))) {

            String sCurrentLine;
            String[] item;
            while ((sCurrentLine = br.readLine()) != null) {
                if (checkMenu(sCurrentLine)) {
                    item = sCurrentLine.split(";");
                    menuList.add(item[0]);
                    unitPrice.add(Double.parseDouble(item[1]));
                    quantity.add(0);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkMenu (String arg){
        if(arg.charAt(0) == '#'){
            return false;
        }
        else {
            return true;
        }
    }

}
