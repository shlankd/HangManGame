import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Text;

public class Game {
	
	// attributes
	private int counterMissedLetters; // counter of the input letter that missed the word
	private DrawHangMan d; // the draw of hang man instance
	private GuessWord word; // the guess word instance
	private Text text; // the display text (for the guess word) instance
	private boolean resetButton; // a boolean variable that enables the letter buttons for replay the Hang-Man game
	
	// constructor
	Game(DrawHangMan drawClass, Text t){
		d = drawClass;
		text = t;
		word = new GuessWord();
		resetButton = false;
	}	
	
	public boolean getDisableButton() {
		return resetButton;
	}
	
	public void setDisableButton(boolean b) {
		resetButton = b;
	}
	
    // this method draws parts of the Hang-Man according to the number of times that the user missed the letter of the word 
    void missedLetterWord() {
    	switch(counterMissedLetters){
    	
    	case(1):
    		d.drawFirstHand();
    	break;
    	
    	case(2):
    		d.drawSecondHand();
    	break;
    	
    	case(3):
    		d.drawFirstLeg();
    	break;
    	
    	case(4):
    		d.drawSecondLeg();
    	break;
    	
    	case(5):
    		d.drawBody();
    	break;
    	
    	case(6):
    		d.drawHead();
    	break;
    	
    	default:
    		break;
    	
    	}
    }
    
    public void resetGame() {
    	word = new GuessWord();
    	resetButton = false;
    }
    
    // this method responds to the input letter of the user according to the Hang-Man rules  
    void pressedChar(char c) {
    	
    	if(word.isInputLetterExist(c)) { // condition id the input letter exist in the word
    		word.setLetter(c); // sets the input letter in the blankWord
    		text.setText(word.getBlankGuessWord()); // represents the update blankWord
    		if(word.isSuccessfullyGuessed()) { // if the user succeed to guess the word 
    			//endGame()
    		}
    	}
    	
    	else {
    		counterMissedLetters++; // increment counterMistakes by 1
    		missedLetterWord(); // operates missedLetterWord() method to draw a part of the Hang-Man
    		if(counterMissedLetters == 6) {
    			//endGame()
    		}
    	}
    }
	
}
