// Muhammad Iqbal

import java.util.*;		// import library
class ZombieDice{
	public static void main(String[] args){ // main method

		Scanner sc = new Scanner(System.in);	// Declare variables
		Random r = new Random();
		int x = 0;
		int y = 0;
		int input = 0;
		int counter = 0;
		int currentplayer = 0;
		int numplayers = 0;
		int Brains = 0;
		int Shotgun = 0;
		int Footprint = 0;
		int redFootprint = 0;
		int greenFootprint = 0;
		int yellowFootprint = 0;

		int[] ThreeDices = new int[3]; 	// Create array of dice size
		String[] DiceColors = {"green", "green", "green", "green", "green", "green", "yellow", "yellow", "yellow", "yellow", "red", "red", "red"};
		String [] greenDice = {"Shotgun","Footprint","Footprint","Brain","Brain","Brain"};
		String [] redDice = {"Shotgun", "Shotgun", "Shotgun","Footprint","Footprint","Brain"};
		String [] yellowDice = {"Shotgun","Shotgun","Footprint","Footprint","Brain","Brain"};


		Welcome();	// Print welcome message

		System.out.print(" Enter number of players:");     // Take number of players
		numplayers = sc.nextInt();
		if(numplayers < 2){			// Set 2 players by default
			System.out.println(" Please enter more than "+numplayers+" players"+"\n"+" try again");
			System.exit(0);
		}
		int[] Score = new int[numplayers];	// Create arrays and populate with players
		String[] playername = new String[numplayers];

		while(counter < numplayers){		// Take player names
			x = counter + 1;
			System.out.print(" Enter player " + x + " name:");
			playername[counter] = sc.next();
			counter++;
		}
		 // Create main loop
		while(numplayers != 0){		// Player turn and print game menu
			System.out.println(" ");
			System.out.println(" *** Player " +playername[currentplayer]+"`s turn ***");
			System.out.println(" ");
			System.out.println(" ----------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" | Press(1) to Play/Continue | Press(2) to Stop & Score | Press(3) to see Scoreboard | Press(4) for Rules | Press(5) to Exit |");
			System.out.println(" ----------------------------------------------------------------------------------------------------------------------------");
			input = sc.nextInt();

			if(input == 5){
				ExitGame();	// Exit game
				break;
			}

			else if(input == 4){
				GameRules(); // Print Game rules
			}

			else if(input == 3){
				Scoreboard(numplayers,playername,Score);	// Display scores
			}

			else if(input == 2){	// Switch player and store brains.
				StopAndStore(currentplayer, numplayers, Brains ,Shotgun, Score, playername);
				currentplayer++;  // Move position of player in array
				Brains = 0;		// Reset brains & shotguns for new player
				Shotgun = 0;
				if(currentplayer == numplayers){ // Creates a loop for continues player switch
				currentplayer = 0;
				}
			}

			else if(input == 1){	// Play game
				Footprint = 0;	// Resets footprints for new dice roll
				counter = 0; // Resets counter
				Dice();  // Print dice
				while(counter < ThreeDices.length){ // Creates a loop to the size of array
					y = r.nextInt(13);	// Pick random colors
					System.out.println(" ");
					System.out.println(" ");
					System.out.print("          "+DiceColors[y]+ " -- ");	// Print color names.
				if(DiceColors[y] == "red"){
					y = r.nextInt(6);	// Pick dice symbols
					System.out.println(redDice[y]);     // Print red dice symbols.
					if(redDice[y] == "Brain"){
						Brains++;
						}
						else if(redDice[y] == "Shotgun"){
						Shotgun++;
						}
						else if(redDice[y] == "Footprint"){
						redFootprint++;
						Footprint++;
						}
						else{
						System.out.println(redDice[y]);
						}
					}

				else if(DiceColors[y] == "yellow"){
					y = r.nextInt(6);
					System.out.println(yellowDice[y]);  // Print yellow dice symbols.
					if(yellowDice[y] == "Brain"){
						Brains++;
						}
						else if(yellowDice[y] == "Shotgun"){
						Shotgun++;
						}
						else if(yellowDice[y] == "Footprint"){
						yellowFootprint++;
						Footprint++;
						}
						else{
							System.out.println(yellowDice[y]);
						}
					}

				else if(DiceColors[y] == "green"){
					y = r.nextInt(6);
					System.out.println(greenDice[y]);	// Print green dice symbols.
					if(greenDice[y] == "Brain"){
						Brains++;
						}
						else if(greenDice[y] == "Shotgun"){
						Shotgun++;
						}
						else if(greenDice[y] == "Footprint"){
						greenFootprint++;
						Footprint++;
						}
						else{
							System.out.println(greenDice[y]);
						}
					}

			if(greenFootprint > 0){		// Check if green footprint is true
				y = r.nextInt(6);		// Pick new random colors
				System.out.println("          green reroll -- " + greenDice[y]);  // Reroll greenDice
				greenFootprint--;  // Removes green footprint
					if(greenDice[y] == "Brain"){
						Brains++;
						}
						else if(greenDice[y] == "Shotgun"){
						Shotgun++;
						}
						else if(greenDice[y] == "Footprint"){
						Footprint++;
						}
						else{
							System.out.println(greenDice[y]);
						}
					}

			if(yellowFootprint > 0){ // Check if yellow footprint is true
				y = r.nextInt(6);
				System.out.println("          yellow reroll -- " + yellowDice[y]);  // Reroll yellowDice
				yellowFootprint--;
					if(yellowDice[y] == "Brain"){
						Brains++;
						}
						else if(yellowDice[y] == "Shotgun"){
						Shotgun++;
						}
						else if(yellowDice[y] == "Footprint"){
						Footprint++;
						}
						else{
							System.out.println(yellowDice[y]);
						}
					}

			if(redFootprint > 0){	// Check if red footprint is true
				y = r.nextInt(6);
				System.out.println("          red reroll -- " + redDice[y]);	// Reroll redDice
				redFootprint--;
					if(redDice[y] == "Brain"){
						Brains++;
						}
						else if(redDice[y] == "Footprint"){
						Footprint++;
						}
						else if(redDice[y] == "Shotgun"){
						Shotgun++;
						}
						else{
							System.out.println(redDice[y]);
						}
					}
				counter++;
				} // End of inner loop

				System.out.println(" ");		// Print results of dice roll
				System.out.println(" ");
				System.out.println(" Brains:" + Brains+ " -- Footprint:" + Footprint + " -- Shotgun:" + Shotgun);
				System.out.println(" ");

			}  // End of else-if condition

			if(Shotgun >= 3){		// Check if shotgun is true
				PlayerDie(Shotgun); // Show die message
				Score[currentplayer] = 0; // Reset player score
				Brains = 0;
				Shotgun = 0;
				currentplayer++;
				if(currentplayer == numplayers){
				currentplayer = 0;
				}
			}
			if(Score[currentplayer] > 12){	 // Check if winning score is true
				Winner(playername, currentplayer); // Print winning message
				}
		} // End of main loop
} // end of main method

						//  -----------------METHODS------------------
				// Show welcome message
			public static void Welcome(){
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("      #############                         #############	");
				System.out.println("    ##            *##                     ##############*##   ");
				System.out.println("   #               **#                   ################**#  ");
				System.out.println("  #       %% %%    ***#                 ########  #  ####***#  ");
				System.out.println(" #       %%%%%%%   ****#               ########       ###****#  ");
				System.out.println("#         %%%%%    *****#             ##########     ####*****#  ");
				System.out.println("#   ###     %     ###***#             ####   ##### #####   ***#  ");
				System.out.println("#  # ####       #### #**#             ###      #######      **#  ");
				System.out.println("#  #     #     #     #**#             ###   X   #####   X   **#  ");
				System.out.println("#   #####  # #  #####***#             ####     ## # ##     ***#  ");
				System.out.println("#         #   #  *******#             ########## ### ##*******#   ");
				System.out.println(" ### #           **# ###               ### ############**# ###  ");
				System.out.println("     # - - - - - - #                       ##-#-#-#-#-#-##  ");
				System.out.println("      | | | | | | |                         | | | | | | |  ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("   	   ____          _    _       ___  _");
				System.out.println("	  |_  /___ _ __ | |__(_)___  |   \\(_)__ ___");
				System.out.println("	   / // _ \\ '  \\| '_ \\ / -_) | |) | / _/ -_)");
				System.out.println("	  /___\\___/_|_|_|_.__/_\\___| |___/|_\\__\\___|");
				System.out.println(" ");
				System.out.println("	         Welcome to Zobmie Dice game");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" GAME RULES.. ");
				System.out.println(" The dice have three symbols: ");
				System.out.println(" ");
				System.out.println(" * Brain ");
				System.out.println(" - You ate your victim`s brain. ");
				System.out.println(" * Shotgun ");
				System.out.println(" - He fought back! ");
				System.out.println(" * Footprints ");
				System.out.println(" - Your victim escaped. ");
				System.out.println(" ");
				System.out.println(" If you rolled three Shotguns, your turn is over. Otherwise, you can choose to stop and ");
				System.out.println(" score, or continue. If you decide to stop, score 1 for each Brain you have, and end ");
				System.out.println(" your turn. It`s the next player`s turn. If you choose to keep going, you reroll the die, ");
				System.out.println(" but you must keep track of your brains and shotguns. If you are up to 3 Shotguns, ");
				System.out.println(" your turn is over and you score nothing. Otherwise, you can stop and score, or take ");
				System.out.println(" another roll..");
				System.out.println(" ");
			}
			// Game exit message
			public static void ExitGame(){
				System.out.println(" ");
				System.out.println("     __  __  __ __ ___    __   _   _  ___ ___ ");
				System.out.println("    / _]/  \\|  V  | __|  /__\\ | \\ / || __| _ \\");
				System.out.println("   | [/\\ /\\ | \\_/ | _|  | \\/ |`\\ V /'| _|| v /");
				System.out.println("    \\__/_||_|_| |_|___|  \\__/   \\_/  |___|_|_\\");
				System.out.println(" ");
				System.out.println(" 	      Thank you for playing");
				System.out.println(" ");
		}
			// Store brains and switch player function
		public static void StopAndStore(int currentplayer, int numplayers, int Brains,int Shotgun, int[]Score, String[]playername){
				Score[currentplayer] = Score[currentplayer] + Brains;
				System.out.println(" ");
				System.out.println(" Switching player..");
				System.out.println(" ");
				System.out.println(" '"+playername[currentplayer]+"'"+ " scored "+ Score[currentplayer]+ " Brain");
				System.out.println(" ");
				System.out.println(" Next player..");
		}
	         // Player die message
		public static void PlayerDie(int Shotgun){

				System.out.println(" 	       ...");
				System.out.println("              ;::::;");
				System.out.println("            ;::::; :;");
				System.out.println("          ;:::::'   :;");
				System.out.println("         ;:::::;     ;.");
				System.out.println("        ,:::::'       ;           OOO ");
				System.out.println("        ::::::;       ;          OOOOO ");
				System.out.println("        ;:::::;       ;         OOOOOOOO");
				System.out.println("       ,;::::::;     ;'         / OOOOOOO");
				System.out.println("     ;:::::::::`. ,,,;.        /  / DOOOOOO");
				System.out.println("   .';:::::::::::::::::;,     /  /     DOOOO");
				System.out.println("  ,::::::;::::::;;;;::::;,   /  /        DOOO");
				System.out.println(" ;`::::::`'::::::;;;::::: ,#/  /          DOOO");
				System.out.println(" :`:::::::`;::::::;;::: ;::#  /            DOOO");
				System.out.println(" ::`:::::::`;:::::::: ;::::# /              DOO");
				System.out.println(" `:`:::::::`;:::::: ;::::::#/               DOO");
				System.out.println("  :::`:::::::`;; ;:::::::::##                OO");
				System.out.println("  ::::`:::::::`;::::::::;:::#                OO");
				System.out.println("  `:::::`::::::::::::;'`:;::#                O");
				System.out.println("   `:::::`::::::::;' /  / `:#");
				System.out.println("    ::::::`:::::;'  /  /   `#");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" You are dead.. ");
				System.out.println(" You rolled "+Shotgun+" Shotguns, your turn is over and you score nothing");
				System.out.println(" ");
		}
			// Show scoreboard
		public static void Scoreboard(int numplayers, String[]playername, int[]Score){
				int counter = 0;
				System.out.println(" ");
				System.out.println(" *******Scoreboard******** ");
				System.out.println(" ");
				while(counter < numplayers){
				System.out.println("------------------------------ ");
				System.out.print("   "+playername[counter]+" total Brains:");
				System.out.println(" " +Score[counter]);
				System.out.println("------------------------------ ");
				counter++;
		}
	}
			// Show dice
		public static void Dice(){
				System.out.println(" Dice Rolling..");
				System.out.println(" ");
				System.out.println(" .........				");
				System.out.println("  :~, *   * ~,		");
				System.out.println("  : ~, *   * ~.		");
				System.out.println("  :  ~........~		");
				System.out.println("  : *:         :      ~'~,	");
				System.out.println("  :  :         :    ~' *  ~,  ");
				System.out.println("  ~* :    *    : ,~' *    * ~, ");
				System.out.println("   ~,:         :.~,*    *  ,~ : ");
				System.out.println("    ~:.........::  ~, *  ,~   : ");
				System.out.println("                : *  ~,,~  *  : ");
				System.out.println("                :* * * :  *   : ");
				System.out.println("                 ~, *  : *  ,~  ");
				System.out.println("	           ~,  :  ,~   ");
				System.out.println("                     ~,:,~   ");
		}
		     // Show winner message
		public static void Winner(String[]playername,int currentplayer){
				System.out.println("                             _        ");
				System.out.println("                     __ __ _(_)_ _  _ _  ___ _ _");
				System.out.println("                    \\ V  V / | ' \\| ' \\/ -_) '_|");
				System.out.println("                     \\_/\\_/|_|_||_|_||_\\___|_|  ");
				System.out.println("");
				System.out.println("                "+ playername[currentplayer] + " won the game, thanks for playing");
				System.exit(0);
		}
			 // Show game rules
		public static void GameRules(){
				System.out.println(" ");
				System.out.println(" GAME RULES.. ");
				System.out.println(" The dice have three symbols: ");
				System.out.println(" ");
				System.out.println(" * Brain ");
				System.out.println(" - You ate your victim`s brain. ");
				System.out.println(" * Shotgun ");
				System.out.println(" - He fought back! ");
				System.out.println(" * Footprints ");
				System.out.println(" - Your victim escaped. ");
				System.out.println(" ");
				System.out.println(" If you rolled three Shotguns, your turn is over. Otherwise, you can choose to stop and ");
				System.out.println(" score, or continue. If you decide to stop, score 1 for each Brain you have, and end ");
				System.out.println(" your turn. It`s the next player`s turn. If you choose to keep going, you reroll the die, ");
				System.out.println(" but you must keep track of your brains and shotguns. If you are up to 3 Shotguns, ");
				System.out.println(" your turn is over and you score nothing. Otherwise, you can stop and score, or take ");
				System.out.println(" another roll..");
				System.out.println(" ");
		}
} // End of program
