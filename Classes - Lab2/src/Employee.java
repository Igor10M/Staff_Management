public abstract class Employee {

    // Fields of Employee class
    private int ID;
    private String firstName;
    private String lastName;
    private int age;

    // Getters to display ID, Full Name and Age in the Main Class
    public int getID() {
        return ID;
    }
    public String getName() {
        return firstName + " " + lastName;
    }
    public int getAge() {
        return age;
    }

    // Employee Constructor
    public Employee (String firstName, String lastName, int age, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ID = ID;
    }

    // Calculation method to be overridden by concrete methods in the subclasses
    public abstract double paymentCalculation();

    // Display Method to be overridden by concrete methods in the subclasses
    public abstract void displayInfo();

}

class EmployeeFullTime extends Employee {

    // Field of EmployeeFullTime class
    private double monthlySalary;

    // Full-Time Employee Constructor
    public EmployeeFullTime(String firstName, String lastName, int age, int ID, double monthlySalary) {
        // Call the parent constructor to initialize the common fields
        super(firstName, lastName, age, ID);
        this.monthlySalary = monthlySalary;
    }

    // Method to return the monthly salary of full-time employees
    @Override
    public double paymentCalculation() {
        return this.monthlySalary;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee Type: Full-Time");
        System.out.println("Pay to the order of: " + this.getName());
        System.out.println("Amount: " + this.monthlySalary);
    }

}

class EmployeePartTime extends Employee {

    // Fields of EmployeePartTime class
    private int hourlyRate;
    private int echelon;
    private double hoursOfWork;

    // Part-Time Employee Constructor
    public EmployeePartTime(String firstName, String lastName, int age, int ID, int echelon, double hoursOfWork) {
        // Call the parent constructor to initialize the common fields
        super(firstName, lastName, age, ID);

        // Check the hourly rate according to the employee's rank (echelon)
        if (echelon == 1) {
            this.hourlyRate = 15;
        }
        else if (echelon == 2) {
            this.hourlyRate = 20;
        }
        else if (echelon == 3) {
            this.hourlyRate = 25;
        }
        else if (echelon == 4) {
            this.hourlyRate = 30;
        }else {
            this.hourlyRate = 40;
        }

        this.hoursOfWork = hoursOfWork;

    }

    // Method to calculate the payment of part-time employees
    @Override
    public double paymentCalculation() {
        return hourlyRate * hoursOfWork;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee Type: Part-Time");
        System.out.println("Pay to the order of: " + this.getName());
        System.out.println("Amount: " + this.paymentCalculation());
    }

}