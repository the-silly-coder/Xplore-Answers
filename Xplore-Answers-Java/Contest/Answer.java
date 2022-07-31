import java.util.*;
import java.lang.*;
public class Solution {
    public static void main(String[] args){
        int contestId;
        String contestName;
        String contestWinner;
        int points;
        String category;
        Scanner s = new Scanner(System.in);
        Contest[] contests = new Contest[4];
        for(int i=0; i<contests.length; i++){
            contestId = s.nextInt();s.nextLine();
            contestName = s.nextLine();
            contestWinner = s.nextLine();
            points = s.nextInt();s.nextLine();
            category = s.nextLine();
            contests[i] = new Contest(contestId, contestName, contestWinner, points, category);
         }
        String newContestWinner = s.nextLine();
        String newCategory = s.nextLine();
        s.close();
        int totalPoints = findTotalPointsBasedOnWinner(contests, newContestWinner);
        if(totalPoints == 0)
            System.out.println("Contest Winner not found");
        else
            System.out.println(totalPoints);

        Contest contest = getContestWithSecondHighestPoints(contests, newCategory);
        if(contest == null)
            System.out.println("There is no matching contest");
        else
            System.out.println(contest.getContestName()+"\n"+contest.getPoints());;
    }
    public static int findTotalPointsBasedOnWinner(Contest[] contests, String contestWinner){
        int totalPoints = 0;
        for(Contest contest: contests){
            if(contest.getContestWinner().equalsIgnoreCase(contestWinner))
                totalPoints += contest.getPoints();
        }
        return totalPoints;
    }
    public static Contest getContestWithSecondHighestPoints(Contest[] contests, String category){
        List<Contest> newList = new ArrayList<Contest>();
        for(Contest contest: contests){
            if(contest.getCategory().equalsIgnoreCase(category))
                newList.add(contest);
        }
        if(newList.size()<=1) return null;
        Collections.sort(newList, new Sort());
        return newList.get(newList.size()-2);
    }
}
class Sort implements Comparator<Contest>{
    @Override
    public int compare(Contest obj1, Contest obj2) {
        return (int)(obj1.getPoints() - obj2.getPoints());
    }
}
class Contest{
    private int contestId;
    private String contestName;
    private String contestWinner;
    private int points;
    private String category;
    public Contest(int contestId, String contestName, String contestWinner, int points, String category){
        this.contestId = contestId;
        this.contestName = contestName;
        this.contestWinner = contestWinner;
        this.points = points;
        this.category = category;
    }
    public int getContestId() {
        return contestId;
    }
    public String getContestName() {
        return contestName;
    }
    public String getContestWinner(){
        return contestWinner;
    }
    public int getPoints() {
        return points;
    }
    public String getCategory() {
        return category;
    }
}
