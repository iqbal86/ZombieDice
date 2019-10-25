# ZombieDice
Game design:

 -Declare variables
 
 .create arrays
 .method for welcome message
 .take user input as number of players
 .if players are less than 2 print false

-Create integer and string arrays, populate them with number of players.

-Create loop to the size of number of players, take user names, move counter to next position.

-For main game, create loop that runs til players reaches to zero, array prints the first string index and asks user for name input.

-Menu displayed = method for game exit, method for game rules, method for scoreboard, method to store brains and switch player =
 it adds brains to the first index of integer array and prints first string index from string array, then moves on to the next position and resets
 brains and shotguns for new player.

-For main game, declare variables, creat loop that goes to the size of dice array, generate random colors, populate DiceColors array, check for color,
if true, generate random dice symbols and populate particular colored array, check for brains, shotguns and footprints if true, store their values,
else print the colored dice. check for colored footprint, if its true, generate random symbols and reprint particular colored dice. check if brain,
shotgun and footprint is true, store the values else print the default message. close the loop and print the stored values. counter moves to next position.
check if number of shotgun is true, then print the message in method, reset the first position in Score array, reset brains and shotgun, then move
on to the next position in Score array. if number of brains statement is true, print the message in method.
