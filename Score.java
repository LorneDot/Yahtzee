import java.util.Scanner;
public class Score{

	private Dice dice;

	public Score(Dice dice){
		this.dice = dice;
	}


	//Returns the sum of the dice, where each dice is equal to x.
	public int basicCalculate(int x){
		int calc = 0;
		for(int i = 0;i < this.dice.length(); i++){
			if(this.dice.getDie(i) == x){
				calc = calc + x;
			}
		}
		return calc;
	}


	//Calculates and sets the total score for a player.
	public void scoreTotal(Player player){
		player.setTotalScore(player.getLowerBoxSubtotal()+player.getUpperBoxTotal());

	}

	//Calculates and sets the lower box total score for a player.
	public void scoreLowerBoxTotal(Player player){
		player.setLowerBoxScore(player.getLowerBoxSubtotal()+(player.getExtraYahtzees()*100));
	}

	//Calculates and sets the upper box total score for a player.
	public void scoreUpperBoxTotal(Player player){
		player.setUpperBoxScore(player.getUpperBoxSubtotal()+player.getUpperBoxBonus());
	}

	//Calculates and set the upper box bonus for a player.
	public void scoreUpperBoxBonus(Player player){
		if(player.getUpperBoxSubtotal() > 62){
			player.setUpperBoxBonus(35);
		}

	}

	//Score the ones for a player.
	public void scoreOnes(Player player){
		if(!player.hasPlayedOnes()){
			player.setOnes(basicCalculate(1));
		}
	}

	//Scores the twos for a player.
	public void scoreTwos(Player player){
		if(!player.hasPlayedTwos()){
			player.setTwos(basicCalculate(2));
		}	
	}

	//Scores the threes for a player.
	public void scoreThrees(Player player){
		if(!player.hasPlayedThrees()){
			player.setThrees(basicCalculate(3));
		}
	}

	//Scores the fours for a player.
	public void scoreFours(Player player){
		if(!player.hasPlayedFours()){
			player.setThrees(basicCalculate(4));
		}
	}

	//Scores the fives for a player.
	public void scoreFives(Player player){
		if(!player.hasPlayedFives()){
			player.setFives(basicCalculate(5));
		}
	}

	//Scores the sixes for a player.
	public void scoreSixes(Player player){
		if(!player.hasPlayedSixes()){
			player.setSixes(basicCalculate(6));
		}
	}

	//Scores three of a kind for a player.
	public void scoreThreeOfAKind(Player player){
		if(!player.hasPlayedThreeOfAKind()){
			int score = 0;
			if(isThreeOfAKind()){
				for(int i = 0; i < this.dice.length();i++){
				score = score + this.dice.getDie(i);
				}
			}
			player.setThreeOfAKind(score);
		}
	}

	//Scores four of a kind for player.
	public void scoreFourOfAKind(Player player){
		if(!player.hasPlayedFourOfAKind()){
			int score = 0;
			if(this.isFourOfAKind()){
				for(int i = 0; i < this.dice.length();i++){
					score = score + this.dice.getDie(i);
				}
			}
			player.setFourOfAKind(score);
		}
	}

	//Scores a small straight for a player.
	public void scoreSmallStraight(Player player){
		if(isSmallStraight() && !player.hasPlayedSmallStraight()){
			player.setSmallStraight(30);
		}
	}


	//Scores a large straight for a player.
	public void scoreLargeStraight(Player player){
		if(isLargeStraight() && !player.hasPlayedLargeStraight()){
			player.setLargeStraight(40);
		}
	}

	//Scores a full house for a player.
	public void scoreFullHouse(Player player){
		if(this.isFullHouse() && !player.hasPlayedFullHouse()){
			player.setFullHouse(25);
		}
	}

