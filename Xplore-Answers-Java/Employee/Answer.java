import java.util.*;
import java.lang.*;
public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Employee[] employees = new Employee[4];
        for(int i=0; i<employees.length; i++){
            int employeeId = s.nextInt();s.nextLine();
            String name = s.nextLine();
            String branch = s.nextLine();
            double rating = s.nextDouble();
            boolean companyTransport = s.nextBoolean();
            employees[i] = new Employee(employeeId, name, branch, rating, companyTransport);
        }
        s.nextLine();
        String newBranch = s.nextLine();
        s.close();
        int count = findCountOfEmployeesUsingCompTransport(employees, newBranch);
        if(count > 0)
            System.out.println(count);
        else
            System.out.println("No such Employees");

        Employee employee = findEmployeeWithSecondHighestRating(employees);
        if(employee == null)
            System.out.println("All Employees using company transport");
        else
            System.out.println(employee.getEmployeeId()+"\n"+employee.getName());
    }
    public static int findCountOfEmployeesUsingCompTransport(Employee[] employees, String branch){
        int count = 0;
        for(Employee employee: employees){
            if(employee.getBranch().equalsIgnoreCase(branch) && employee.isCompanyTransport())
                count++;
        }
        return count;
    }
    public static Employee findEmployeeWithSecondHighestRating(Employee[] employees){
        List<Employee> newList = new ArrayList<Employee>();
        for(Employee employee: employees){
            if(!employee.isCompanyTransport())
                newList.add(employee);
        }
        if(newList.size()<2) return null;
        Collections.sort(newList, new Sort());
        return newList.get(newList.size()-2);
    }
}
class Sort implements Comparator<Employee>{
    public int compare(Employee obj1, Employee obj2){
        return (int)(obj1.getRating() - obj2.getRating());
    }
}
class Employee{
    private int employeeId;
    private String name, branch;
    private double rating;
    private boolean companyTransport;
    public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport){
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }
    public double getRating() {
        return rating;
    }
    public boolean isCompanyTransport() {
        return companyTransport;
    }
}
