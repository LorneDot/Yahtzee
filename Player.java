public class Player{

	//Private field to store the player name.
	private String name;

	//private field which hold the scores for the upper box.
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int upperBoxBonus;
	private int upperBoxScore;

	//private fields which hold the scores for the lower box.
	private int threeOfAKind;
	private int fourOfAKind;
	private int smallStraight;
	private int largeStraight;
	private int fullHouse;
	private int yahtzee;
	private int chance;
	private int extraYahtzees;
	private int lowerBoxScore;

	private int totalScore;

	//private fields which keep track of which rolls have been played.
	private boolean playedOnes;
	private boolean playedTwos;
	private boolean playedThrees;
	private boolean playedFours;
	private boolean playedFives;
	private boolean playedSixes;
	private boolean playedThreeOfAKind;
	private boolean playedFourOfAKind;
	private boolean playedSmallStraight;
	private boolean playedLargeStraight;
	private boolean playedYahtzee;
	private boolean playedFullHouse;
	private boolean playedChance;

	//Constructor for the player object.
	public Player(String name){
		this.name = name;
		this.playedOnes = false;
		this.playedTwos = false;
		this.playedThrees = false;
		this.playedFours = false;
		this.playedFives = false;
		this.playedSixes = false;
		this.playedThreeOfAKind = false;
		this.playedFourOfAKind = false;
		this.playedSmallStraight = false;
		this.playedLargeStraight = false;
		this.playedYahtzee = false;
		this.playedFullHouse = false;
		this.playedChance = false;
	}

	//Setters

	public void setOnes(int x){
		this.ones = x;
		this.playedOnes = true;
	}

	public void setTwos(int x){
		this.twos = x;
		this.playedTwos = true;
	}

	public void setThrees(int x){
		this.threes = x;
		this.playedThrees = true;
	}

	public void setFours(int x){
		this.fours = x;
		this.playedFours = true;
	}

	public void setFives(int x){
		this.fives = x;
		this.playedFives = true;
	}

	public void setSixes(int x){
		this.sixes = x;
		this.playedSixes = true;
	}

	public void setThreeOfAKind(int x){
		this.threeOfAKind = x;
		this.playedThreeOfAKind = true;
	}
	public void setFourOfAKind(int x){
		this.fourOfAKind = x;
		this.playedFourOfAKind = true;
	}
	public void setSmallStraight(int x){
		this.smallStraight = x;
		this.playedSmallStraight = true;
	}
	public void setLargeStraight(int x){
		this.largeStraight = x;
		this.playedLargeStraight = true;
	}
	public void setChance(int x){
		this.chance = x;
		this.playedChance = true;
	}
	public void setYahtzee(int x){
		this.yahtzee = x;
		this.playedYahtzee = true;
	}
	public void setExtraYahtzees(){
		this.extraYahtzees = this.extraYahtzees + 1;
	}
	public void setFullHouse(int x){
		this.fullHouse = x;
		this.playedFullHouse = true;
	}

	public void setUpperBoxBonus(int x){
		this.upperBoxBonus = x;
	}

	public void setUpperBoxScore(int x){
		this.upperBoxScore = x;
	}

	public void setLowerBoxScore(int x){
		this.lowerBoxScore =x;
	}

	public void setTotalScore(int x){
		this.totalScore = x;
	}

	//Getters

	public String getName(){
		return this.name;
	}

	public int getOnes(){
		return this.ones;
	}

	public int getTwos(){
		return this.twos;
	}

	public int getThrees(){
		return this.threes;
	}

	public int getFours(){
		return this.fours;
	}

	public int getFives(){
		return this.fives;
	}

	public int getSixes(){
		return this.sixes;
	}

	public int getLowerBoxSubtotal(){
		return this.fourOfAKind + this.threeOfAKind + this.smallStraight + this.largeStraight + this.fullHouse + this.chance + this.yahtzee;
	}

	public int getUpperBoxSubtotal(){
		return this.ones + this.twos + this.threes + this.fours + this.fives + this.sixes;
	}

	public int getTotalScore(){
		return this.totalScore;
	}

	public int getUpperBoxBonus(){
		return this.upperBoxBonus;
	}

	public int getUpperBoxTotal(){
		return this.upperBoxScore;
	}

	public boolean hasPlayedOnes(){
		return this.playedOnes;
	}

	public boolean hasPlayedTwos(){
		return this.playedTwos;
	}

	public boolean hasPlayedThrees(){
		return this.playedThrees;
	}

	public boolean hasPlayedFours(){
		return this.playedFours;
	}

	public boolean hasPlayedFives(){
		return this.playedFives;
	}

	public boolean hasPlayedSixes(){
		return this.playedSixes;
	}

	public boolean hasPlayedFourOfAKind(){
		return this.playedFourOfAKind;
	}

	public boolean hasPlayedThreeOfAKind(){
		return this.playedThreeOfAKind;
	}

	public boolean hasPlayedSmallStraight(){
		return this.playedSmallStraight;
	}

	public boolean hasPlayedLargeStraight(){
		return this.playedLargeStraight;
	}

	public boolean hasPlayedFullHouse(){
		return this.playedFullHouse;
	}

	public boolean hasPlayedChance(){
		return this.playedChance;
	}

	public boolean hasPlayedYahtzee(){
		return this.playedYahtzee;
	}

	public int getExtraYahtzees(){
		return this.extraYahtzees;
	}

	public int getYahtzee(){
		return this.yahtzee;
	}

	public String toString(){
		return this.name + "'s Score:\n\n"+"Ones: " + this.ones + "\nTwos: " 
		+ this.twos + "\nThrees: " + this.threes + "\nFours: " + this.fours + 
		"\nFives: " + this.fives +"\nSixes: "+ this.sixes + "\nUpper box bonus: " + this.upperBoxBonus + "\nThree of a kind: " + this.threeOfAKind 
		+ "\nFour of a kind: " + this.fourOfAKind + "\nSmall straight: " + this.smallStraight 
		+ "\nLarge straight: " + this.largeStraight + "\nFull house: " + this.fullHouse + "\nChance: " + this.chance 
		+ "\nYahtzee: " + this.yahtzee + "\nExtra Yahtzees: " + this.extraYahtzees + "\nLower box score: " + this.lowerBoxScore +"\nTotal Score" 
		+ this.totalScore;
	}

}