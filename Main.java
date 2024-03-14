/**
 * Description: Lab test 2024 
 * Name: Nur Athirah Binti Hilalluddin
 * student ID: AM2307013911
 * Date: 13/3/2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//Driver class
public class Main {
    public static void main(String[] args) {
        try {
            // Input file
            BufferedReader inputFile = new BufferedReader(new FileReader("employeeSalaries.txt"));

            // Output file
            PrintWriter empData = new PrintWriter(new FileWriter("employeeData.txt"));

            // Declare variables
            String empName;
            double empSalary, empAnnualSalary;
            int empServiceYear;

            //Declare an array for employee to find the top performing employee and least year of service
            Employee[] empArr = new Employee[10];

            //Institiate variable for top performing employee and least year of service
            double maxAnnualSalary = Double.MIN_VALUE;
            String topEmpName = null;
            int topEmpServiceYear = 0;
            String leastEmpNameServiceYear = "";
            int leastServiceYear = Integer.MAX_VALUE;

            //institiate variable 
            int i = 0;
            String inputData = null;

            //Break into tokens and assign to the appropriate variables
            // Read employee data from the input file and populate the empArr array
            while ((inputData = inputFile.readLine()) != null) {
                // Tokenize the input data using '|' as the delimiter
                StringTokenizer sT = new StringTokenizer(inputData, "|");

                empName = sT.nextToken();
                empSalary = Double.parseDouble(sT.nextToken());
                empServiceYear = Integer.parseInt(sT.nextToken());

                // Calculate the annual salary for the employee with a 5% increase
                empAnnualSalary = empSalary + (empSalary * 0.05); // 5% = 5/100 = 0.05

                // Creating a new Employee object 
                empArr[i] = new Employee(empName, empAnnualSalary, empServiceYear);
                i++;
            }

            // Write employee details to the output file 
            empData.println("\t\t=== List of Employee Details ===\n");
            empData.println("Name                    \t| Salary   | Years of Service\t\t");
            for (Employee emp : empArr) 
            {
                if (emp != null) 
                {
                    //inserting the string argument to organize the data set
                    String name = String.format("%-31s", emp.getEmpName());  
                    String salary = String.format("%-7.2f", emp.getEmpSalary());  
                    String yearsOfService = String.format("%-16d", emp.getEmpServiceYears()); 
                    empData.println(name + " | " + salary + " | " + yearsOfService);
                }
            }

            // Find the top-performing employee and the employee with the least years of service 
            for (Employee emp : empArr) {
                // Check for top-performing employee
                if (emp != null && emp.getEmpSalary() > maxAnnualSalary) {
                    maxAnnualSalary = emp.getEmpSalary();
                    topEmpName = emp.getEmpName();
                    topEmpServiceYear = emp.getEmpServiceYears();
                }
                // Check for employee with the least years of service
                if (emp != null && emp.getEmpServiceYears() < leastServiceYear) {
                    leastServiceYear = emp.getEmpServiceYears();
                    leastEmpNameServiceYear = emp.getEmpName();
                }
            }

            //Start of display
            //Display the employee detail after the 5% incerement each year
            System.out.println("\t\t=== List of Employee Details ===\n");
            System.out.println("Name                    \t| Salary   | Years of Service\t\t");
            for (Employee emp : empArr) 
            {
                if (emp != null) 
                {
                    //inserting the string argument to organize the data set
                    String name = String.format("%-31s", emp.getEmpName());  
                    String salary = String.format("%-7.2f", emp.getEmpSalary());  
                    String yearsOfService = String.format("%-16d", emp.getEmpServiceYears()); 
                    System.out.println(name + " | " + salary + " | " + yearsOfService);
                }
            }

            // Display top-performing employee information 
            System.out.println("\n==Top Performing Employee==");
            System.out.println("Name: " + topEmpName);
            System.out.println("Salary: " + maxAnnualSalary);
            System.out.println("Years of Service: " + topEmpServiceYear);

            // Display employee with the least years of service information 
            System.out.println("\n==Employee with the Least Years of Service==");
            System.out.println("Name: " + leastEmpNameServiceYear);
            System.out.println("Years of Service: " + leastServiceYear);
            //end of display

            // Write top-performing employee information to the output file
            empData.println("\n==Top Performing Employee==");
            empData.println("Name: " + topEmpName);
            empData.println("Salary: " + maxAnnualSalary);
            empData.println("Years of Service: " + topEmpServiceYear);

            // Write employee with the least years of service information to the output file
            empData.println("\n==Employee with the Least Years of Service==");
            empData.println("Name: " + leastEmpNameServiceYear);
            empData.println("Years of Service: " + leastServiceYear);

            // Close the output file
            empData.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
