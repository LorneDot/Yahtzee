import java.util.Scanner;

public class Yahtzee{

	private static Scanner scanner;
	private static Dice dice;
	private static Score score;
	private static Player[] players;


	//Main method which intializes the score object, dice, object and player objects. After that it starts the game.
	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		dice = new Dice();
		score = new Score(dice);
		getPlayers();
		play();
		
	}
		
	//Method that loops through 13 rounds and each player.
	public static void play(){
		System.out.println("Starting the game....\n");
		for(int i = 1; i <= 13; i++){
			System.out.println("Round: " + i);
			System.out.println();
			for(int p = 0; p < players.length; p++){
				playerTurn(p);
				scorePlayer(p);
				System.out.println();
				System.out.println(players[p]);
			}
		}
		for(Player p: players){
			score.scoreUpperBoxBonus(p);
			score.scoreUpperBoxTotal(p);
			score.scoreLowerBoxTotal(p);
			score.scoreTotal(p);
			System.out.println(p.getName() + ": " + p.getTotalScore());
		}
	}

	//Method which returns the user input as an int.
	public static int intUserInput(Scanner scanner){
		String response = scanner.next();
		int iResponse = 0;
		try{
			iResponse = Integer.parseInt(response);
		} catch(NumberFormatException e){
				System.out.println("Please try again and enter a number.");
				intUserInput(scanner);
		}
		return iResponse;
	}

	//Method which returns the user input as a string.
	public static String stringUserInput(Scanner scanner){
		return scanner.next();
	}

	//The logic to score for a player at the end of their turn.
	public static void scorePlayer(int p){
		System.out.println("Which category do you want to score?");
		System.out.println();
		System.out.println("1->Ones");
		System.out.println("2->Twos");
		System.out.println("3->Threes");
		System.out.println("4->Fours");
		System.out.println("5->Fives");
		System.out.println("6->Sixes");
		System.out.println("7->Three of a kind");
		System.out.println("8->Four of a kind");
		System.out.println("9->Small straight");
		System.out.println("10->Large straight");
		System.out.println("11->Full house");
		System.out.println("12->Chance");
		System.out.println("13->Yahtzee");
		System.out.println();
		System.out.print("Category: ");
		int response = intUserInput(scanner);
		if(response==1){
			score.scoreOnes(players[p]);
		}else if(response==2){
			score.scoreTwos(players[p]);
		}else if(response==3){
			score.scoreThrees(players[p]);
		}else if(response==4){
			score.scoreFours(players[p]);
		}else if(response==5){
			score.scoreFives(players[p]);
		}else if(response==6){
			score.scoreSixes(players[p]);
		}else if(response==7){
			score.scoreThreeOfAKind(players[p]);
		}else if(response==8){
			score.scoreFourOfAKind(players[p]);
		}else if(response==9){
			score.scoreSmallStraight(players[p]);
		}else if(response==10){
			score.scoreLargeStraight(players[p]);
		}else if(response==11){
			score.scoreFullHouse(players[p]);
		}else if(response==12){
			score.scoreChance(players[p]);
		}else if(response==13){
			score.scoreYahtzee(players[p],scanner);

		}
	}

	//Gets the number of players and their names.
	public static void getPlayers(){
		System.out.println("How many players are there? ");
		int numOfPlayers = intUserInput(scanner);
		if(numOfPlayers > 0){
			Player[] playersArray = new Player[numOfPlayers];
			System.out.println();
			for(int i = 1; i <= numOfPlayers; i++){
				System.out.println("Enter player " + i + " name: ");
				String playerName = scanner.next();
				players[i-1] = new Player(playerName);
				System.out.println();
				players = playersArray;
			} 
		}else {
			System.out.println("Enter a number of players greater than 0.");
			getPlayers();
		}
	}

	//Logic for a players turn.
	public static void playerTurn(int p){
		System.out.println(players[p].getName()+"'s turn");
		System.out.println();
			System.out.println("rolling....");
			dice.firstRoll();
			System.out.println(dice);
			System.out.println();
			System.out.print("Do you want to roll again?(y/n): ");
			if(stringUserInput(scanner).toUpperCase().equals("Y")){
				System.out.println();
				System.out.print("Which die do you want to keep?(1,2,3,etc): ");
				dice.nextRoll(scanner.next());
				System.out.println();
				System.out.println("Rolling....");
				System.out.println(dice);
				System.out.println();
				System.out.print("Do you want to roll again?(y/n): ");
				if(stringUserInput(scanner).toUpperCase().equals("Y")){
					System.out.println();
					System.out.print("Which die do you want to keep?(1,2,3,etc): ");
					dice.nextRoll(stringUserInput(scanner));
					System.out.println();
					System.out.println("Rolling....");
					System.out.println(dice);
				}
			}
		System.out.println();
	}

}
	
