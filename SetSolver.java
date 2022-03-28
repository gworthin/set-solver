package setSolver;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SetSolver {
	
	// main calls solveBoard with parameter set to true so the user inputs the 12 cards
	public static void main(String[] args) {
		solveBoard(true);
	}

	// solveBoard takes in the 12 cards and draws the possible sets
	public static int solveBoard(boolean inputMode) {
		Scanner reader = new Scanner(System.in);
		String cardCode = "";
		Card card;
		ArrayList<Card> board = new ArrayList<Card>();
			
		// Loops 12 times for 12 cards
		for(int i = 1; i <= 12; i++) {
			// Card code of length 4 has all the attributes
			while(cardCode.length() != 4) {
				// If there is user input
				if(inputMode) { 
					System.out.println("Enter in card #" + i);
					cardCode = reader.next();
				// If we are making a random board
				} else {
					cardCode = getRandomCard();
				}
				// Make sure the card isn't already in the board
				if(hasCard(board, new Card(cardCode))) {
					cardCode = "";
				}
			}
			// If it's a random board, print the card
			if(!inputMode) {
				System.out.println(cardCode);
			}
			// Create the card and add it to the board
			card = new Card(cardCode);
			board.add(card);
			cardCode = "";
		}
		
		Card firstCard; 
		Card secondCard;
		
		Number newNumber;
		Color newColor;
		Shading newShading;
		Shape newShape;
		Card newCard;
		
		ArrayList<Set> allSets = new ArrayList<Set>();
		
		// Loop through every card in the board
		for(int j = 0; j < board.size()-1; j++) {
			firstCard = board.get(j);
			// Loop through every subsequent card in the board
			for(int k = j+1; k < board.size(); k++) {
				secondCard = board.get(k);
					
				// Fact: If you have a pair of cards, there is exactly one card in the deck that will make the three of them a set. 
				 
				//Number
				if(firstCard.number == secondCard.number) {
					newNumber = firstCard.number; // If equal, the third card must also be equal
				} else {
					newNumber = getOtherNumber(firstCard.number, secondCard.number); // Else, the third card must have the missing attribute
				}
				
				//Color
				if(firstCard.color == secondCard.color) {
					newColor = firstCard.color; // If equal, the third card must also be equal
				} else {
					newColor = getOtherColor(firstCard.color, secondCard.color); // Else, the third card must have the missing attribute
				}
				
				//Shading
				if(firstCard.shading == secondCard.shading) {
					newShading = firstCard.shading; // If equal, the third card must also be equal
				} else {
					newShading = getOtherShading(firstCard.shading, secondCard.shading); // Else, the third card must have the missing attribute
				}
				
				//Shape
				if(firstCard.shape == secondCard.shape) {
					newShape = firstCard.shape; // If equal, the third card must also be equal
				} else {
					newShape = getOtherShape(firstCard.shape, secondCard.shape); // Else, the third card must have the missing attribute
				}
				
				// Create a new card with the new attributes
				newCard = new Card(newNumber, newColor, newShading, newShape);
								
				if(hasCard(board, newCard)) {
					Set setToAdd = new Set(firstCard, secondCard, newCard); // If the new card is in the board, create a set
					if(!hasSet(allSets, setToAdd)) {
						allSets.add(setToAdd); // If this set hasn't been found yet, add it to the set of all sets. 
					}
				}
				
			}
		}
		
		// Draw each set
		for(int m = 1; m <= allSets.size(); m++) {
			System.out.println("\033[37mSet #" + m + ": ");
			allSets.get(m-1).drawSet();
		}
		
		// If there are no sets, print no sets
		if(allSets.size() == 0) {
			System.out.println("\033[37mNo sets");
		}
		reader.close();
		return allSets.size();
	}
	
	// Returns a random card
	public static String getRandomCard() {
		// Create a Random object
		Random random = new Random();
		
		// Pick random attributes
		int pick = random.nextInt(3);
		Number newNumber = Number.values()[pick];
		pick = random.nextInt(3);
		Color newColor = Color.values()[pick];
		pick = random.nextInt(3);
		Shading newShading = Shading.values()[pick];
		pick = random.nextInt(3);
		Shape newShape = Shape.values()[pick];
		
		// Create a new card and return the card code
		Card newCard = new Card(newNumber, newColor, newShading, newShape);
		return newCard.toString();
	}

	// Checks if a set is in a set of sets
	public static boolean hasSet(ArrayList<Set> allSets, Set setToAdd) {
		for(int i = 0; i < allSets.size(); i++) {
			Set curSet = allSets.get(i);
			if(setToAdd.equals(curSet)) {
				return true;
			}
		}
		return false;
	}

	// Checks if a card is in an array of cards
	public static boolean hasCard(ArrayList<Card> board, Card newCard) {
		for(int i = 0; i < board.size(); i++) {
			Card curCard = board.get(i);
			if(newCard.equals(curCard)) {
				return true;
			}
		}
		return false;
	}

	// Assumes e1 and e2 are different numbers and returns the remaining number
	public static Number getOtherNumber(Number e1, Number e2) {
		if(e1 == Number.ONE && e2 == Number.TWO || e2 == Number.ONE && e1 == Number.TWO) {
			return Number.THREE;
		} else if(e1 == Number.ONE && e2 == Number.THREE || e2 == Number.ONE && e1 == Number.THREE) {
			return Number.TWO;
		} else {
			return Number.ONE;
		}
	}
	
	// Assumes e1 and e2 are different colors and returns the remaining color
	public static Color getOtherColor(Color e1, Color e2) {
		if(e1 == Color.RED && e2 == Color.GREEN || e2 == Color.RED && e1 == Color.GREEN) {
			return Color.PURPLE;
		} else if(e1 == Color.RED && e2 == Color.PURPLE || e2 == Color.RED && e1 == Color.PURPLE) {
			return Color.GREEN;
		} else {
			return Color.RED;
		}
	}
	
	// Assumes e1 and e2 are different shadings and returns the remaining shading
	public static Shading getOtherShading(Shading e1, Shading e2) {
		if(e1 == Shading.FULL && e2 == Shading.STRIPED || e2 == Shading.FULL && e1 == Shading.STRIPED) {
			return Shading.EMPTY;
		} else if(e1 == Shading.FULL && e2 == Shading.EMPTY || e2 == Shading.FULL && e1 == Shading.EMPTY) {
			return Shading.STRIPED;
		} else {
			return Shading.FULL;
		}
	}
	
	// Assumes e1 and e2 are different shapes and returns the remaining shape
	public static Shape getOtherShape(Shape e1, Shape e2) {
		if(e1 == Shape.DIAMOND && e2 == Shape.SQUIGGLE || e2 == Shape.DIAMOND && e1 == Shape.SQUIGGLE) {
			return Shape.OVAL;
		} else if(e1 == Shape.DIAMOND && e2 == Shape.OVAL || e2 == Shape.DIAMOND && e1 == Shape.OVAL) {
			return Shape.SQUIGGLE;
		} else {
			return Shape.DIAMOND;
		}
	}
}
