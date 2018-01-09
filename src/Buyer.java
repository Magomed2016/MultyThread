import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Buyer implements Runnable {

    private Random random = new Random();
    private static CyclicBarrier cyclicBarrier;
    private String name = "Buyer";
    private int countOfPurchases;
    private int countOfProducts;


    public Buyer(int number){
         this.name+=number;
    }

    public static CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public static void setCyclicBarrier(int count){
        Buyer.cyclicBarrier = new CyclicBarrier(count);
    }

    @Override
    public void run() {
        int number = 0;
        int returNumber = 0;
        while(true){
            number = random.nextInt(10)+1;
            returNumber = Store.makeShopping(number);
            if(returNumber==0){
                break;
            }
            countOfPurchases++;
            countOfProducts += returNumber;
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                break;
            }

        }

        System.out.println(name+" "+ countOfPurchases +"походов "+ countOfProducts +"продуктов");

    }
}
