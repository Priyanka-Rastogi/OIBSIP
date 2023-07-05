import java.util.Scanner;

class atm{
	String name;
	String username;
	String password;
	String accountNo;
	double balance=100000;
	int transactions=0;
	String transactionHistory="";
	
	
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name:");
		this.name=sc.nextLine();
		System.out.println("Enter Username:");
		this.username=sc.nextLine();
		System.out.println("Enter Your Password:");
		this.password=sc.nextLine();
		System.out.println("Enter your Account Number:");
		this.accountNo=sc.nextLine();
		System.out.println("Registration completed Successfully.\n Kindly Login in to your account...");
	}
	
	public boolean login() {
		boolean login=false;
		Scanner sc=new Scanner(System.in);
		while(!login) {
			System.out.println("Enter Username:");
			String username=sc.nextLine();
			if(username.equals(username)) {
				while(!login) {
					System.out.println("Enter your Password:");
					String password=sc.nextLine();
					if(password.equals(password)) {
						System.out.println("Login Successful!!!");
						login=true;
					}
					else
						System.out.println("Invalid login!!!");
				}
			}
			
		}
		return login;
	}
	
	public void withdraw() {
		System.out.println("Enter the amount to be withdrawn:");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		try {
			if(balance>=amount) {
				balance=balance-amount;
				System.out.println("Money Withdrawl succesful");
				String str="Rs"+amount+"withdrawl";
				transactionHistory=transactionHistory.concat(str);
			}
			else 
				System.out.println("Insufficient Balance.");
			}catch(Exception e) {
				
			}
		}
	public void deposit() {
		System.out.println("Enter the amount to be deposit:");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		try {
			if(balance<=10000.00) {
				transactions++;
				balance=balance+amount;
				System.out.println("Deposit successful!!!");
				String str="Rs"+amount+"deposit\n";
				transactionHistory=transactionHistory.concat(str);
			}
			else 
				System.out.println("Limit Exceeded");
			}catch(Exception e) {
				
			}
		}
	
	public void transfer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter recepient name :");
		String recepient=sc.nextLine();
		System.out.println("enter amount to be tranferred:");
		double amount=sc.nextDouble();
		try {
			if(balance>=amount) {
				if(amount<=50000.0) {
					transactions++;
					balance=balance-amount;
					System.out.println("Successfully transfered to"+recepient);
					String str="Rs"+amount+"Transfered to"+recepient;
					transactionHistory=transactionHistory.concat(str);
				}else
					System.out.println("Limit is 5000.00");
			}else
				System.out.println("Insufficient Balance!!!");
		
		}catch(Exception e) {
			
		}
	}
	public void checkBalance() {
		System.out.println("Rs"+balance);
	}
	
	public void transHistory() {
		if(transactions==0)
			System.out.println("Empty!!!");
		else
			System.out.println(transactionHistory);
	}
}
public class ATM_Machine {
	public static int takeinput(int lmt) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input>lmt|| input<1) {
					System.out.println("Select the number between 1 to " + lmt);
					flag=false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter integer value only");
				flag=false;
				
			}
		}
		return input;
	}
	
	public static void main(String[] args)
	{
		System.out.println("\n WELCOME TO SBI ATM  \n");
		System.out.println("1.Register\n2.Exit");
		System.out.println("Enter your choice : ");
		int choice=takeinput(2);
		if(choice==1)
		{
			atm m=new atm();
			m.register();
			while(true) {
				System.out.println("\n1.Login\n2.Exit");
				System.out.println("Enter your Choice:");
				int ch=takeinput(2);
				if(ch==1) {
					if(m.login()) {
						System.out.println("\nWelcome Back!!!"+m.name);
						boolean isFinished = false;
						while(!isFinished)
						{
							System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Check Balance");
							System.out.print("ENter your choice : ");
							int c= takeinput(6);
							switch(c)
							{
							case 1:
								m.deposit();
								break;
							case 2:
								m.withdraw();
								break;
							case 3:
								m.transfer();
								break;
							case 4:
								m.transHistory();
								break;
							case 5:
								m.checkBalance();
								break;
							case 6:
								isFinished  = true;
								break;
							default:
								System.out.println("\nWrong Choice!");
							}
						}
					}
				}else
					System.exit(0);
			}
		}
		
	};
}