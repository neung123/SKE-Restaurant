import java.util.Scanner;
public class Main {


    public static Scanner scan = new Scanner(System.in);
    public static int f1 = 0,f2 = 0,m1 = 0,m2 = 0,d1 = 0,d2 = 0,moreThan = 0,discount = 100,all;
    public static String pay = "";
    public static double input,change;

    public static int firstCourse(int choice){

        int quan = 0;

        System.out.printf("1.) Creamy tomato soup\t%5d Baht.\n",120);
        System.out.printf("2.) Salad with corn\t\t%5d Baht.\n",90);
        System.out.println("3.) Total\n4.) Back\n5.) Exit");
        System.out.println("");
        System.out.print("Enter your choice: ");
        choice = scan.nextInt();

        if(choice<=2) {
            System.out.print("Enter Quantity: ");
            quan = scan.nextInt();
            if(quan<0){quan=0;}
        }

        while (choice!=4 && choice!=5) {
            switch (choice) {
                case 1:
                    f1 += quan;
                    break;

                case 2:
                    f2 += quan;
                    break;

                case 3:
                    total(3);
                    break;

            }
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            if(choice<=2) {
                System.out.print("Enter Quantity: ");
                quan = scan.nextInt();
            }
        }

        if(choice==4){ choice = 7; }
        else if(choice==5){choice = 6;}

        return choice;
    }

    public static int mainCourse(int choice){
        int quan = 0;

        System.out.printf("1.) Crispy fish fillets\t%5d Baht.\n",200);
        System.out.printf("2.) Spanish octopus\t\t%5d Baht.\n",250);
        System.out.println("3.) Total\n4.) Back\n5.) Exit");
        System.out.println("");
        System.out.print("Enter your choice: ");
        choice = scan.nextInt();

        if(choice<=2) {
            System.out.print("Enter Quantity: ");
            quan = scan.nextInt();
            if(quan<0){quan=0;}
        }

        while (choice!=4 && choice!=5) {
            switch (choice) {
                case 1:
                    m1 += quan;
                    break;

                case 2:
                    m2 += quan;
                    break;

                case 3:
                    total(3);
                    break;

            }
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            if(choice<=2) {
                System.out.print("Enter Quantity: ");
                quan = scan.nextInt();
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
        System.out.println("");
        System.out.print("Enter your choice: ");
        choice = scan.nextInt();

        if(choice<=2) {
            System.out.print("Enter Quantity: ");
            quan = scan.nextInt();
            if(quan<0){quan=0;}
        }

        while (choice!=4 && choice!=5) {
            switch (choice) {
                case 1:
                    d1 += quan;
                    break;

                case 2:
                    d2 += quan;
                    break;

                case 3:
                    total(3);
                    break;

            }
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            if(choice<=2) {
                System.out.print("Enter Quantity: ");
                quan = scan.nextInt();
            }
        }

        if(choice==4){ choice = 7; }
        else if(choice==5){choice = 6;}

        return choice;
    }

    public static int total(int choice){

        System.out.println("========= Menu =========+=== Quantity ==+====== Price =======");

        if(f1>0){ System.out.printf("| Creamy tomato soup\t| \t\t%6d  | \t%10d Baht. |\n",f1,f1*120); }
        if(f2>0){ System.out.printf("| Salad with corn\t\t| \t\t%6d  | \t%10d Baht. |\n",f2,f2*90); }
        if(m1>0){ System.out.printf("| Crispy fish fillets\t| \t\t%6d  | \t%10d Baht. |\n",m1,m1*200); }
        if(m2>0){ System.out.printf("| Spanish octopus\t\t| \t\t%6d  | \t%10d Baht. |\n",m2,m2*250); }
        if(d1>0){ System.out.printf("| Chocolate custard\t\t| \t\t%6d  | \t%10d Baht. |\n",d1,d1*65); }
        if(d2>0){ System.out.printf("| Tropical fruit\t\t| \t\t%6d  | \t%10d Baht. |\n",d2,d2*40); }

        double all0 = ((f1 * 120) + (f2 * 90) + (m1 * 200) + (m2 * 250) + (d1 * 65) + (d2 * 40)) * (discount/ 100.0);
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


    public static int chang(int choice){

        if(f1==0 && f2==0 && m1==0 && m2 == 0 && d1==0 && d2==0){
            System.out.println("Sorry, You didn't order yet.");
        }
        else {
            if (f1 > 0) {
                System.out.printf("- Creamy tomato soup \t(CT)\n");
            }
            if (f2 > 0) {
                System.out.printf("- Salad with corn \t\t(ST)\n");
            }
            if (m1 > 0) {
                System.out.printf("- Crispy fish fillets \t(CF)\n");
            }
            if (m2 > 0) {
                System.out.printf("- Spanish octopus \t\t(SO)\n");
            }
            if (d1 > 0) {
                System.out.printf("- Chocolate custard \t(CC)\n");
            }
            if (d2 > 0) {
                System.out.printf("- Tropical fruit \t\t(TF)\n");
            }

            System.out.print("What menu do to want to Change? : ");
            String change0 = scan.next();
            String change = change0.toLowerCase();
            System.out.print("Remove: ");
            int numchange = scan.nextInt();

            switch (change){
                case "ct":
                    f1 -= numchange;
                    if(f1<0){f1=0;}
                    break;
                case "st":
                    f2 -= numchange;
                    if(f2<0){f2=0;}
                    break;
                case "cf":
                    m1 -= numchange;
                    if(m1<0){m1=0;}
                    break;
                case "so":
                    m2 -= numchange;
                    if(m2<0){m2=0;}
                    break;
                case "cc":
                    d1 -= numchange;
                    if(d1<0){d1=0;}
                    break;
                case "tf":
                    d2 -= numchange;
                    if(d2<0){d2=0;}
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

    public static void main(String[] args) {

        System.out.println("========= WELCOME TO SKE RESTAURANT =========");

        System.out.println("1.) First course\n2.) Main course\n3.) Dessert\n4.) Total\n5.) Change menu\n6.) Exit");
        System.out.println("");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();

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
                    chang(5);
                    break;

            }

            if(choice!=6) {
                System.out.println("");
                System.out.println("1.) First course\n2.) Main course\n3.) Dessert\n4.) Total\n5.) Change menu\n6.) Exit");
                System.out.println("");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
            }
        }



        if(((f1*120)+(f2*90)+(m1*200)+(m2*250)+(d1*65)+(d2*40))>0) {

            if(((f1*120)+(f2*90)+(m1*200)+(m2*250)+(d1*65)+(d2*40))>=2500){
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

