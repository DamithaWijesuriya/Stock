/**
 * Created by hsenid on 10/18/16.
 */
public class stock {

    int s_id;
    String s_name;
    double s_qty;
    double s_price;
    String s_unit;
    String s_pid;


    public stock(int sid, String name, double qty, double price, String unit,String pid )
    {
        s_id=sid;
        s_name=name;
        s_qty=qty;
        s_price=price;
        s_unit=unit;
        s_pid=pid;
    }


}
