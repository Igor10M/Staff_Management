import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // List to store employees
        ArrayList<Employee> employees = new ArrayList<>();
        // List to store bills
        ArrayList<Bill> bills = new ArrayList<>();

        // Scanner object to read inputs
        Scanner reader = new Scanner(System.in);

        // Variable for menu-loop
        int choice = 0;

        // Do-while loop to loop the menu until the user press 4
        do {

            // Display menu
            displayMenu();
            // Read user's choice
            choice = getValidChoice(reader);

            // Switch to access user's choice
            switch(choice) {
                case 1: // Add an employee
                    addEmployee(reader, employees);
                    break;

                case 2: // Add a bill
                    addBill(reader, bills);
                    break;

                case 3: // Issue cheques (employees and bills)
                    issueCheques(employees, bills);
                    break;

                case 4: // Exit
                    break;

            }

        } while (choice != 4);

    }

    // Display Menu Function
    private static void displayMenu() {
        System.out.println("------------------");
        System.out.println("1 - Add an employee");
        System.out.println("2 - Add a bill");
        System.out.println("3 - Issue cheques");
        System.out.println("4 - Exit");
        System.out.println("------------------");
    }

    // Get Valid Choice Function
    public static int getValidChoice(Scanner reader) {
        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(reader.nextLine());
                if (choice >= 1 && choice <= 4) {
                    validChoice = true;
                } else {
                    System.out.println("Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        return choice;

    }

    public static void addEmployee(Scanner reader, ArrayList<Employee> employees) {
        // Variable to store the type of employee (Full-Time or Part-Time)
        int empChoice = 0;

        while (empChoice != 1 && empChoice != 2) {
            System.out.println("Enter 1 for Full-Time Employee or 2 for Part-Time Employee:");
            try {
                empChoice = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice (1 or 2).");
            }
        }

        System.out.println("Enter First Name: ");
        String firstName = reader.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = reader.nextLine();

        // Boolean to exit the loops
        boolean validInput = false;

        int age = 0;

        while (age <= 0) {
            System.out.println("Enter Age: ");
            try {
                age = Integer.parseInt(reader.nextLine());
                if (age <= 0) {
                    System.out.println("Age can't be zero or negative. Please enter a valid age.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid age.");
            }
        }

        int ID = 0;

        while (ID <= 0) {
            System.out.println("Enter ID: ");
            try {
                ID = Integer.parseInt(reader.nextLine());
                if (ID <= 0) {
                    System.out.println("ID can't be zero or negative. Please enter a valid ID.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid ID.");
            }
        }

        if (empChoice == 1) { // If it's a full-time employee
            double salary = 0;
            while (salary <= 0) {
                System.out.println("Enter Monthly Salary: ");
                try {
                    salary = Double.parseDouble(reader.nextLine());
                    if (salary <= 0) {
                        System.out.println("Salary can't be zero or negative. Please enter a valid salary.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid salary.");
                }
            }
            // Create a new Full-Time Employee and add it to the ArrayList
            EmployeeFullTime newFullTime = new EmployeeFullTime(firstName, lastName, age, ID, salary);
            employees.add(newFullTime);
        } else { // Part-time employee
            int echelon = 0;
            while (echelon < 1 || echelon > 5) {
                System.out.println("Enter Echelon (1 to 5): ");
                try {
                    echelon = Integer.parseInt(reader.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid echelon between 1 and 5.");
                }
            }
            double hoursOfWork = 0;
            while (hoursOfWork <= 0) {
                System.out.println("Enter hours of work in a month: ");
                try {
                    hoursOfWork = Double.parseDouble(reader.nextLine());
                    if (hoursOfWork <= 0) {
                        System.out.println("Hours of work can't be zero or negative. Please enter valid hours of work.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid hours of work.");
                }
            }
            // Create a new Part-Time Employee and add it to the ArrayList
            EmployeePartTime newPartTime = new EmployeePartTime(firstName, lastName, age, ID, echelon, hoursOfWork);
            employees.add(newPartTime);
        }
    }

    public static void addBill(Scanner reader, ArrayList<Bill> bills) {

        int day = 0;
        while (day < 1 || day > 31) {
            System.out.println("Enter Day (1-31): ");
            try {
                day = Integer.parseInt(reader.nextLine());
                if (day < 1 || day > 31) {
                    System.out.println("Day must be between 1 and 31.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid day.");
            }
        }

        System.out.println("Enter Month: ");
        String month = reader.nextLine();

        int year = 0;
        while (year < 2023 || year > 2025) {
            System.out.println("Enter Year (2023-2025): ");
            try {
                year = Integer.parseInt(reader.nextLine());
                if (year < 2023 || year > 2025) {
                    System.out.println("Year must be between 2023 and 2025.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid year.");
            }
        }

        double amount = -1;
        while (amount <= 0) {
            System.out.println("Enter Amount: ");
            try {
                amount = Double.parseDouble(reader.nextLine());
                if (amount <= 0) {
                    System.out.println("Amount can't be negative or zero. Please enter a valid amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }

        System.out.println("Enter Company Name: ");
        String companyName = reader.nextLine();

        Bill newBill = new Bill(day, month, year, amount, companyName);
        bills.add(newBill);
    }

    public static void issueCheques(ArrayList<Employee> employees, ArrayList<Bill> bills) {

        // Cheque Counter
        int chequeCounter = 1;

        // Issuing cheques for employees
        System.out.println("Employees Cheques:");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println("--------------------------------");
            System.out.println("Cheque number: " + chequeCounter);
            employee.displayInfo();
            System.out.println("--------------------------------\n");
            chequeCounter++;
        }

        // Issuing cheques for bills
        System.out.println("Bills Cheques:");
        for (int i = 0; i < bills.size(); i++) {
            Bill bill = bills.get(i);
            System.out.println("--------------------------------");
            System.out.println("Cheque number: " + chequeCounter);
            bill.displayCheque();
            System.out.println("--------------------------------\n");
            chequeCounter++;
        }
    }

}