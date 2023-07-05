import java.util.*;
import java.util.random.*;
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("********** NUMBER GUESSING GAME **********");
		int Flag=1;
		while(Flag==1) {
			
			Random random=new Random();
			//Generate a random number between 0 to 100
			int randomNumber=random.nextInt(100);
			int guessNumber=-1;
			int attempt=0;
			while(guessNumber!=randomNumber) {
				System.out.println("Guess the number between 1 To 100: ");
				guessNumber=sc.nextInt();
				attempt++;
				if(guessNumber==randomNumber) {
					System.out.println("Great!!! You guessed the correct number");
					System.out.println("It took total " +attempt+" attempt to Guess the number ");
					System.out.println("Enter 1 to play again:\nEnter 0 to exit: ");
					Flag=sc.nextInt();
				}
				else if(guessNumber>randomNumber) {
					System.out.println("Your number is higher than the actual number");
				}
				else
				{
					System.out.println("Your number is lesser than the actual number");
				}
			}
		}
		System.out.println("Game ends!!!");
		sc.close();
	}

}