import java.io.*;
import java.util.*;

// this class contains words for Hang-Man game
public class WordBank {
	
	// attributes
	private ArrayList<String> wordBank; // contains words for the game "Hang-Man"
	
	// constructor
	public WordBank() {
		wordBank = new ArrayList<String>();
		getWordsFromTxtFile();
	}
	
	// this method returns wordBank
	public ArrayList<String> getWordBank(){
		return wordBank;
	}
	
	// this method returns a random word from the wordBank
	public String getRandomWord() {
		double randomNumber = Math.random()*wordBank.size(); // generate a random number
		int randomIndex = (int) randomNumber; // the value of randomIndex is floor-rounded so that it does not be out of bounds in wordBank
		return wordBank.get(randomIndex);
	}
	
	// this method gets words from text file to the string array wordBank for the Hang-Man game
	private void getWordsFromTxtFile() {
		String str; // the string variable to input the word from the text file to the string array list wordBank
		BufferedReader in = null;
		File textFile = null;
		String filePath = "C:\\Users\\Dor Shlank\\eclipse-workspace\\HangMan\\words for hang-man.txt"; // the address path of the text file
		
		try {
			
			textFile = new File(filePath); // every line in the text file contains one word
		 // textFile contains the words: Apple 
							    //		 Orange 
							   //		 Tomato 
							  //	     Potato 
							 //		     Cucumber 
							//			 Eggplant
		
		}catch(NullPointerException e){System.out.println("the filePath argument is null");}
		
		try {
			
			in = new BufferedReader(new FileReader(textFile)); // the BufferedReader object that reads text from a file
			
		}catch(FileNotFoundException e) {System.out.println("could not find or open the file");}
		
		try {
			
			str = in.readLine(); // the first word from the text file
			
			while(str != null) { // when there is empty line from the text file it indicates the end of the text file
				if(str.contains(" ")){str = str.replace(" ","");} // condition on the word not having an empty space
				wordBank.add(str); // puts the word to string array list wordBank
				str = in.readLine(); // read the word from the text file 
			}
			in.close(); // close the input stream
			
		}catch(IOException e) {System.out.println("the exception type IOException had occurred");e.printStackTrace();}
	}
	
	
	
}
