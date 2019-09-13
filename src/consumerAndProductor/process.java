package consumerAndProductor;

public class process {
    public static void main(String[] args) {
         Pool pool = new Pool(10);
         new Productor(pool).start();
         new Consumer(pool).start();
    }
}
