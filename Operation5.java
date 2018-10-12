/***************************************
Operation5.java
Author: David Brungardt

This program simulates a game of rock-paper-scissors.
The program asks the user how many games they would like to
play (must be an odd number so there is a clear winner).
The player is then asked to choose between rock, paper, and scissors.
The computer will guess also choose between rock, paper, and scissors at random.
The program then displays the winner of each round, and eventually the game.
*****************************************/

import javax.swing.JOptionPane;

public class Operation5
{
  public static void main(String[] args)
  {
    // Declare and initialize variables.
    String userChoice; // User's choice between rock paper and scissors.
    int gameQty; // Number of games.
    int counter = 0; // Counter for loop.
    boolean isOdd = false; // boolean used to terminate loop for number of games.
    boolean isCorrect = false; // boolean used to terminate loop for user's guess

    // Instantiate new RockPaperScissors class.
    RockPaperScissors currentGame = new RockPaperScissors();

    do {

      // Introduce user to game.
      gameQty = Integer.parseInt(JOptionPane.showInputDialog("Welcome to Rock, Paper, Scissors!" + "\nPlease enter the number of rounds you would like to play: "));

      if (gameQty % 2 != 0)
      {
        // Set boolean to "true" to terminate the loop
        isOdd = true;

        do
        {
          // Prompt user to enter rock, paper, or scissors.
          userChoice = JOptionPane.showInputDialog("Rock, Paper, or Scissors?: ");

          // If user enters "Spock".
          if (userChoice.equalsIgnoreCase("spock"))
          {
            JOptionPane.showMessageDialog(null, "Spock is the ultimate, but maintains an unfair advantage and is, therefore, not allowed.");
              // Set boolean to false to continue the loop.
            isCorrect = false;
          }
          // If user enters 'rock', 'paper', or 'scissors'.
          else if(userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper") || userChoice.equalsIgnoreCase("scissors"))
          {
            if (counter >= gameQty)
            {
              // Set boolean to true to terminate the loop.
              isCorrect = true;
            }

            // Pass user's choice into GamePlay method.
            currentGame.GamePlay(userChoice);

            /*Assign value of counter in currentGame to counter in main method so
            currentGame class can check to see that there was a clear winner before
            incrementing the counter. This way we can be certain there isn't a tie.*/
            counter = currentGame.Counter;

          }
          // If user entry is invalid.
          else
          {
            JOptionPane.showMessageDialog(null, "\"" + userChoice + "\" is not a valid entry.");
            // Set boolean to false to continue the loop.
            isCorrect = false;
          }

        } while (isCorrect == false); // Continue to ask user for "Rock", "Paper", and "Scissors" until user enters a valid entry.

      }
      else
      {
        // Display error message and prompt user to enter another number.
        JOptionPane.showMessageDialog(null, "Sorry you must enter an odd number, please try again.");
      }

    } while (isOdd == false); // Continue to ask until user's number is odd.

    // When game is over, display winner and scores.
    currentGame.DisplayWinner();

  } // End of main method

} // End of Operation5 class
