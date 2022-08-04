import java.util.*;
class Employee{
    int employeeId;
    String employeeName;
    double salary;
    String grade;
    String location;
    int yearsOfExperience;
    Employee(int employeeId, String employeeName, double salary, String grade, String location, int yearsOfExperience){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.grade = grade;
        this.location = location;
        this.yearsOfExperience = yearsOfExperience;
    }
    int getEmployeeId(){
        return employeeId;
    }
    String getEmployeeName(){
        return employeeName;
    }
    double getSalary(){
        return salary;
    }
    String getGrade(){
        return grade;
    }
    String getLocation(){
        return location;
    }
    int getYearsOfExperience(){
        return yearsOfExperience;
    }
}

public class Solution{
    public static void main(String[] args){
        int employeeId;
        String employeeName;
        double salary;
        String grade;
        String location;
        int yearsOfExperience;
        Employee[] emp = new Employee[4];
        Scanner s = new Scanner(System.in);
        for(int i=0;i<emp.length;i++){
            employeeId = s.nextInt();s.nextLine();
            employeeName = s.nextLine();
            salary = s.nextDouble();s.nextLine();
            grade = s.nextLine();
            location = s.nextLine();
            yearsOfExperience = s.nextInt();
            emp[i] = new Employee(employeeId, employeeName, salary, grade, location, yearsOfExperience);
        }
        s.nextLine();
        String newLocation = s.nextLine();
        String newGrade = s.nextLine();
        s.close();
        int countOfEmployees = findCountOfEmployeesByLoc(emp, newLocation);
        Employee emp1 = findHighestSalaryEmpDetailsWithGivenGrade(emp, newGrade);

        if(countOfEmployees == 0)
            System.out.println("There are no employees present in the given location and yearsOfExperience");
        else
            System.out.println(countOfEmployees);

        if(emp1 == null)
            System.out.println("No employees present in the given grade");
        else
            System.out.println(emp1.getEmployeeId()+":"+emp1.getEmployeeName()+":"+emp1.getLocation());
    }
    public static int findCountOfEmployeesByLoc(Employee[] emp, String location){
        int count = 0;
        for(int i=0;i<emp.length;i++){
            if(location.equalsIgnoreCase(emp[i].getLocation())){
                if(emp[i].getYearsOfExperience()>2){
                    count++;
                }
            }
        }
        return count;
    }
    public static Employee findHighestSalaryEmpDetailsWithGivenGrade(Employee[] emp, String grade){
        int count = 0;
        for(int i=0;i<emp.length;i++){
            if(grade.equalsIgnoreCase(emp[i].getGrade()))
                count++;
        }
        if(count == 0) return null;
        Employee[] emp1 = new Employee[count];
        count = 0;
        for(int i=0;i<emp.length;i++){
            if(grade.equalsIgnoreCase(emp[i].getGrade()))
                emp1[count++] = emp[i];
        }
        for(int i=0;i<emp1.length;i++){
            for(int j=i+1;j<emp1.length;j++){
                if(emp1[i].getSalary()>emp1[j].getSalary()){
                    Employee temp = emp1[i];
                    emp1[i] = emp1[j];
                    emp1[j] = temp;
                }
            }
        }
        return emp1[emp1.length-1];
    }
}
