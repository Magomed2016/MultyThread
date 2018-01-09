public class Store {

    private static volatile int COUNT_OF_PRODUCTS = 1000;

    public static synchronized int makeShopping(int number){

        if(COUNT_OF_PRODUCTS!=0) {

              if (COUNT_OF_PRODUCTS <= number) {
                number = COUNT_OF_PRODUCTS;
                COUNT_OF_PRODUCTS = 0;
                  //System.out.println(name+number);
                return number;

              } else {
                COUNT_OF_PRODUCTS -= number;
                return number;
              }
        }else
            Buyer.getCyclicBarrier().reset();
        return 0;
    }

}
