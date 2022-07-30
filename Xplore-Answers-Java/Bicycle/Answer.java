import java.util.*;
public class Solution {
    public static void main(String[] args){
        Bicycle[] bicycles = new Bicycle[4];
        Scanner s = new Scanner(System.in);
        int i = 0;
        while(i< bicycles.length){
            String bicycleName = s.nextLine();
            String brand = s.nextLine();
            int cost = s.nextInt();
            int ageGroup = s.nextInt();s.nextLine();
            bicycles[i] = new Bicycle(bicycleName, brand, cost, ageGroup);
            i++;
        }
        String brandName = s.nextLine();
        int AgeGroup = s.nextInt();
        s.close();
        Bicycle[] bicycles1 = findBicycleByAgeGrp(bicycles, AgeGroup);
        if(bicycles1 == null)
            System.out.println("Bicycle is not available for the given Agegroup");
        else{
            i = 0;
            while(i<bicycles1.length){
                System.out.println(bicycles1[i].getBicycleName());
                i++;
            }
        }
        int totalCost = TotalCostByBrand(bicycles, brandName);
        if(totalCost == 0)
            System.out.println("No Bicycle is available for the given brand");
        else
            System.out.println(totalCost);
    }
    public static Bicycle[] findBicycleByAgeGrp(Bicycle[] bicycles, int ageGroup){
        List<Bicycle> newList = new ArrayList<>();
        for(Bicycle bicycle: bicycles){
            if(bicycle.getAgeGroup() <= ageGroup)
                newList.add(bicycle);
        }
        if(newList.size() == 0) return null;
        newList.sort(Comparator.comparing(Bicycle::getAgeGroup).reversed());
        return newList.toArray(new Bicycle[newList.size()]);
    }
    public static int TotalCostByBrand(Bicycle[] bicycles, String brand){
        int totalSum = 0;
        for(Bicycle bicycle: bicycles){
            if(bicycle.getBrand().equalsIgnoreCase(brand))
                totalSum += bicycle.getCost();
        }
        return totalSum;
    }
}
class Bicycle{
    private String bicycleName;
    private String brand;
    private int cost;
    private int ageGroup;
    public Bicycle(String bicycleName, String brand, int cost, int ageGroup){
        this.bicycleName = bicycleName;
        this.brand = brand;
        this.cost = cost;
        this.ageGroup = ageGroup;
    }
    public String getBicycleName() {
        return bicycleName;
    }
    public String getBrand() {
        return brand;
    }
    public int getCost() {
        return cost;
    }
    public int getAgeGroup() {
        return ageGroup;
    }
}
