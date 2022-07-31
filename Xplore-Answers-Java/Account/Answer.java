import java.util.*;
public class Solution {
    public static void main(String[] args){
        int accountNumber;
        String accountName;
        String accountType;
        double accountBalance;
        Scanner s = new Scanner(System.in);
        Account[] accounts = new Account[4];
        for(int i=0; i<accounts.length; i++){
            accountNumber = s.nextInt();s.nextLine();
            accountName = s.nextLine();
            accountType = s.nextLine();
            accountBalance = s.nextDouble();
            accounts[i] = new Account(accountNumber, accountName, accountType, accountBalance);
        }
        s.nextLine();
        String newAccountName = s.nextLine();
        double newAccountBalance = s.nextDouble();
        s.close();
        int count = countAccountsByName(accounts, newAccountName);
        if(count > 0)
            System.out.println(count);
        else
            System.out.println("No Account found with given account name");

        Account[] accounts1 = searchAccountsByBalance(newAccountBalance, accounts);
        if(accounts1 == null)
            System.out.println("No such Account exists");
        else{
            for(Account account: accounts1){
                System.out.println(account.getAccountName());
            }
        }
    }
    public static int countAccountsByName(Account[] accounts, String accountName){
        int count = 0;
        for(Account account: accounts){
            if(account.getAccountName().equalsIgnoreCase(accountName))
                count++;
        }
        return count;
    }
    public static Account[] searchAccountsByBalance(double accountBalance, Account[] accounts){
        List<Account> newList = new ArrayList<>();
        for(Account account: accounts){
            if(account.getAccountBalance()>=accountBalance)
                newList.add(account);
        }
        if(newList.size() == 0) return null;
        Collections.sort(newList, new Sort());
        Account[] accounts1 = newList.toArray(new Account[newList.size()]);
        return accounts1;
    }
}
class Sort implements Comparator<Account>{
    public int compare(Account obj1, Account obj2){
        return (int)(obj1.getAccountBalance() - obj2.getAccountBalance());
    }
}
class Account{
    private int accountNumber;
    private String accountName;
    private String accountType;
    private double accountBalance;
    public Account(int accountNumber, String accountName, String accountType, double accountBalance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountName() {
        return accountName;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
}
