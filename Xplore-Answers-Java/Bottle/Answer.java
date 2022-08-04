import java.util.Scanner;

//code the class
class Bottle {
  private int bottleId;
  private String bottleBrand;
  private String bottleType;
  private int capacity;
  private String material;
  private double price;

  public Bottle() {
  }

  public Bottle(int bottleId, String bottleBrand, String bottleType, int capacity, String material, double price) {
    this.bottleId = bottleId;
    this.bottleBrand = bottleBrand;
    this.bottleType = bottleType;
    this.capacity = capacity;
    this.material = material;
    this.price = price;
  }

  public String getBottleBrand() {
    return bottleBrand;
  }

  public int getBottleId() {
    return bottleId;
  }

  public String getBottleType() {
    return bottleType;
  }

  public int getCapacity() {
    return capacity;
  }

  public String getMaterial() {
    return material;
  }

  public double getPrice() {
    return price;
  }
}

public class Solution {

  // code the first method
  public static int getAvgPriceBasedOnMaterial(Bottle[] bottles, String material) {
    double totalCartPrice = 0;
    int count = 0;
    for (int iterator = 0; iterator < bottles.length; iterator++) {
      if (material.equalsIgnoreCase(bottles[iterator].getMaterial())) {
        totalCartPrice += bottles[iterator].getPrice();
        count++;
      }
    }
    if (count > 0)
      return (int) totalCartPrice / count;
    else
      return 0;
  }

  // code the second method
  public static Bottle getBottleBySecondHighestPrice(Bottle[] bottles, String bottleBrand) {
    int count = 0;
    for (int i = 0; i < bottles.length; i++) {
      if (bottleBrand.equalsIgnoreCase(bottles[i].getBottleBrand()))
        count++;
    }
    if (count == 0)
      return null;
    Bottle[] b = new Bottle[count];
    count = 0;
    for (int i = 0; i < bottles.length; i++) {
      if (bottleBrand.equalsIgnoreCase(bottles[i].getBottleBrand())) {
        b[count++] = bottles[i];
      }
    }
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b.length; j++) {
        if (b[i].getPrice() < b[j].getPrice()) {
          Bottle temp = b[i];
          b[i] = b[j];
          b[j] = temp;
        }
      }
    }
    return b[1];
  }

  public static void main(String[] args) {
    // code to read values
    int bottleId;
    String bottleBrand;
    String bottleType;
    int capacity;
    String material;
    double price;
    Bottle[] bottles = new Bottle[4];
    Scanner s = new Scanner(System.in);
    for (int iterator = 0; iterator < bottles.length; iterator++) {
      bottleId = s.nextInt();
      s.nextLine();
      bottleBrand = s.nextLine();
      bottleType = s.nextLine();
      capacity = s.nextInt();
      s.nextLine();
      material = s.nextLine();
      price = s.nextDouble();
      bottles[iterator] = new Bottle(bottleId, bottleBrand, bottleType, capacity, material, price);
    }
    s.nextLine();
    String newMaterialValue = s.nextLine();
    String newBottleBrandValue = s.nextLine();
    s.close();
    // code to call required method
    int averagePriceBasedOnMaterial = getAvgPriceBasedOnMaterial(bottles, newMaterialValue);
    Bottle secondHighestBottlePrice = getBottleBySecondHighestPrice(bottles, newBottleBrandValue);
    // code to display the result
    if (averagePriceBasedOnMaterial > 0)
      System.out.println(averagePriceBasedOnMaterial);
    else
      System.out.println("There is no matching bottles with the given material");

    if (secondHighestBottlePrice == null)
      System.out.println("Bottles are not available for the given brand");
    else
      System.out.println("Bottle Brand :" + secondHighestBottlePrice.getBottleBrand() + ",Bottle Capacity in ml :"
          + secondHighestBottlePrice.getCapacity() + ",Price :" + secondHighestBottlePrice.getPrice());

  }

}
