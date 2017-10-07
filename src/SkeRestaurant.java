import java.util.Scanner;

public class SkeRestaurant {

    private static Scanner scan = new Scanner(System.in);
    private static final String[] menuItems = {"Creamy tomato soup", "Salad with corn","Crispy fish fillets", "Spanish octopus","Chocolate custard", "Tropical fruit"};
    private static final String[] menuItemsShort = {"CT", "SC","CF", "SO","CC", "TF"};
    private static final double[] unitPrice = {120.0, 90.0,200.0, 250.0,65.0, 40.0};
    private static int[] quantity = {0,0,0,0,0,0};
    private static int discount = 100;
    public static double realPrice;


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
            if (quantity[k]>0){System.out.printf("| %-21.20s | %10d | %12.2f Baht. |\n", menuItems[k],quantity[k],quantity[k]* unitPrice[0]); }
        }
    }

    private static double total() {
        double all = 0.0;
        for(int k = 0; k < quantity.length; k++){ all += quantity[k]*unitPrice[k];}
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
     * work with capital letter and small letter
     * if you put a negative number this method will minus the quantity anyway**/

    private static void change(){

        if(checkQuantity()){
            System.out.println("Sorry, You didn't order yet.");
        }
        else {
            for(int k = 0; k < quantity.length ; k++){
                if (quantity[k]>0){System.out.printf("- %-21.20s (%s)\n",menuItems[k],menuItemsShort[k]); }
            }

            System.out.print("What menu do to want to Change? : ");
            String change0 = scan.next();
            String change = change0.toLowerCase();
            int numChange = Math.abs(inputInt("Remove: "));

            switch (change){
                case "ct":
                    quantity[0] -= numChange;
                    break;
                case "sc":
                    quantity[1] -= numChange;
                    break;
                case "cf":
                    quantity[2] -= numChange;
                    break;
                case "so":
                    quantity[3] -= numChange;
                    break;
                case "cc":
                    quantity[4] -= numChange;
                    break;
                case "tf":
                    quantity[5] -= numChange;
                    break;
            }

            /** change quantity to 0 if it's a negative number **/
            for(int k = 0; k < quantity.length ; k++){
                if(quantity[k]<0){quantity[k]=0;}
            }
        }
    }

    private static void order(){
        int choice = 0,quan = 0;

        do{
            choice = inputInt("\nEnter your choice: ");
            if(choice>=1 &&  choice<=6) {
                quan = inputInt("Enter Quantity: ");
                if(quan<0){quan=0;}
            }
            switch (choice) {
                case 1:
                    quantity[0] += quan;
                    break;
                case 2:
                    quantity[1] += quan;
                    break;
                case 3:
                    quantity[2] += quan;
                    break;
                case 4:
                    quantity[3] += quan;
                    break;
                case 5:
                    quantity[4] += quan;
                    break;
                case 6:
                    quantity[5] += quan;
                    break;

                case 7:
                    PrintTotal();
                    break;
                case 8:
                    change();
                    break;
            }
        }while (choice!=9);
    }

    private static int inputInt(String statement){
        System.out.print(statement);
        return scan.nextInt();
    }

    public static void main(String[] args) {

        System.out.println("========= WELCOME TO SKE RESTAURANT =========");

        for(int k = 0; k < quantity.length ; k++)System.out.printf("\n%d.) %-20.20s  %6.2f Baht.",k+1,menuItems[k], unitPrice[k]);
        System.out.println("\n7.) Total\n8.) Change menu\n9.) Exit");

        order();
        PrintTotal();
        checkOrder();

        System.out.println("======================== THANK YOU ========================");
    }
}

