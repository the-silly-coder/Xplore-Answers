import java.util.*;
import java.lang.*;
public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Theatre[] theatres = new Theatre[4];
        for(int i=0; i< theatres.length; i++){
            int theatreId = s.nextInt();s.nextLine();
            String theatreName = s.nextLine();
            int seatCapacity = s.nextInt();s.nextLine();
            double ticketRate = s.nextDouble();
            double theatreRating = s.nextDouble();
            boolean balconyAvailable = s.nextBoolean();
            theatres[i] = new Theatre(theatreId, theatreName, seatCapacity, ticketRate, theatreRating, balconyAvailable);
        }
        int newTheatreId = s.nextInt();
        int newCapacity = s.nextInt();
        s.close();
        String theatreCategory = findTheatreCategory(theatres, newTheatreId);
        if(theatreCategory == null)
            System.out.println("There is no Theatre with the given Theatre ID");
        else
            System.out.println(theatreCategory);

        Theatre[] newTheatres = searchTheatreByCategory(theatres, newCapacity);
        if(newTheatres == null)
            System.out.println("Only  low capacity theatres available");
        else
            for(Theatre theatre: newTheatres){
                System.out.println(theatre.getTheatreId());
            }
    }
    public static String findTheatreCategory(Theatre[] theatres, int theatreId){
        for(Theatre theatre: theatres){
            if(theatre.getTheatreId() == theatreId) {
                if (theatre.isBalconyAvailable() && theatre.getTheatreRating() > 4)
                    return "Ultra Premium";
                else if (theatre.isBalconyAvailable() && (theatre.getTheatreRating() >= 3 && theatre.getTheatreRating() < 4))
                    return "Premium";
                else
                    return "Normal";
            }
        }
        return null;
    }
    public static Theatre[] searchTheatreByCategory(Theatre[] theatres, int seatCapacity){
        List<Theatre> newList = new ArrayList<Theatre>();
        for(Theatre theatre: theatres){
            if(theatre.getSeatCapacity() > seatCapacity)
                newList.add(theatre);
        }
        if(newList.size() == 0) return null;
        Collections.sort(newList, new Sort());
        Theatre[] newTheatres = newList.toArray(new Theatre[newList.size()]);
        return newTheatres;
    }
}
class Sort implements Comparator<Theatre>{
    public int compare(Theatre obj1, Theatre obj2){
        return (int)(obj1.getTicketRate() - obj2.getTicketRate());
    }
}
class Theatre{
    private int theatreId;
    private String theatreName;
    private int seatCapacity;
    private double ticketRate;
    private double theatreRating;
    private boolean balconyAvailable;
    public Theatre(int theatreId, String theatreName, int seatCapacity, double ticketRate, double theatreRating, boolean balconyAvailable){
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.seatCapacity = seatCapacity;
        this.ticketRate = ticketRate;
        this.theatreRating = theatreRating;
        this.balconyAvailable = balconyAvailable;
    }
    public int getTheatreId() {
        return theatreId;
    }
    public String getTheatreName() {
        return theatreName;
    }
    public int getSeatCapacity() {
        return seatCapacity;
    }
    public double getTicketRate() {
        return ticketRate;
    }
    public double getTheatreRating() {
        return theatreRating;
    }
    public boolean isBalconyAvailable() {
        return balconyAvailable;
    }
}
