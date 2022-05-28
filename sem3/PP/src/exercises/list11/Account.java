package exercises.list11;

public class Account {
    int sum = 0;

    public void increase(){
        waitIncrease();
        sum+= 100;
        printSum();
    }

    public void decrease(){
        waitDecrease();
        sum -= 100;
        printSum();
    }

    public void printSum() {
        System.out.println(sum);
    }

    public void waitIncrease(){
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Account error: " + e.getMessage());
        }
    }
    public void waitDecrease(){
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("Account error: " + e.getMessage());
        }
    }
}
