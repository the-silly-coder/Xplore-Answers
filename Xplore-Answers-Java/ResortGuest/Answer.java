import java.util.*;
import java.lang.*;
public class Solution {
    public static void main(String[] args){
        int guestId;
        String guestName;
        String dateOfBooking;
        int noOfRoomsBooked;
        String mealOption;
        double totalBill;
        Scanner s = new Scanner(System.in);
        ResortGuest[] resortGuests = new ResortGuest[4];
        for(int i=0; i<resortGuests.length; i++){
            guestId = s.nextInt();s.nextLine();
            guestName = s.nextLine();
            dateOfBooking = s.nextLine();
            noOfRoomsBooked = s.nextInt();s.nextLine();
            mealOption = s.nextLine();
            totalBill = s.nextDouble();
            resortGuests[i] = new ResortGuest(guestId, guestName, dateOfBooking, noOfRoomsBooked, mealOption, totalBill);
        }
        s.nextLine();
        String month = s.nextLine();
        String mealOpted = s.nextLine();
        s.close();

        int roomsBooked = findNumberOfRoomsBookedInMonth(resortGuests, month);
        if(roomsBooked == 0)
            System.out.println("No rooms booked");
        else
            System.out.println(roomsBooked);

        ResortGuest resortGuest = searchResortGuestByMealOpted(resortGuests, mealOpted);
        if(resortGuest == null)
            System.out.println("No such meal");
        else
            System.out.println(resortGuest.getGuestId());
    }
    public static int findNumberOfRoomsBookedInMonth(ResortGuest[] resortGuests, String month){
        int countOfRoomsBooked = 0;
        for(ResortGuest resortGuest: resortGuests){
            String tempMonth = resortGuest.getDateOfBooking().substring(3,6);
            if(tempMonth.equalsIgnoreCase(month))
                countOfRoomsBooked++;
        }
        return countOfRoomsBooked;
    }
    public static ResortGuest searchResortGuestByMealOpted(ResortGuest[] resortGuests, String mealOpted){
        List<ResortGuest> tempList = new ArrayList<ResortGuest>();
        for(ResortGuest resortGuest: resortGuests){
            if(resortGuest.getMealOption().equalsIgnoreCase(mealOpted)){
                tempList.add(resortGuest);
            }
        }
        if(tempList.size() == 0) return null;
        Collections.sort(tempList, new Comparison());
        return tempList.get(tempList.size()-2);
    }
}
class Comparison implements Comparator<ResortGuest>{
    public int compare(ResortGuest obj1, ResortGuest obj2){
        return (int)(obj1.getTotalBill() - obj2.getTotalBill());
    }
}
class ResortGuest{
    private int guestId;
    private String guestName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String mealOption;
    private double totalBill;
    public ResortGuest(int guestId, String guestName, String dateOfBooking, int noOfRoomsBooked, String mealOption, double totalBill){
        this.guestId = guestId;
        this.guestName = guestName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.mealOption = mealOption;
        this.totalBill = totalBill;
    }
    public int getGuestId(){
        return guestId;
    }
    public String getGuestName(){
        return guestName;
    }
    public String getDateOfBooking(){
        return dateOfBooking;
    }
    public int getNoOfRoomsBooked(){
        return noOfRoomsBooked;
    }
    public String getMealOption(){
        return mealOption;
    }
    public double getTotalBill(){
        return totalBill;
    }
}
