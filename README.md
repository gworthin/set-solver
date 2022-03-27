# set-solver

Java Program that solves the card game [Set](https://en.wikipedia.org/wiki/Set_(card_game)). It takes in the 12 cards on the board as input and outputs all possible sets. 

There are 81 cards in a deck of Set cards, each with 3 possible permutations of 4 attributes. A Set is a group of 3 cards with specific relationships to the others based on their attributes. Read more [here](https://en.wikipedia.org/wiki/Set_(card_game)).

The cards are inputted as a **card code**, a 4 letter string representing the number, color, shading, and shape, respectively. 

**Number**
 - 1 - One
 - 2 - Two
 - 3 - Three

**Color**
 - R - Red
 - G - Green
 - P - Purple

**Shading**
 - E - Empty
 - S - Striped
 - F - Full

**Shape**
- O - Oval
- D - Diamond
- S - Squiggle

The codes for the three cards in this image would be 1GED, 2PSS, and 3RFO, from left to right
![](https://upload.wikimedia.org/wikipedia/commons/8/8f/Set-game-cards.png)

Cards are "drawn" on in the terminal. The set above would be printed as such (in the appropiate colors):
    0      
   0 0     
  0   0    
 0     0   
  0   0    
   0 0     
    0    
    
   000        000     
  0   0      0   0    
   00000      00000   
  0   0      0   0    
 00000      00000     
  0   0      0   0    
   000        000     

   000        000        000     
  00000      00000      00000    
  00000      00000      00000    
  00000      00000      00000    
  00000      00000      00000    
  00000      00000      00000    
   000        000        000     

