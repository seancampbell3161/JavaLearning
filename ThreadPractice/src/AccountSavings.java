public class AccountSavings {

    public double annualInterestRate = 0.053;
    private double savingsBalance = 10;
    private double interest = 0;

    public synchronized void compoundInterest() {
        interest = savingsBalance * Math.pow( 1 + (annualInterestRate / 12),12 ) - savingsBalance;

        savingsBalance += interest;
    }

    public void runThreads() {

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for(int i = 0; i < 50; i++) {
                                compoundInterest();
                                System.out.println(savingsBalance);
                            }
                            Thread.sleep(3000);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i < 25; i++) {
                            compoundInterest();
                            System.out.println("Thread 2");
                        }
                    }
                }
        );

        t1.start();
        t2.start();

        try {
            t1.join();
//            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("savings balance is " + savingsBalance +
                " and annual intereste rate is " + (annualInterestRate *100) + "%");
    }

    public static void main(String[] args) {

        AccountSavings account = new AccountSavings();

        account.runThreads();
    }
}
