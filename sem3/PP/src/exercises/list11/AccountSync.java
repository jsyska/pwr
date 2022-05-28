package exercises.list11;

public class AccountSync extends Account {

    @Override
    public synchronized void increase() {
        waitIncrease();
        sum += 100;
        printSum();
    }

    @Override
    public synchronized void decrease(){
        waitDecrease();
        sum -= 100;
        printSum();
    }

}
