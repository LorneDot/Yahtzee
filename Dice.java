import java.lang.Math;

public class Dice{

	private int[] dice;
	private int length;

	public Dice(){
		this.dice = new int[5];
		this.length = this.dice.length;
	}

	//returns the number of dice.
	public int length(){
		return this.length;
	}

	//Returns the value for an individual die.
	public int getDie(int x){
		return this.dice[x];
	}

	//Resets the value for all the dice.
	public void resetDice(){
		for(int i = 0; i < this.dice.length; i++){
			this.dice[i] =0;
		}
	}

	//Returns a value from one to six.
	public int individualRoll(){
		return (int)(Math.random()*6)+1;
	}

	//Rolls all six dice.
	public void firstRoll(){
		for(int i = 0; i < this.dice.length; i++){
			this.dice[i] = individualRoll();
		}
	}

	//Checks to see if a die is in a list of dice.
	public boolean isIn(int i, String[] keptDice){

		boolean check = false;

		for(String die: keptDice){
			if(i == Integer.parseInt(die) -1){
				check = true;
			}
		}

		return check;
	}

	//Rerolls any dice which the player does not want to keep.
	public void nextRoll(String diceToKeep){
		String[] keptDice = diceToKeep.split(",");

		for(int i = 0; i < this.dice.length; i++){

			if(!isIn(i,keptDice)){
				this.dice[i] = individualRoll();
			}
		}
	}

	public String toString(){
		return (this.dice[0] + " " + this.dice[1]+ " " + this.dice[2]+ " " + this.dice[3]+ " " + this.dice[4]);	
	}

}