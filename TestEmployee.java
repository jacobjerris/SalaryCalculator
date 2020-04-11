/*
Jacob Jerris
N01419995
3/30/20


This project is simulating a payroll program utilizing polymorphism. It takes in predetermined values and outputs the
 required output that is decided by the Professor.
 */





public class TestEmployee {
    public static void main (String[] args) {
        //You create an array of employee objects
        Employee[] employees = new Employee[2];
        //Then you declare one executive object with parameters such as first and last name, pay, and stock price.
        Executive e1 = new Executive("John", "Johnson",
                15000.00, 57.0);
        //Then another object is declared using the SalesPerson constructor, which also has a first and last name,
        // and pay. But a sale price, and rate.
        SalesPerson e2 = new SalesPerson("Steve", "Wilson",
                2000.00, 40000, .06);
        //Then the objects are cast into variables
        employees[0] = e1;
        employees[1] = e2;
        //They are then printed out along with their salary, which is overwritten in their respective subclasses.
        System.out.println(e1);
        System.out.printf("Annual Salary:\t\t%,-10.2f\n",
                employees[0].annualSalary());
        System.out.println(e2);
        System.out.printf("Annual Salary:\t\t%,-10.2f\n",
                employees[1].annualSalary());
    }
}

abstract class Employee {
    private String firstName;
    private String lastName;
    private double monthlyPay;


    Employee(String first, String last, double pay) {
        this.firstName = first;
        this.lastName = last;
        this.monthlyPay = pay;
        annualSalary();
    }
    /*
    This method takes the name set from the setFirstName method and returns it so the program may continue.
     */
    String getFirstName() {
        return firstName;
    }
    /*
        This method takes the name set from the setLastName method and returns it so the program may continue.
    */
    String getLastName() {
        return lastName;
    }
    /*
    This method takes in a first name and sets it to the local variable so the program may continue
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /*
        This method takes in a last name and sets it to the local variable so the program may continue
    */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /*
    This method takes in a monthly pay amount and sets it to the local variable so the program may continue
     */
    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }
    /*
      This method takes the monthly pay set from the setMonthlyPay method and returns it so the program may continue.
     */
     public double getMonthlyPay() {
         return monthlyPay;
     }

     /*
     This method creates a abstract method that is able to be changed throughout the subclasses and become
     overwritten to suit the current situation
      */
     abstract double annualSalary();

    /*
    This method is so the program can output to the console once it is done running, it displays first name, last
    name, and monthly pay
     */
    public String toString() {
        return String.format("\nEmployee's Name:\t%s %s\nMonthly Pay:\t\t%,-10.2f", this.firstName, this.lastName,
                this.monthlyPay);
    }
}

class Executive extends Employee {
    double stockValue;

    Executive(String first, String last, double pay, double stock) {
        super(first, last, pay);
        this.stockValue = stock;
    }

    /*
    This method is how the annualSalary is calculated for the Executive, if the executives stockValue is over 50,
    then $30,000 is added to the monthly pay for the employee. If not, then it is calculated as usual.
     */
    double annualSalary() {
        if(stockValue > 50) {
            return (super.getMonthlyPay() * 12) + 30000;
        } else {
            return super.getMonthlyPay() * 12 ;

        }
    }

    /*
    This is an override of the toString method. It includes all of the features declared in the employee class, just
    with added features, such as stock value
     */
    @Override
    public String toString() {
        return super.toString() + String.format("\nStock Price:\t\t%,-10.2f", stockValue);
    }

}

class SalesPerson extends Employee {
    int sales;
    double commissionRate;

    SalesPerson(String first, String last, double pay, int sale, double rate) {
        super(first, last, pay);
        this.sales = sale;
        this.commissionRate = rate;
   }
    /*
    This method is to calculate the annual salary for the sales person, it returns the pay for the year, plus the cut
     of sales that is given to the employee.
     */
    double annualSalary() {
        return (getMonthlyPay() * 12) + (sales * commissionRate);
    }
    /*
    This is an override of the toString method. It includes all of the features declared in the employee class, just
    with added features, such as sales and commission
    */
    @Override
    public String toString() {
        return super.toString() + String.format("\nSales:\t\t\t\t%d\nCommission:\t\t\t%.2f",
     sales, commissionRate);
    }
}

