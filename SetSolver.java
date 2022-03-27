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
			
		for(int i = 1; i <= 12; i++) {
			while(cardCode.length() != 4) {
				if(inputMode) {
					System.out.println("Enter in card #" + i);
					cardCode = reader.next();
				} else {
					cardCode = getRandomCard();
				}
				if(hasCard(board, new Card(cardCode))) {
					cardCode = "";
				}
			}
			if(!inputMode) {
				System.out.println(cardCode);
			}
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
		
		for(int j = 0; j < board.size()-1; j++) {
			firstCard = board.get(j);
			for(int k = j+1; k < board.size(); k++) {
				secondCard = board.get(k);
								
				//Number
				if(firstCard.number == secondCard.number) {
					newNumber = firstCard.number;
				} else {
					newNumber = getOtherNumber(firstCard.number, secondCard.number);
				}
				
				//Color
				if(firstCard.color == secondCard.color) {
					newColor = firstCard.color;
				} else {
					newColor = getOtherColor(firstCard.color, secondCard.color);
				}
				
				//Shading
				if(firstCard.shading == secondCard.shading) {
					newShading = firstCard.shading;
				} else {
					newShading = getOtherShading(firstCard.shading, secondCard.shading);
				}
				
				//Shape
				if(firstCard.shape == secondCard.shape) {
					newShape = firstCard.shape;
				} else {
					newShape = getOtherShape(firstCard.shape, secondCard.shape);
				}
				
				newCard = new Card(newNumber, newColor, newShading, newShape);
								
				if(hasCard(board, newCard)) {
					Set setToAdd = new Set(firstCard, secondCard, newCard);
					if(!hasSet(allSets, setToAdd)) {
						allSets.add(setToAdd);
					}
				}
				
			}
		}
		
		for(int m = 1; m <= allSets.size(); m++) {
			System.out.println("\033[37mSet #" + m + ": ");
			allSets.get(m-1).drawSet();
		}
		
		if(allSets.size() == 0) {
			System.out.println("\033[37mNo sets");
		}
		
		reader.close();
		
		return allSets.size();
	}
	
	
	public static String getRandomCard() {
		Random random = new Random();
		int pick = random.nextInt(3);
		Number newNumber = Number.values()[pick];
		
		pick = random.nextInt(3);
		Color newColor = Color.values()[pick];
		
		pick = random.nextInt(3);
		Shading newShading = Shading.values()[pick];
		
		pick = random.nextInt(3);
		Shape newShape = Shape.values()[pick];
		
		Card newCard = new Card(newNumber, newColor, newShading, newShape);
		return newCard.toString();
	}


	public static boolean hasSet(ArrayList<Set> allSets, Set setToAdd) {
		for(int i = 0; i < allSets.size(); i++) {
			Set curSet = allSets.get(i);
			if(setToAdd.equals(curSet)) {
				return true;
			}
		}
		return false;
	}


	public static boolean hasCard(ArrayList<Card> board, Card newCard) {
		for(int i = 0; i < board.size(); i++) {
			Card curCard = board.get(i);
			if(newCard.equals(curCard)) {
				return true;
			}
		}
		return false;
	}


	public static Number getOtherNumber(Number e1, Number e2) {
		if(e1 == Number.ONE && e2 == Number.TWO || e2 == Number.ONE && e1 == Number.TWO) {
			return Number.THREE;
		} else if(e1 == Number.ONE && e2 == Number.THREE || e2 == Number.ONE && e1 == Number.THREE) {
			return Number.TWO;
		} else {
			return Number.ONE;
		}
	}
	
	public static Color getOtherColor(Color e1, Color e2) {
		if(e1 == Color.RED && e2 == Color.GREEN || e2 == Color.RED && e1 == Color.GREEN) {
			return Color.PURPLE;
		} else if(e1 == Color.RED && e2 == Color.PURPLE || e2 == Color.RED && e1 == Color.PURPLE) {
			return Color.GREEN;
		} else {
			return Color.RED;
		}
	}
	
	public static Shading getOtherShading(Shading e1, Shading e2) {
		if(e1 == Shading.FULL && e2 == Shading.STRIPED || e2 == Shading.FULL && e1 == Shading.STRIPED) {
			return Shading.EMPTY;
		} else if(e1 == Shading.FULL && e2 == Shading.EMPTY || e2 == Shading.FULL && e1 == Shading.EMPTY) {
			return Shading.STRIPED;
		} else {
			return Shading.FULL;
		}
	}
	
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
