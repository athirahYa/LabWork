
/**
 * Description: Lab test 2024 
 * Name: Nur Athirah Binti Hilalluddin
 * student ID: AM2307013911
 * Date: 13/3/2024
 */

//This class provides an accessor function for retrieving values from an object array.
public class Employee
{

    //Declare variable
    String empName;
    double empSalary;
    int empServiceYears;

    //constructor without parameter
    public Employee ()
    {
        empName = null;
        empSalary = 0.0;
        empServiceYears = 0;
    }

    //constructor with parameter
    public Employee (String empName,double empSalary, int empServiceYears)
    {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empServiceYears = empServiceYears;
    }

    //getter
    public String getEmpName() {return empName;}

    public double getEmpSalary()  {return empSalary;}

    public int getEmpServiceYears() {return empServiceYears;}
}
