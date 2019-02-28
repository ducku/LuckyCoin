import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LuckCoin {

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 
  
        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>(); 
  
        // Traverse through the first list 
        for (T element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 
	
	public static void takeTurn(ArrayList<Person> people, int N) {
		Random rand = new Random();
		ArrayList<Integer> entered = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (people.get(i).getCoins() != 0) {
				entered.add(i);
				people.get(i).subtractCoins();
			}
		}
		
		int winnerIndex = rand.nextInt(entered.size() - 1);
		int initialCoins = people.get(winnerIndex).getCoins();
		int coinsWon = entered.size();
		people.get(winnerIndex).setCoins(initialCoins + coinsWon);
	}
	
	public static int countPeopleWithMoney(ArrayList<Person> people) {
		int counter = 0;
		for(int i = 0; i < people.size(); i++) {
			if(people.get(i).getCoins() != 0) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {

/*		Scanner scanner = new Scanner(System.in);
		System.out.println("amount of people:");
		int N = scanner.nextInt();
		System.out.println("amount of coins");
		int C = scanner.nextInt();
		scanner.close(); */
		
		for(int ci = 0; ci< 11;ci++) {
		int x = 1000000;
		int roundsTakenTotals[] = new int[x];

		for(int j = 0; j < x; j++) {
		int N = 10;
		int C = ci;
		
		ArrayList<Person> people = new ArrayList<Person>();
		for (int i = 0; i < N; i++) {
			people.add(new Person(C));
		}
		
		int roundsTaken = 0;
		
		while(countPeopleWithMoney(people) > 1) {
			takeTurn(people, N);
			roundsTaken++;
		} 
		roundsTakenTotals[j] = roundsTaken;
		}
		
		int sum = 0;
		for(int i = 0; i < x; i++) {
			sum = sum + roundsTakenTotals[i];
		}
		float average = (float)sum / x;
		System.out.println("Average: C:"  + ci + " - "+ average);
		}
		
/*		int x = 10000000;
		ArrayList<Integer> roundsTakenVariety = new ArrayList<Integer>();

		for(int j = 0; j < x; j++) {
		int N = 5;
		int C = 4;
		
		ArrayList<Person> people = new ArrayList<Person>();
		for (int i = 0; i < N; i++) {
			people.add(new Person(C));
		}
		
		int roundsTaken = 0;
		
		while(countPeopleWithMoney(people) > 1) {
			takeTurn(people, N);
			roundsTaken++;
		} 
		roundsTakenVariety.add(roundsTaken);
		}
		
		ArrayList<Integer> uniqueRoundsTaken = removeDuplicates(roundsTakenVariety);
		uniqueRoundsTaken.sort(null);
		for(int i = 0; i < uniqueRoundsTaken.size(); i++) {
			System.out.println(uniqueRoundsTaken.get(i));
		} */
	}
}
