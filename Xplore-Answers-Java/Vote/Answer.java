import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args){
        int voterId;
        String voterName;
        int voterAge;
        boolean isVoteCasted;
        String constituency;
        Scanner scanner = new Scanner(System.in);
        Vote[] votes = new Vote[4];
        for(int i=0; i<votes.length; i++){
            voterId = scanner.nextInt();scanner.nextLine();
            voterName = scanner.nextLine();
            voterAge = scanner.nextInt();
            isVoteCasted = scanner.nextBoolean();scanner.nextLine();
            constituency = scanner.nextLine();
            votes[i] = new Vote(voterId, voterName, voterAge, isVoteCasted, constituency);
        }
        String checkConstituency = scanner.nextLine();
        scanner.close();
        int totalVotesCasted = findTotalVotesCastedByConstituency(votes, checkConstituency);
        if(totalVotesCasted == 0)
            System.out.println("No votes casted");
        else
            System.out.println(totalVotesCasted);
        int[] voterAgeArray = searchVoterByAge(votes);
        if(voterAgeArray == null)
            System.out.println("No such voters");
        else
            for(int voter: voterAgeArray)
                System.out.println(voter);
    }
    public static int findTotalVotesCastedByConstituency(Vote[] votes, String constituency){
        int totalVotesCasted = 0;
        for(Vote vote: votes){
            if(constituency.equalsIgnoreCase(vote.getConstituency())){
                if(vote.getIsVoteCasted())
                    totalVotesCasted++;
            }
        }
        return totalVotesCasted;
    }
    public static int[] searchVoterByAge(Vote[] votes){
         ArrayList<Integer> arrayOfVoterIdList = new ArrayList<Integer>();
         for(Vote vote: votes){
             if(vote.getVoterAge() < 30){
                 arrayOfVoterIdList.add(vote.getVoterId());
             }
         }
         if(arrayOfVoterIdList.size() == 0) return null;
         Collections.sort(arrayOfVoterIdList);
         int[] array = arrayOfVoterIdList.stream().mapToInt(i -> i).toArray();
         return array;
    }
}

class Vote{
    private int voterId;
    private String voterName;
    private int voterAge;
    private boolean isVoteCasted;
    private String constituency;
    public Vote(int voterId, String voterName, int voterAge, boolean isVoteCasted, String constituency){
        this.voterId = voterId;
        this.voterName = voterName;
        this.voterAge = voterAge;
        this.isVoteCasted = isVoteCasted;
        this.constituency = constituency;
    }
    public int getVoterId(){
        return voterId;
    }
    public String getVoterName(){
        return voterName;
    }
    public int getVoterAge(){
        return voterAge;
    }
    public boolean getIsVoteCasted(){
        return isVoteCasted;
    }
    public String getConstituency(){
        return constituency;
    }
}
