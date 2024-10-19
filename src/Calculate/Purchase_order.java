package Calculate;

public class Purchase_order {

    public static double[] getPerTotal(double costPrice, double qty, double discount){
        double[] calPurchase = new double[3];
        calPurchase[0]=(costPrice-discount)*qty;
        calPurchase[1]=calPurchase[0];
//        calPurchase[2]=;
        
        return calPurchase;
                
                
    }    
}
 
