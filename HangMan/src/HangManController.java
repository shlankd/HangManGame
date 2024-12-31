import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class HangManController {
	
	// attributes
	private GuessWord word; // an instance of the GuessWord class
	private DrawHangMan d; // an instance of the DrawHangMan class
	private int counterMissedLetters; // counter of the input letter that missed the word

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    
    // button instance for every letter
    @FXML
    private Button aButton, bButton, cButton, dButton, eButton, fButton, gButton, hButton, iButton, jButton, kButton, lButton, mButton,
    			   nButton, oButton, pButton, qButton, rButton, sButton, tButton, uButton, vButton, wButton, xButton, yButton, zButton;
        
    @FXML
    private Text textOne; // text to message the user

    @FXML
    private Text wordText; // display the word to guess as blanks

    @FXML
    private Text textTwo; // text to message the user
    
    
	// this method draws parts of the Hang-Man according to the number of times that the user missed the letter of the word
	void missedLetterWord() {
		switch (counterMissedLetters) {

		case (1):
			d.drawFirstHand();
			break;

		case (2):
			d.drawSecondHand();
			break;

		case (3):
			d.drawFirstLeg();
			break;

		case (4):
			d.drawSecondLeg();
			break;

		case (5):
			d.drawBody();
			break;

		case (6):
			d.drawHead();
			textTwo.setText("You lost the game"); // message for the user that lost
			textOne.setText("For restart the game press the restart button"); // message to inform the user the restart button			break;

		default:
			break;

		}
	}
    
    
    // this method responds to the input letter of the user according to the Hang-Man rules  
    void pressedChar(char c) {
    	
    	if(word.isInputLetterExist(c)) { // condition id the input letter exist in the word
    		word.setLetter(c); // sets the letter of the button
    		wordText.setText(word.getBlankGuessWord()); // represents the update blankWord
    		if(word.isSuccessfullyGuessed()) { // if the user succeed to guess the word 
    	    	textTwo.setText("You won the game!!!"); // message for the user that won 
    	    	textOne.setText("For restart the game press the restart button"); // message to inform the user the restart button
    		}
    	}
    	
    	else {
    		counterMissedLetters++; // increment counterMistakes by 1
    		missedLetterWord(); // operates missedLetterWord() method to draw a part of the Hang-Man
    	}
    }
    
    // this method enable all letters buttons for replay the game
    void enableLettersButtons() {
    	aButton.setDisable(false);bButton.setDisable(false);cButton.setDisable(false);dButton.setDisable(false);eButton.setDisable(false);fButton.setDisable(false);
    	gButton.setDisable(false);hButton.setDisable(false);iButton.setDisable(false);jButton.setDisable(false);kButton.setDisable(false);lButton.setDisable(false);
    	mButton.setDisable(false);nButton.setDisable(false);oButton.setDisable(false);pButton.setDisable(false);qButton.setDisable(false);rButton.setDisable(false);
    	sButton.setDisable(false);tButton.setDisable(false);uButton.setDisable(false);vButton.setDisable(false);wButton.setDisable(false);xButton.setDisable(false);
    	yButton.setDisable(false);zButton.setDisable(false);
    }
    
    
    
    @FXML
    void restartPressed(ActionEvent event) {
    	word = new GuessWord(); // get a new word for replay the game
    	counterMissedLetters = 0; // reset the counter missed letters
    	d.clearCanvas(); // clear the canvas 
    	enableLettersButtons(); // enable all letters buttons for replay the game
    	textTwo.setText("");
    	textOne.setText("Guess the word: ");
    	wordText.setText(word.getBlankGuessWord()); // sets the new word on the text
    	d.drawHanger(); // redraw the hanger
    }
    
    // ******char pressed events*********
    
    // there is a button for every letter
    // after the user presses the button for input, the same button is disabled, so the user will know which letter he chose
    @FXML
    void aPressed(ActionEvent event) {
    	pressedChar('a');
    	aButton.setDisable(true);
    }
    
    @FXML
    void bPressed(ActionEvent event) {
    	pressedChar('b');
    	bButton.setDisable(true);
    }

    @FXML
    void cPressed(ActionEvent event) {
    	pressedChar('c');
    	cButton.setDisable(true);
    }

    @FXML
    void dPressed(ActionEvent event) {
    	pressedChar('d');
    	dButton.setDisable(true);
    }

    @FXML
    void ePressed(ActionEvent event) {
    	pressedChar('e');
    	eButton.setDisable(true);
    }

    @FXML
    void fPressed(ActionEvent event) {
    	pressedChar('f');
    	fButton.setDisable(true);
    }

    @FXML
    void gPressed(ActionEvent event) {
    	pressedChar('g');
    	gButton.setDisable(true);
    }

    @FXML
    void hPressed(ActionEvent event) {
    	pressedChar('h');
    	hButton.setDisable(true);
    }

    @FXML
    void iPressed(ActionEvent event) {
    	pressedChar('i');
    	iButton.setDisable(true);
    }

    @FXML
    void jPressed(ActionEvent event) {
    	pressedChar('j');
    	jButton.setDisable(true);
    }

    @FXML
    void kPressed(ActionEvent event) {
    	pressedChar('k');
    	kButton.setDisable(true);
    }

    @FXML
    void lPressed(ActionEvent event) {
    	pressedChar('l');
    	lButton.setDisable(true);
    }

    @FXML
    void mPressed(ActionEvent event) {
    	pressedChar('m');
    	mButton.setDisable(true);
    }

    @FXML
    void nPressed(ActionEvent event) {
    	pressedChar('n');
    	nButton.setDisable(true);
    }

    @FXML
    void oPressed(ActionEvent event) {
    	pressedChar('o');
    	oButton.setDisable(true);
    }

    @FXML
    void pPressed(ActionEvent event) {
    	pressedChar('p');
    	pButton.setDisable(true);
    }

    @FXML
    void qPressed(ActionEvent event) {
    	pressedChar('q');
    	qButton.setDisable(true);
    }

    @FXML
    void rPressed(ActionEvent event) {
    	pressedChar('r');
    	rButton.setDisable(true);
    }

    @FXML
    void sPressed(ActionEvent event) {
    	pressedChar('s');
    	sButton.setDisable(true);
    }

    @FXML
    void tPressed(ActionEvent event) {
    	pressedChar('t');
    	tButton.setDisable(true);
    }

    @FXML
    void uPressed(ActionEvent event) {
    	pressedChar('u');
    	uButton.setDisable(true);
    }

    @FXML
    void vPressed(ActionEvent event) {
    	pressedChar('v');
    	vButton.setDisable(true);
    }

    @FXML
    void wPressed(ActionEvent event) {
    	pressedChar('w');
    	wButton.setDisable(true);
    }

    @FXML
    void xPressed(ActionEvent event) {
    	pressedChar('x');
    	xButton.setDisable(true);
    }

    @FXML
    void yPressed(ActionEvent event) {
    	pressedChar('y');
    	yButton.setDisable(true);
    }

    @FXML
    void zPressed(ActionEvent event) {
    	pressedChar('z');
    	zButton.setDisable(true);
    }
    
    @FXML
    void initialize() {
        gc = canvas.getGraphicsContext2D();
        word = new GuessWord(); // an instance of GuessWord for the word to guess
        d = new DrawHangMan(gc, canvas.getWidth(), canvas.getHeight()); // an instance of DrawHangMan class for the drwing methods
        d.drawHanger(); // draw the hanger
        textOne.setFont(Font.font(16)); // sets the font size
        textTwo.setFont(Font.font(16));
        wordText.setFont(Font.font(16));
        textOne.setText("Guess the word: ");
        wordText.setText(word.getBlankGuessWord()); // sets the word to guess in blank at the wordText
        
        

        
    }
}
