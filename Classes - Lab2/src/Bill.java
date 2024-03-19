public class Bill {

    // Fields of Bill class
    private int day;
    private String month;
    private int year;
    private double amount;
    private String companyName;

    // Bill Constructor
    public Bill (int day, String month, int year, double amount, String companyName) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.companyName = companyName;
    }

    // Method to display the details of a cheque
    public void displayCheque() {
        System.out.println("Pay to the order of: " + this.companyName);
        System.out.println("Amount: " + this.amount);
        System.out.println("Issue date: " + this.day + " " + this.month + " of " + this.year);
    }

}