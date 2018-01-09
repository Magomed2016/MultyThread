import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        int COUNT_OF_BYER = 0;
        try {
            COUNT_OF_BYER = Integer.valueOf(args[0]);
        }catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        Buyer.setCyclicBarrier(COUNT_OF_BYER);

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_OF_BYER);
        for (int i = 0; i < COUNT_OF_BYER ; i++) {

                executorService.execute(new Buyer(i));

        }
        executorService.shutdown();

    }
}