	//Scores a yahtzee for a player. This includes the joker logic.
	public void scoreYahtzee(Player player, Scanner scanner){
		if(this.isYahtzee()){
			if(player.hasPlayedYahtzee()){
				if(player.getYahtzee() != 0){
					if(player.getExtraYahtzees() < 3){
						player.setExtraYahtzees();
						if(this.dice.getDie(0) == 1 && !player.hasPlayedOnes()){
							scoreOnes(player);
						} else if (this.dice.getDie(0) == 2 && !player.hasPlayedTwos()){
							scoreTwos(player);
						} else if (this.dice.getDie(0) == 3 && !player.hasPlayedThrees()){
							scoreThrees(player);
						} else if (this.dice.getDie(0) == 4 && !player.hasPlayedFours()){
							scoreFours(player);
						} else if (this.dice.getDie(0) == 5 && !player.hasPlayedFives()){
							scoreFives(player);
						} else if (this.dice.getDie(0) == 6 && !player.hasPlayedSixes()){
							scoreSixes(player);
						} else {
							System.out.print("Which category would you like to score it as?: ");
							System.out.println();
							int count = 0;
							String[] choices = new String[6];
							if(!player.hasPlayedThreeOfAKind()){
								count++;
								System.out.println(count+"->Three of a kind");
								choices[count-1] = "threeofakind";
							}
							if(!player.hasPlayedFourOfAKind()){
								count++;
								System.out.println(count+"->Four of a kind");
								choices[count-1] = "fourofakind";
							}
							if(!player.hasPlayedSmallStraight()){
								count++;
								System.out.println(count+"->Small straight");
								choices[count-1] = "smallstraight";
							}
							if(!player.hasPlayedLargeStraight()){
								count++;
								System.out.println(count+"->Large straight");
								choices[count-1] = "largestraight";
							}

							if(!player.hasPlayedFullHouse()){
								count++;
								System.out.println(count+"->Full house");
								choices[count-1] = "fullhouse";
							}

							if(!player.hasPlayedChance()){
								count++;
								System.out.println(count+"->Chance");
								choices[count-1] = "chance";
							}

							System.out.println();

							int response = Integer.parseInt(scanner.next());

							if(choices[response] == "threeofakind"){
								scoreThreeOfAKind(player);
							} else if (choices[response] == "fourofakind"){
								scoreFourOfAKind(player);
							} else if (choices[response] == "smallstraight"){
								scoreSmallStraight(player);
							} else if (choices[response] == "largestraight"){
								scoreLargeStraight(player);
							} else if (choices[response] == "fullhouse"){
								scoreFullHouse(player);
							} else if (choices[response] == "chance"){
								scoreChance(player);
							}

						}
					}
				}
				
			} else {
				player.setYahtzee(50);
			}
		}
	}


	//Scores chance for a player.
	public void scoreChance(Player player){
		if(!player.hasPlayedChance()){
			int score = 0;
			for(int i = 0; i < this.dice.length();i++){
				score = score + this.dice.getDie(i);
			}
			player.setChance(score);
		}
	}


	//returns an int array contain the count of each dice type. This is used to simplfy the logic for checking different tyes of rolls.
	public int[] evaluateDice(){
		int[] scoreDice = new int[6];
		for(int i = 0; i < this.dice.length();i++){
			scoreDice[this.dice.getDie(i)-1] = scoreDice[this.dice.getDie(i)-1] + 1;
		}
		return scoreDice;
	}

	//Returns true if the dice contain three of a kind.
	public boolean isThreeOfAKind(){
		int[] scoreDice = evaluateDice();
		for(int die: scoreDice){
			if(die > 2){
				return true;
			}
		}

		return false;
	}

	//Returns true if the dice contain four if a kind.
	public boolean isFourOfAKind(){
		int[] scoreDice = evaluateDice();
		for(int die: scoreDice){
			if(die > 3){
				return true;
			}
		}

		return false;
	}

	//Returns true if the dice contain a large straight.
	public boolean isLargeStraight(){

		int[] scoreDice = evaluateDice();

		int count = 0;

		for(int i = 0; i < scoreDice.length; i++){
			if(i == 0 && scoreDice[i] >= 1){
				count++;
			} else if(scoreDice[i] >= 1 && scoreDice[i-1] >= 1){
				count++;
			} else if(scoreDice[i] >= 1){
				count++;
			} else {
				count = 0;
			}
		}

		if(count == 5){
			return true;
		} else {
			return false;
		}

	}

	//Returns true if the dice contain a small straight.
	public boolean isSmallStraight(){

		int[] scoreDice = evaluateDice();

		int count = 0;

		for(int i = 0; i < scoreDice.length; i++){
			if(i == 0 && scoreDice[i] >= 1){
				count++;
			} else if(scoreDice[i] >= 1 && scoreDice[i-1] >= 1){
				count++;
			} else if(scoreDice[i] >= 1){
				count++;
			} else {
				count = 0;
			}
		}

		if(count == 5){
			return true;
		} else {
			return false;
		}

	}

	//Returns true if the dice contain a yahtzee.
	public boolean isYahtzee(){
		int[] scoreDice = evaluateDice();
		for(int die: scoreDice){
			if(die == 5){
				return true;
			}
		}

		return false;
	}

	//Returns true if the dice contain a full house.
	public boolean isFullHouse(){
		int[] scoreDice = evaluateDice();
		boolean three = false;
		boolean two = false;
		for(int die: scoreDice){
			if(die ==3){
				three = true;
			}
			if(die==2){
				two = true;
			}
		}

		return two && three; 
	}

 
}