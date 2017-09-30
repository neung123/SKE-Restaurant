import java.util.Scanner;
public class Main {
    
    public static Scanner scan = new Scanner(System.in);
    public static int quanCreamyTS = 0,quanSaladC = 0, quanCrispyFishF = 0, quanSpanishO = 0, quanChocoC = 0, quanTropicalF = 0,discount = 100,all;
    final static int priceCreamyTS = 120,priceSaladC = 90,priceCrispyFishF = 200,priceSpanishO = 250;
    public static String pay = "";
    public static double input,change;

    public static int firstCourse(int choice){
        int quan = 0;

        System.out.printf("1.) Creamy tomato soup\t%5d Baht.\n",priceCreamyTS);
        System.out.printf("2.) Salad with corn\t\t%5d Baht.\n",priceSaladC);
        System.out.println("3.) Total\n4.) Back\n5.) Exit");
        choice = inputInt("\nEnter your choice: ");

        if(choice<=2) {
            quan = inputInt("Enter Quantity: ");
            if(quan<0){quan=0;}
        }

        while (choice!=4 && choice!=5) {
            switch (choice) {
                case 1:
                    quanCreamyTS += quan;
                    break;
                case 2:
                    quanSaladC += quan;
                    break;
                case 3:
                    total(3);
                    break;
            }
            choice = inputInt("\nEnter your choice: ");

            if(choice<=2) {
                quan = inputInt("Enter Quantity: ");
            }
        }

        if(choice==4){ choice = 7; }
        else if(choice==5){choice = 6;}

        return choice;
    }

    public static int mainCourse(int choice){
        int quan = 0;

        System.out.printf("1.) Crispy fish fillets\t%5d Baht.\n",priceCrispyFishF);
        System.out.printf("2.) Spanish octopus\t\t%5d Baht.\n",priceSpanishO);
        System.out.println("3.) Total\n4.) Back\n5.) Exit");
        choice = inputInt("\nEnter your choice: ");

        if(choice<=2) {
            quan = inputInt("Enter Quantity: ");
            if(quan<0){quan=0;}
        }

        while (choice!=4 && choice!=5) {
            switch (choice) {
                case 1:
                    quanCrispyFishF += quan;
                    break;
                case 2:
                    quanSpanishO += quan;
                    break;
                case 3:
                    total(3);
                    break;
            }
            choice = inputInt("\nEnter your choice: ");

            if(choice<=2) {
                quan = inputInt("Enter Quantity: ");
            }
        }

        if(choice==4){ choice = 7; }
        else if(choice==5){choice = 6;}

        return choice;
    }

    public static int dessert(int choice){
        int quan = 0;

        System.out.printf("1.) Chocolate custard\t%5d Baht.\n",65);
        System.out.printf("2.) Tropical fruit\t\t%5d Baht.\n",40);
        System.out.println("3.) Total\n4.) Back\n5.) Exit");
        choice = inputInt("\nEnter your choice: ");

        if(choice<=2) {
            quan = inputInt("Enter Quantity: ");
            if(quan<0){quan=0;}
        }

        while (choice!=4 && choice!=5) {
            switch (choice) {
                case 1:
                    quanChocoC += quan;
                    break;

                case 2:
                    quanTropicalF += quan;
                    break;

                case 3:
                    total(3);
                    break;

            }
            choice = inputInt("\nEnter your choice: ");

            if(choice<=2) {
                quan = inputInt("Enter Quantity: ");
            }
        }

        if(choice==4){ choice = 7; }
        else if(choice==5){choice = 6;}

        return choice;
    }

    public static int total(int choice){

        System.out.println("========= Menu =========+=== Quantity ==+====== Price =======");

        if(quanCreamyTS>0){ System.out.printf("| Creamy tomato soup\t| \t\t%6d  | \t%10d Baht. |\n",quanCreamyTS,quanCreamyTS*priceCreamyTS); }
        if(quanSaladC>0){ System.out.printf("| Salad with corn\t\t| \t\t%6d  | \t%10d Baht. |\n",quanSaladC,quanSaladC*priceSaladC); }
        if(quanCrispyFishF >0){ System.out.printf("| Crispy fish fillets\t| \t\t%6d  | \t%10d Baht. |\n", quanCrispyFishF, quanCrispyFishF *priceCrispyFishF); }
        if(quanSpanishO >0){ System.out.printf("| Spanish octopus\t\t| \t\t%6d  | \t%10d Baht. |\n", quanSpanishO, quanSpanishO *250); }
        if(quanChocoC >0){ System.out.printf("| Chocolate custard\t\t| \t\t%6d  | \t%10d Baht. |\n", quanChocoC, quanChocoC *65); }
        if(quanTropicalF >0){ System.out.printf("| Tropical fruit\t\t| \t\t%6d  | \t%10d Baht. |\n", quanTropicalF, quanTropicalF *40); }

        double all0 = ((quanCreamyTS * 120) + (quanSaladC * 90) + (quanCrispyFishF * 200) + (quanSpanishO * 250) + (quanChocoC * 65) + (quanTropicalF * 40)) * (discount/ 100.0);
        all = (int) all0;

        System.out.println("============+===========+===============+====================");
        System.out.printf("| Total \t|");
        if(discount==100){
            System.out.printf("\t\t\t\t\t\t\t\t%10d Baht. |\n",all);
        }
        else {
            System.out.printf("\t   -%d%% |\t\t\t\t\t%10d Baht. |\n",100-discount,all);
        }

        System.out.println("============+================================================");

        return choice = 7;
    }

