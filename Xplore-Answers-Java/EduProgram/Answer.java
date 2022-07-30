import java.util.*;
public class Solution {
    public static void main(String[] args){
        EduProgram[] eduPrograms = new EduProgram[4];
        Scanner s = new Scanner(System.in);
        int i = 0;
        while(i< eduPrograms.length){
            String eduProgramName = s.nextLine();
            String sponsor = s.nextLine();
            int noOfPeopleAttended = s.nextInt();
            boolean stillAvailable = s.nextBoolean();
            boolean withinCountry = s.nextBoolean();s.nextLine();
            eduPrograms[i] = new EduProgram(eduProgramName, sponsor, noOfPeopleAttended, stillAvailable, withinCountry);
            i++;
        }
        String sponsorName = s.nextLine();
        s.close();
        String classification = findEduProgramClassification(eduPrograms);
        if(classification == null)
            System.out.println("EduPrograms are not available now");
        else
            System.out.println(classification);
        EduProgram[] eduPrograms1 = findEduProgramBySponsor(eduPrograms, sponsorName);
        if(eduPrograms1 == null)
            System.out.println("No EduProgram is available for the given sponsor");
        else{
            i = 0;
            while(i< eduPrograms1.length){
                System.out.println(eduPrograms1[i].getEduProgramName()+"\n"+eduPrograms1[i].getNoOfPeopleAttended());
                i++;
            }
        }
    }
    public static String findEduProgramClassification(EduProgram[] eduPrograms){
        int i = 0;
        while(i< eduPrograms.length){
            if(eduPrograms[i].isStillAvailable() && eduPrograms[i].isWithinCountry()){
                if(eduPrograms[i].getNoOfPeopleAttended() >= 1000)
                    return "EverGreen";
                else if(eduPrograms[i].getNoOfPeopleAttended()>=500 && eduPrograms[i].getNoOfPeopleAttended()<1000)
                    return "Golden";
                else if(eduPrograms[i].getNoOfPeopleAttended()<500)
                    return "Emerging Star";
            }
            i++;
        }
        return null;
    }
    public static EduProgram[] findEduProgramBySponsor(EduProgram[] eduPrograms, String sponsorName){
        int i = 0;
        List<EduProgram> newList = new ArrayList<>();
        while(i<eduPrograms.length){
            if(sponsorName.equalsIgnoreCase(eduPrograms[i].getSponsor())){
                newList.add(eduPrograms[i]);
            }
            i++;
        }
        if(newList.size() == 0) return null;
        Collections.sort(newList, new Sort());
        return newList.toArray(new EduProgram[newList.size()]);
    }
}
class Sort implements Comparator<EduProgram>{
    public int compare(EduProgram obj1, EduProgram obj2){
        return obj1.getNoOfPeopleAttended() - obj2.getNoOfPeopleAttended();
    }
}
class EduProgram{
    private String eduProgramName;
    private String sponsor;
    private int noOfPeopleAttended;
    private boolean stillAvailable, withinCountry;
    public EduProgram(String eduProgramName, String sponsor, int noOfPeopleAttended, boolean stillAvailable, boolean withinCountry){
        this.eduProgramName = eduProgramName;
        this.sponsor = sponsor;
        this.noOfPeopleAttended = noOfPeopleAttended;
        this.stillAvailable = stillAvailable;
        this.withinCountry = withinCountry;
    }
    public String getEduProgramName() {
        return eduProgramName;
    }
    public String getSponsor() {
        return sponsor;
    }
    public int getNoOfPeopleAttended() {
        return noOfPeopleAttended;
    }
    public boolean isStillAvailable() {
        return stillAvailable;
    }
    public boolean isWithinCountry() {
        return withinCountry;
    }
}
