// 18. Multithreading:
// Create a simple multithreaded program and demonstrate thread synchronization.

class BankAccount {
    private int balance = 0;

    // Synchronized method to deposit money
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Method to get the current balance
    public int getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            System.out.println("Deposit: $100");
            try {
                Thread.sleep(200); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;

    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(150);
            System.out.println("Withdrawal: $150");
            try {
                Thread.sleep(300); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        // Create a shared BankAccount object
        BankAccount account = new BankAccount();

        // Create two threads, one for deposit and one for withdrawal
        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);

        // Start the threads
        depositThread.start();
        withdrawThread.start();

        // Wait for both threads to finish
        depositThread.join();
        withdrawThread.join();

        // Print the final balance
        System.out.println("Final Balance: $" + account.getBalance());
    }
}
