/***************************************
RockPaperScissors.java
Author: David Brungardt

This program handles the logic for the game
of rock-paper-scissors we will be playing in
Operation5. The program takes input from the user,
then the computer randomly selects "Rock", "Paper", or "Scissors".
The counter for the winner is incremented by 1 each round.
*****************************************/

import javax.swing.JOptionPane;
import java.util.Random;

public class RockPaperScissors
{
  // Enumeration for Rock-Paper-Scissors game.
  enum GameInput
  {
    ROCK, PAPER, SCISSORS;
  }

  // declare and initialize variables
  GameInput userInput; // User input.
  GameInput computerInput; // Computer input.
  int userCounter = 0; // Counter for user's score.
  int computerCounter = 0; // Counter for computer's score.
  int computerInt; // Integer used for random number generator.
  public int Counter = 1; // Counter to terminate game loop.

  // Empty consructor for RockPaperScissors class.
  RockPaperScissors()
  {

  } // End of constructor.

  public void GamePlay(String userInput)
  {
    // New instance of random class.
    Random computerPlayer = new Random();

    // Assign random integer for computer selection.
    computerInt = computerPlayer.nextInt(3) + 1;

    // Simulate computers input with random number between 1 and 3.
    if(computerInt == 1)
    {
      // If random number is 1, computer chooses rock.
      this.computerInput = GameInput.ROCK;
      JOptionPane.showMessageDialog(null, "The computer has chosen \"Rock\"");
    }
    else if (computerInt == 2)
    {
      // If random number is 2, computer chooses paper.
      this.computerInput = GameInput.PAPER;
      JOptionPane.showMessageDialog(null, "The computer has chosen \"Paper\"");
    }
    else if (computerInt == 3)
    {
      // If random number is 3, computer chooses scissors.
      this.computerInput = GameInput.SCISSORS;
      JOptionPane.showMessageDialog(null, "The computer has chosen \"Scissors\"");
    }

    // Determine user input
    if(userInput.equalsIgnoreCase("rock"))
    {
      // If user chooses "rock" set enumeration to ROCK
      this.userInput = GameInput.ROCK;
    }
    else if (userInput.equalsIgnoreCase("paper"))
    {
      // If user chooses "paper" set enumeration to PAPER
      this.userInput = GameInput.PAPER;
    }
    else if (userInput.equalsIgnoreCase("scissors"))
    {
      // If user chooses "scissors" set enumeration to SCISSORS
      this.userInput = GameInput.SCISSORS;
    }

    // Compare computer user input to computer input and play rock-paper-scissors.
    switch (this.userInput)
    {
      // If user selects "Rock"
      case ROCK:
      if (this.computerInput == GameInput.ROCK)
      {
        // If computer selects Rock.
        JOptionPane.showMessageDialog(null, "No clear winner.");
        break;
      }
      else if (this.computerInput == GameInput.PAPER)
      {
        // If computer selects Paper.
        JOptionPane.showMessageDialog(null, "You lose, paper beats rock!");
        computerCounter++;
        Counter++;
        break;
      }
      else if(this.computerInput == GameInput.SCISSORS)
      {
        // If computer selects Scissors.
        JOptionPane.showMessageDialog(null, "You win, rock beats scissors!!!");
        userCounter++;
        Counter++;
        break;
      }
      // If user selects "Paper"
      case PAPER:
      if (this.computerInput == GameInput.ROCK)
      {
        // If computer selects Rock.
        JOptionPane.showMessageDialog(null, "You win, paper beats rock!!!");
        userCounter++;
        Counter++;
        break;
      }
      else if (this.computerInput == GameInput.PAPER)
      {
        // If computer selects Paper.
        JOptionPane.showMessageDialog(null, "No clear winner.");
        break;
      }
      else if(this.computerInput == GameInput.SCISSORS)
      {
        // If computer selects Scissors.
        JOptionPane.showMessageDialog(null, "You lose, scissors beat paper!");
        computerCounter++;
        Counter++;
        break;
      }
      // If user selects "Scissors".
      case SCISSORS:
      if (this.computerInput == GameInput.ROCK)
      {
        // If computer selects Rock.
        JOptionPane.showMessageDialog(null, "You lose, rock beats scissors!");
        computerCounter++;
        Counter++;
        break;
      }
      else if (this.computerInput == GameInput.PAPER)
      {
        // If computer selects Paper.
        JOptionPane.showMessageDialog(null, "You win, scissors beats paper!!!");
        userCounter++;
        Counter++;
        break;
      }
      else if(this.computerInput == GameInput.SCISSORS)
      {
        // If computer selects Scissors.
        JOptionPane.showMessageDialog(null, "No clear winner.");
        break;
      }

    } // End of switch statement

  } // End of GamePlay method

  public void DisplayWinner()
  {
    // If user wins.
    if (userCounter > computerCounter)
    {
      JOptionPane.showMessageDialog(null, "Congratulations!!! You win!!!\nUser: " + userCounter + "\nComputer: " + computerCounter);
    }
    // If user loses.
    else if (userCounter < computerCounter)
    {
      JOptionPane.showMessageDialog(null, "Better luck next time.\nUser: " + userCounter + "\nComputer: " + computerCounter);
    }

  } // End of DisplayWinner method.

} // End of RockPaperScissors class
