import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LuckCoin {

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 

        ArrayList<T> newList = new ArrayList<T>(); 

        for (T element : list) { 

            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 


    public static double mean(ArrayList<Integer> ary) {
  	  double avg = 0;
  	  int t = 1;
  	  for (double x : ary) {
  	    avg += (x - avg) / t;
  	    ++t;
  	  }
  	  return avg;
  	}
    
    public static int totalCoins(ArrayList<Person> people) {
    		int result = 0;
    		for(int i = 0; i < people.size(); i++) {
    			result += people.get(i).getCoins();
    		}
    		return result;
    }
	
	public static void takeTurn(ArrayList<Person> people, int N) {
		Random rand = new Random();
		ArrayList<Person> entered = new ArrayList<Person>();
		for (int i = 0; i < N; i++) {
			if (people.get(i).getCoins() > 0) {
				entered.add(people.get(i));
				people.get(i).subtractCoins();
			}
		}
		
		int winnerIndex = (rand.nextInt(entered.size()));
		int initialCoins = entered.get(winnerIndex).getCoins();
		int coinsWon = entered.size();
		entered.get(winnerIndex).setCoins(initialCoins + coinsWon);
	}
	
	//Counts how many people still has money
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
		int x = 1000000;
		ArrayList<Integer> roundsTakenVariety = new ArrayList<Integer>();
		int N = 4;
		int C = 3;
	
		for(int j = 0; j < x; j++) {
		
		ArrayList<Person> people = new ArrayList<Person>();
		for (int i = 0; i < N; i++) {
			people.add(new Person(C));
		}
		
		int roundsTaken = 0;
		
		//if more than one person still has money left, keep playing
		while(countPeopleWithMoney(people) > 1) {
			takeTurn(people, N);
			roundsTaken++;
		}
		
		//Add the rounds taken into an arraylist for this simulation and run another simulation
		roundsTakenVariety.add(roundsTaken);
		}
		
		
		double average = mean(roundsTakenVariety);
		
		
		ArrayList<Integer> uniqueRoundsTaken = removeDuplicates(roundsTakenVariety);
		
		
		uniqueRoundsTaken.sort(null);
		//For every unique rounds taken value, print out its value, frequency, and percentage
		for(int i = 0; i < uniqueRoundsTaken.size(); i++) {
			int frequency = Collections.frequency(roundsTakenVariety, uniqueRoundsTaken.get(i));
			double percentage = (frequency * 100 / x);
			System.out.println("rounds taken: " + uniqueRoundsTaken.get(i) + " frequency: " +  frequency + " / " + x + "  percentage: " + percentage + "%");
		} 
		System.out.println("N: "+ N + " C: "+ C +" "+"Average: "+ average);
	}
	
	
}
