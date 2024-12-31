
// this class creates the word to guess in the game Hang-Man 
public class GuessWord extends WordBank {
	// attributes
	private String guessWord; // the word that the user needs to guess
	private String blankGuessWord; // represent the word to the user with blanks instead of letters   
	
	//constructor
	public GuessWord() {
		guessWord = this.getRandomWord(); // the assignment of guessWord is done by the getRandomWord() method
		generateBlankGuessWord(); 		
	}
		
	//getters
	
	public String getGuessWord() {
		return guessWord;
	}
	
	public String getBlankGuessWord() {
		return blankGuessWord;
	}
	
	// this method generates the blank guess word
	private void generateBlankGuessWord() {
		blankGuessWord = "";
		for(int i=0; i<guessWord.length(); i++) { 
			if(i == guessWord.length()-1) { 
				blankGuessWord = blankGuessWord + "_"; // add blank without space for the last letter of the guess word 
			}
			else {
				blankGuessWord = blankGuessWord + "_ "; // add blank and space for every letter in the guess word
			}
		}
	}
	
	// this method returns true if the user's input letter exist in the guess word otherwise returns false
	public boolean isInputLetterExist(char inputLetter) {
		for(int i=0; i<guessWord.length(); i++) {
			if(guessWord.charAt(i) == Character.toLowerCase(inputLetter) || guessWord.charAt(i) == Character.toUpperCase(inputLetter)) {
				return true;
			}
		}
		return false;
	}
	
	// this method returns true if the user succeeded to guess the word otherwise return false
	public boolean isSuccessfullyGuessed() {
		return (blankGuessWord.replace(" ","").equals(guessWord));
	}
	
	// this method sets the input char into the right position in blankWord 
	public void setLetter(char inputLetter) { 
        for(int i=0; i<blankGuessWord.length(); i=i+2) { //the loop is going through the blanks, which are located only in even indices 

            if(i==0) {inputLetter = Character.toUpperCase(inputLetter);} // condition for the input letter to be upper case letter when i points at the first letter.

            else {inputLetter = Character.toLowerCase(inputLetter);} // condition for the input letter to be lower case letter.

            if(guessWord.charAt(i/2) ==  Character.toLowerCase(inputLetter) || guessWord.charAt(i/2) ==  Character.toUpperCase(inputLetter)) { // condition for the correct input letter. guessWord.charAt(i/2) == blankGuessWord(i) when i is even number
                // replacement blank into the correct letter
                if(i == blankGuessWord.length()-1) { //condition for the last char at the string blank 
                	blankGuessWord = blankGuessWord.substring(0,i) + inputLetter;
                }
                else {
                	blankGuessWord = blankGuessWord.substring(0,i) + inputLetter + blankGuessWord.substring(i+1);
                }
            }
        }
    }
	
}
