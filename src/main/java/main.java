import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by hsenid on 10/18/16.
 */


public class main {

    Map<String, stock> map = new HashMap<String, stock>();
    static Scanner in = new Scanner(System.in);

    int id = 1;

    long qty = 0;

    static main m = new main();

    public static void main(String[] args) {
        Itorater();
    }

    /**
     * Itorator() method help to give the opportunity to select the requirement.
     * Can add any number of items.
     * can update the stock.
     * Can select Billing.
     */
    public static void Itorater() {
        for (int s = 0; ; s++) {
            System.out.println("1 - For billing : 2 - for stock update : 3 - for add item");
            String input = in.nextLine();

            if (input.equals("3")) {
                m.add();
                input = "";
            } else if (input.equals("2")) {
                m.update();
                input = "";
            } else if (input.equals("1")) {
                m.bill();
                input = "";
            } else {
                System.out.println("Invalid Input");
                break;
            }

        }
    }

    /**
     * add()
     * This method helps to add new Item with name Quentity and price and those detils store in a map
     */
    public void add() {

        System.out.println("Enter prefix id with 3 Charactors");
        String pid = in.nextLine();

        System.out.println("Enter Name:");
        String name = in.nextLine();

        System.out.println("Select unit type");
        System.out.println("1 - for Decimal qty : 2 - for whole qty");
        String unit = in.nextLine();


        System.out.println("Enter quantity:");
        double qty = Double.parseDouble(in.nextLine());


        System.out.println("Enter price:");
        double price = Double.parseDouble(in.nextLine());


        int added_state = 0;
        for (int i = 1; i < id; i++) {
            stock v4 = map.get(Integer.toString(i)); // returns the object holding the String "d"
            if (v4.s_name.equals(name)) {
                map.put(Integer.toString(v4.s_id), new stock(id, name, v4.s_qty + qty, price, unit, pid));
                added_state = 1;

            }


        }


        if (added_state == 0)
        {
            map.put(Integer.toString(id), new stock(id, name, qty, price, unit, pid));
            added_state = 0;
            id++;

        }


    }

    /**
     * update() In this method can update the Item details
     * Can see the existing items
     * first user should enter the item id that he want to change
     * create stock class object and store the item id that want to change the item details to the stock class object
     */

    public void update() {/**print existing data
     */
        for (int i = 1; i < id; i++) {
            stock v4 = map.get(Integer.toString(i)); // returns the object holding the String "d"
            System.out.println("Item ID:" + v4.s_pid + v4.s_id + "    Name:" + v4.s_name + "    Qty:" + v4.s_qty + "    price:" + v4.s_price);
        }
        System.out.println("-------------------------------------------");

        System.out.println("select item id");
        String id = in.nextLine().substring(3);

        //save object id to v3 variable
        stock v3 = map.get(id);
        double price = v3.s_price;

        //handle the units if user enter name soap and qty 0.3 there is error to handle use units

        System.out.println("Enter new qty");
        long nqty = new Long(qty);


        System.out.println("Enter new price");
        price = Integer.parseInt(in.nextLine());

        //add previous and new qty
        double cqty = v3.s_qty + nqty;
        int sid = v3.s_id;
        String sname = v3.s_name;
        String uunit = v3.s_unit;
        String pid = v3.s_pid;

        map.put(id, new stock(sid, sname, cqty, price, uunit, pid));


    }

    /**
     * bill()
     * This method helps to calculate the total of Item price
     */

    public void bill() {

        // tax and discount
        System.out.println("1 - For price list : 2 - for add item to bill ");
        String input = in.nextLine();

        if (input.equals("1")) {
            for (int i = 1; i < id; i++) {
                stock v4 = map.get(Integer.toString(i)); // returns the object holding the String "d"
                System.out.println("Item ID:" + v4.s_pid + v4.s_id + "    Name:" + v4.s_name + "    Qty:" + v4.s_qty + "    price:" + v4.s_price);
            }
            System.out.println("-------------------------------------------");
        }

        input = "2";
        if (input.equals("2")) {
            double total = 0;
            String id;
            double qty = 0;
            int count;
            double price;
            String bill[][] = new String[500][4];
            String name, sqty;


            for (int k = 1; k >= 1; k++) {


                System.out.println("Enter Item id");
                id = in.nextLine().substring(3);
                stock v3 = map.get(id);

                String state = v3.s_unit;


                System.out.println("Enter Item qty");
                qty = Double.parseDouble(in.nextLine());
                double val = qty - Math.floor(qty);

                while ((state.equals("2")) && val != 0) {
                    System.out.println("Enter Item qty");
                    qty = Integer.parseInt(in.nextLine());
                    val = qty - Math.floor(qty);//getting only decimal value
                }


                price = v3.s_price;
                name = v3.s_name;


                total = (int) Math.rint(total + price * qty);

                bill[k - 1][0] = id;
                bill[k - 1][1] = name;
                bill[k - 1][2] = Double.toString(qty);
                bill[k - 1][3] = Double.toString(price);

                System.out.println("1- for add another item : 2 - for Print bill");
                String slect = in.nextLine();


                if (slect.equals("2")) {

                    System.out.print("add Tax - 1 add Discount -2");
                    String a = in.nextLine();
                    if (a.equals("1")) {
                        System.out.println("enter tx rate");
                        int tax = Integer.parseInt(in.nextLine());
                        total = total + (tax / 100 * total);
                    } else if (a.equals("2")) {
                        System.out.println("Enter Discount");
                        int discount = Integer.parseInt(in.nextLine());
                        total = total - (discount / 100 * discount);
                    }

                    System.out.println("==========Stock=========");
                    Date billDate = new Date();
                    System.out.println(billDate.toString());
                    System.out.println("ID   : Name   : Qty   : Unit Price");
                    for (int j = 0; j < k; j++) {
                        System.out.println(bill[j][0] + "\t " + ":" + bill[j][1] + "\t " + ":" + bill[j][2] + "\t " + ":" + bill[j][3] + "\t ");
                    }

                    double pay, balance;

                    System.out.println("Total price :" + "\t" + total);
                    System.out.println("------------------------------------");
                    System.out.println("enter payment price");
                    pay = Double.parseDouble(in.nextLine());
                    System.out.println("------------------------------------");

                    balance = pay - total;

                    System.out.println("Balance");

                    System.out.println("5000 notes: " + (int) balance / 5000);
                    balance = balance - ((int) balance / 5000) * 5000;

                    System.out.println("2000 notes: " + (int) balance / 2000);
                    balance = balance - ((int) balance / 2000) * 2000;

                    System.out.println("1000 notes: " + (int) balance / 1000);
                    balance = balance - ((int) balance / 1000) * 1000;

                    System.out.println("500 notes: " + (int) balance / 500);
                    balance = balance - ((int) balance / 500) * 500;

                    System.out.println("100 notes: " + (int) balance / 100);
                    balance = balance - ((int) balance / 100) * 100;

                    System.out.println("50 notes: " + (int) balance / 50);
                    balance = balance - ((int) balance / 50) * 50;

                    System.out.println("10 notes: " + (int) balance / 10);
                    balance = balance - ((int) balance / 10) * 10;

                    System.out.println("5 coins: " + (int) balance / 5);
                    balance = balance - ((int) balance / 5) * 5;

                    System.out.println("2 coins: " + (int) balance / 2);
                    balance = balance - ((int) balance / 2) * 2;

                    System.out.println("1 coins: " + (int) balance / 1);
                    balance = balance - ((int) balance / 1) * 1;


                    System.exit(1);
                }

            }

        }


    }


}
