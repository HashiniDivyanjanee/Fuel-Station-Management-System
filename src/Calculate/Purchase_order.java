package Calculate;

public class Purchase_order {

    public static double getPerTotal(double salesPrice, double qty, double discount){
        return (salesPrice-discount)*qty;
    }    
}
 
