import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int invoicenumber;
        String fromcity;
        String tocity;
        String orderdate;
        String deliverydate;
        double price;
        Package p[]=new Package[5];
        for(int i=0;i<p.length;i++) {
            invoicenumber=sc.nextInt();
            sc.nextLine();
            fromcity=sc.nextLine();
            tocity=sc.nextLine();
            orderdate=sc.nextLine();
            deliverydate=sc.nextLine();
            price=sc.nextDouble();
            p[i]=new Package(invoicenumber,fromcity,tocity,orderdate,deliverydate,price);
        }
        sc.nextLine();
        String c1=sc.nextLine();
        String c2=sc.nextLine();
        sc.close();
        int count=countOrdersDeliveredInAWeek(p,c1);
        if(count!=0)
            System.out.println(count);
        else
            System.out.println("No package delivered");
        Package pck=searchPackageByCity(p,c2);
        if(pck!=null) {
            System.out.println(pck.getinvoice());
            System.out.println(pck.getprice());
        }
        else
            System.out.println("No package found");
    }
    public static int countOrdersDeliveredInAWeek(Package p[], String c1) {
        int count=0;
        for(Package i:p) {
            if(c1.equalsIgnoreCase(i.getfromcity())){
                String od=i.getorderdate().substring(0,2);
                String dd=i.getdeliverydate().substring(0,2);
                int od1=Integer.parseInt(od);
                int dd1=Integer.parseInt(dd);
                if(dd1-od1<7)
                    count++;
            }
        }
        return count;
    }
    public static Package searchPackageByCity(Package p[], String c2) {
        ArrayList<Double> ar=new ArrayList<>();
        Package pck=new Package();
        for(Package i:p) {
            if(c2.equalsIgnoreCase(i.gettocity())) {
                ar.add(i.getprice());
            }
        }
        if(ar.size()!=0) {
            Collections.sort(ar,Collections.reverseOrder());
            double pr=ar.get(1);
            for(Package i:p) {
                if(pr==i.getprice()) {
                    pck=i;
                    return pck;
                }
            }
        }
        return null;
    }
}
class Package {
    private int invoicenumber;
    private String fromcity,tocity,orderdate,deliverydate;
    private double price;
    Package(){
    }
    Package(int invoicenumber, String fromcity, String tocity, String orderdate, String deliverydate, double price) {
        this.invoicenumber=invoicenumber;
        this.fromcity=fromcity;
        this.tocity=tocity;
        this.orderdate=orderdate;
        this.deliverydate=deliverydate;
        this.price=price;
    }
    public int getinvoice() {
        return invoicenumber;
    }
    public String getfromcity() {
        return fromcity;
    }
    public String gettocity() {
        return tocity;
    }
    public String getorderdate() {
        return orderdate;
    }
    public String getdeliverydate() {
        return deliverydate;
    }
    public double getprice() {
        return price;
    }
}
