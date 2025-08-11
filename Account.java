
import java.util.*;


public class Account {

    private static int choice;
    private int accountNumber;
    // private String customerName;
    private int balance;
    private int amount;
    // private static Map<Integer, String> accNo =new HashMap<>();
    private static Set<Integer> accNo=new HashSet<>();
    private static List<String> transactHistory=new ArrayList<>();

    Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Account acc=new Account();
        
        // accNo.put(101,"Pavi");
        // accNo.put(102,"Poorni");
        // accNo.put(103,"Raj");
        // accNo.put(104,"Krish");
        // accNo.put(105,"Suresh");
        

        accNo.add(101);
        accNo.add(102);
        accNo.add(103);
        accNo.add(104);
        accNo.add(105);   

         int choice;
      do{
      
       
        System.out.println("--- Bank ---");
        System.out.println("Press 1 for Deposite");
        System.out.println("Press 2 for Withdraw");
        System.out.println("Press 3 for view Transaction History");
        System.out.println("Press 4 for view Balance");
        System.out.println("Press 5 for Exit");

        choice = acc.scanner.nextInt();

        switch(choice){
            case 1:
                acc.deposit();
                System.out.println();
                break;
            case 2:
                acc.withdraw();
                System.out.println();
                break;
            case 3:
                acc.transactionHistory();
                System.out.println();
                break;
            case 4:
                acc.checkBalance();
                System.out.println();
                break;
            case 5:
                 System.out.println("Exiting!");
                break;
            default:
                System.out.println("Invalid option. Please select correct option");
                System.out.println();
        }

        
      }while(choice!=5);

    }

    public void deposit(){
        System.out.print("Enter your account number: ");
        accountNumber = scanner.nextInt();

        if(accNo.contains(accountNumber)){
            System.out.println("Enter the amount to deposit: ");
            amount=scanner.nextInt();
            if(amount == 0){ 
                System.out.println("Please enter the amount!");
            }
        
        else{
            balance+=amount;
            transactHistory.add("Deposited : "+amount);
            System.out.println("Amount Deposited Successfully!");
        }
        }
        else{
            System.out.println("Invalid Account Number");
        }
    }

    public void withdraw(){
        System.out.print("Enter your account number: ");
        accountNumber = scanner.nextInt();

        if(accNo.contains(accountNumber)){
            System.out.println("Enter the amount to Withdraw");
            amount=scanner.nextInt();

            if(amount>0 && amount<=balance){
                balance-=amount;
                transactHistory.add("Withdraw : "+amount);
                System.out.println("Amount Withdraw Successfully");
               
            }
            else{
                 System.out.println("Sorry there is no enough amount to withdraw in your account!");
            }
        }
        else{
            System.out.println("Invalid Account Number");
        }
    }

     public void transactionHistory() {
        System.out.print("Enter your account number: ");
        accountNumber = scanner.nextInt();
        if(accNo.contains(accountNumber))
        {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactHistory) {
            System.out.println(transaction);
        }
    }
    else{
        System.out.println("Invalid Account Number");
    }
    }
   
    public void checkBalance(){
         System.out.print("Enter your account number: ");
        accountNumber = scanner.nextInt();
        if(accNo.contains(accountNumber)){
            System.out.println("Current Balance for account "+accountNumber+" is "+ balance);
        }
        else{
          System.out.println("Invalid Account Number");
        
    }
    }
}