    public static int change(int choice){

        if(quanCreamyTS==0 && quanSaladC==0 && quanCrispyFishF ==0 && quanSpanishO == 0 && quanChocoC ==0 && quanTropicalF ==0){
            System.out.println("Sorry, You didn't order yet.");
        }
        else {
            if (quanCreamyTS > 0) {
                System.out.printf("- Creamy tomato soup \t(CT)\n");
            }
            if (quanSaladC > 0) {
                System.out.printf("- Salad with corn \t\t(ST)\n");
            }
            if (quanCrispyFishF > 0) {
                System.out.printf("- Crispy fish fillets \t(CF)\n");
            }
            if (quanSpanishO > 0) {
                System.out.printf("- Spanish octopus \t\t(SO)\n");
            }
            if (quanChocoC > 0) {
                System.out.printf("- Chocolate custard \t(CC)\n");
            }
            if (quanTropicalF > 0) {
                System.out.printf("- Tropical fruit \t\t(TF)\n");
            }

            System.out.print("What menu do to want to Change? : ");
            String change0 = scan.next();
            String change = change0.toLowerCase();
            int numchange = inputInt("Remove: ");

            switch (change){
                case "ct":
                    quanCreamyTS -= numchange;
                    if(quanCreamyTS<0){quanCreamyTS=0;}
                    break;
                case "st":
                    quanSaladC -= numchange;
                    if(quanSaladC<0){quanSaladC=0;}
                    break;
                case "cf":
                    quanCrispyFishF -= numchange;
                    if(quanCrispyFishF <0){
                        quanCrispyFishF =0;}
                    break;
                case "so":
                    quanSpanishO -= numchange;
                    if(quanSpanishO <0){
                        quanSpanishO =0;}
                    break;
                case "cc":
                    quanChocoC -= numchange;
                    if(quanChocoC <0){
                        quanChocoC =0;}
                    break;
                case "tf":
                    quanTropicalF -= numchange;
                    if(quanTropicalF <0){
                        quanTropicalF =0;}
                    break;

            }
        }
        return choice = 7;
    }

    public static void note(int num,double x) {

        change -= num*Math.floor(x/num);

        if(num*Math.floor(x/num)>0) {
            System.out.printf("%d notes: %.0f\n", num, Math.floor(x / num));
        }
    }

    public static void coin(int num,double x) {
        change -= num*Math.floor(x/num);

        if(num*Math.floor(x/num)>0) {
            System.out.printf("%d coins: %.0f\n", num, Math.floor(x / num));
        }
    }

    public static void money(){
        do{
            System.out.print("\nHow would you pay,cash (c) or credit card (cc)? ");
            pay = scan.next();

            if(!pay.equalsIgnoreCase("cc") && !pay.equalsIgnoreCase("c") && !pay.equalsIgnoreCase("")){
                System.out.println("Sorry, but you have to choose.");
            }
        }
        while (!pay.equalsIgnoreCase("cc") && !pay.equalsIgnoreCase("c"));


        if(pay.equalsIgnoreCase("cc")) {
            System.out.println("Pay with credit card : 5% discount");
            discount-=5;
            total(5);
        }
        else if(pay.equalsIgnoreCase("c")){

            do {
                System.out.print("\nInput your money: ");
                input = scan.nextDouble();
                change = input - all;
            }while (change<0);

            System.out.println("Your change is:");
            note(1000,change);
            note(500,change);
            note(100,change);
            note(50,change);
            note(20,change);
            coin(10,change);
            coin(5,change);
            coin(2,change);
            coin(1,change);

        }

    }

    public static int inputInt(String statement){
        System.out.print(statement);
        return scan.nextInt();
    }

    public static void main(String[] args) {

        System.out.println("========= WELCOME TO SKE RESTAURANT =========");
        System.out.println("1.) First course\n2.) Main course\n3.) Dessert\n4.) Total\n5.) Change menu\n6.) Exit");
        System.out.print("\nEnter your choice: ");
        int choice = inputInt("Enter your choice: ");

        while (choice!=6) {
            switch (choice) {
                case 1:
                    choice = firstCourse(choice);
                    break;
                case 2:
                    choice = mainCourse(choice);
                    break;
                case 3:
                    choice = dessert(choice);
                    break;
                case 4:
                    total(4);
                    break;
                case 5:
                    change(5);
                    break;
            }

            if(choice!=6) {
                System.out.println("\n1.) First course\n2.) Main course\n3.) Dessert\n4.) Total\n5.) Change menu\n6.) Exit");
                choice = inputInt("\nEnter your choice: ");
            }
        }

        if(((quanCreamyTS*priceCreamyTS)+(quanSaladC*priceSaladC)+(quanCrispyFishF *200)+(quanSpanishO *250)+(quanChocoC *65)+(quanTropicalF *40))>0) {

            if(((quanCreamyTS*priceCreamyTS)+(quanSaladC*90)+(quanCrispyFishF *200)+(quanSpanishO *250)+(quanChocoC *65)+(quanTropicalF *40))>=2500){
                System.out.println("Your orders are more than 2500 Baht. : 10% discount");
                discount-=10;
                total(5);
            }
            else {
                total(5);
            }
            money();
        }
        else {
            total(5);
        }
        System.out.println("========================= THANK YOU =========================");
    }
}

