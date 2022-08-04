import java.util.Scanner;

class Appliance {
  private int applianceId;
  private String applianceName;
  private String applianceCategory;
  private double applianceAmount;

  public Appliance(int applianceId, String applianceName, String applianceCategory, double applianceAmount) {
    this.applianceId = applianceId;
    this.applianceName = applianceName;
    this.applianceCategory = applianceCategory;
    this.applianceAmount = applianceAmount;
  }

  public double getApplianceAmount() {
    return applianceAmount;
  }

  public String getApplianceCategory() {
    return applianceCategory;
  }

  public int getApplianceId() {
    return applianceId;
  }

  public String getApplianceName() {
    return applianceName;
  }

  public void setApplianceAmount(double applianceAmount) {
    this.applianceAmount = applianceAmount;
  }
}

public class MyClass {
  public static double getApplianceAmount(Appliance[] appliances, int applianceId, boolean insurance) {
    double newApplianceAmount = 0;
    for (int i = 0; i < appliances.length; i++) {
      if (appliances[i].getApplianceId() == applianceId) {
        if (insurance == true) {
          newApplianceAmount = appliances[i].getApplianceAmount() + ((appliances[i].getApplianceAmount() * 20) / 100);
          appliances[i].setApplianceAmount(newApplianceAmount);
        }
      }
    }
    return newApplianceAmount;
  }

  public static Appliance getCostliestAppliance(Appliance[] appliances, String applianceCategory) {
    double maxCost = -999;
    Appliance appliances1 = null;
    for (int i = 0; i < appliances.length; i++) {
      if (applianceCategory.equalsIgnoreCase(appliances[i].getApplianceCategory())) {
        if (appliances[i].getApplianceAmount() > maxCost) {
          maxCost = appliances[i].getApplianceAmount();
          appliances1 = appliances[i];
        }
      }
    }
    return appliances1;
  }

  public static void main(String[] args) {
    int applianceId;
    String applianceName;
    String applianceCategory;
    double applianceAmount;
    boolean insurance;
    Appliance[] appliances = new Appliance[4];
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < appliances.length; i++) {
      applianceId = s.nextInt();
      s.nextLine();
      applianceName = s.nextLine();
      applianceCategory = s.nextLine();
      applianceAmount = s.nextDouble();
      appliances[i] = new Appliance(applianceId, applianceName, applianceCategory, applianceAmount);
    }

    s.nextLine();
    int applianceId1 = s.nextInt();
    boolean insurance1 = s.nextBoolean();
    s.nextLine();
    String applianceCategory1 = s.nextLine();

    double applianceAmount1 = getApplianceAmount(appliances, applianceId1, insurance1);
    System.out.println(applianceAmount1);

    Appliance appl = getCostliestAppliance(appliances, applianceCategory1);
    System.out.println("Appliance Id: " + appl.getApplianceId() + " Appliance Name: " + appl.getApplianceName()
        + " Total Amount: " + appl.getApplianceAmount());
  }
}
