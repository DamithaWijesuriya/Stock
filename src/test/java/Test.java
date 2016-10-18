/**
 * Created by hsenid on 10/18/16.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    //stock s1=new stock();
    Map<String, stock> map = new HashMap<String, stock>();
    static Scanner in = new Scanner(System.in);
    int id = 1;

    public static void main(String[] args) {
        Test st = new Test();
        st.add("sugger", 10, 10);
        st.update("1", 100);
        st.bill("1", 10);
    }

    public void add(String name, int qty, double price) {

        map.put(Integer.toString(id), new stock(id, name, qty, price));
        stock v4 = map.get("1"); // returns the object holding the String "d"
        System.out.println(v4.s_id);
        id++;
        System.out.println("successfully added !");
    }

    public void update(String id, int nqty) {


        stock v3 = map.get(id);
        double price = v3.s_price;
        // returns the object holding the String "d"
        int cqty = v3.s_qty + nqty;
        int sid = v3.s_id;
        String sname = v3.s_name;

        map.put(id, new stock(sid, sname, cqty, price));
        System.out.println("successfully Updated !");


    }

    public void bill(String id, int qty) {


        double total = 0;

        int count;
        double price;
        String bill[][];           // declare marks array
        bill = new String[500][4];
        String name, sqty;


        for (int k = 1; k >= 1; k++) {

            stock v3 = map.get(id);
            price = v3.s_price;
            name = v3.s_name;

            total = total + price * qty;

            if (total == 100)
            {
                System.out.println("Bill calculation Correct");
            }
            else
                System.out.println("bill calculation incorrect");

            System.exit(1);
        }


    }


}
