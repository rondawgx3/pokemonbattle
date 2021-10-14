package pokemonBattle;
import java.util.*;

public class pokemonBattle {

	public static void main(String[] args) {
		String chosenPokemon = battleStart(); //places returned name into a variable to be called
		String stats = damage(chosenPokemon); //places returned statsBasic variable from damage method into a new variable to be called
		statsTable(stats, chosenPokemon); //statsVar and chosenPokemon called for printout of statsTable
	}
	public static String battleStart() {
		System.out.println("Another trainer is issuing a challenge!\n");
		Scanner input = new Scanner(System.in);
		String opponent = "Zebstrika";
		System.out.println(opponent + " appeared.\n");
		System.out.print("Which Pokemon do you choose? ");
		String chosenPokemon = input.next();
		System.out.println("\nYou chose " + chosenPokemon + "!\n");
		System.out.println("It's a Pokemon battle between " + chosenPokemon + " and " + opponent + "! Go!");
		return chosenPokemon; //returns the name of the Pokemon chosen for use in other methods
	}
	public static String damage(String chosenPokemon) {
		Scanner input = new Scanner(System.in);
		System.out.println("\nZebstrika used Thunderbolt!");
		System.out.print("\nTrainer, what are your " +  chosenPokemon + "'s stats?\n");
		System.out.print("Level: "); //User inputs for statistics
		double level = input.nextInt();
		System.out.print("Attack: ");
		double attack = input.nextInt();
		System.out.print("Defense: ");
		double defense = input.nextInt();
		System.out.print("Base: ");
		double base = input.nextInt();
		System.out.print("STAB: ");
		double stab = input.nextInt();
		System.out.print("HP: ");
		double hp = input.nextInt();
		double randomNumber = Math.random();
		randomNumber = randomNumber * 0.15 + 0.85; //ensures random number will be between 0.85 and 1.0
		double modifier = randomNumber * stab;
		double damage = (((2*level+10)/250)*(attack/defense)+2)*base*modifier; //damage calculation
		int intDamage = (int)damage; //makes damage an integer
		int newHp = (int)hp - intDamage;  //calculates new HP value after damage done
		newHp = Math.max(newHp, 0);
		String damageStatus = chosenPokemon + " sustained " + intDamage + " points damage. HP are now " + newHp + "."; //tells user damage done and HP level
		System.out.println(damageStatus); 
		String statsBasic = "\nLevel:\t"+(int)level+"\nAttack:\t"+(int)attack+"\nDefense:"+(int)defense+"\nBase:\t"+(int)base+"\nSTAB:\t"+(int)stab+"\nHP:\t"+(int)newHp; //creates a list of statistics
		return statsBasic; //returns for use in statsTable method
	}
	public static void statsTable(String statsBasic, String chosenPokemon) {
		String statsList = chosenPokemon + "'s stats:" + statsBasic;
		System.out.println("-------------------");
		System.out.println(statsList);
		System.out.println("-------------------");
	}

}
 