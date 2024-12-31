import javafx.scene.canvas.GraphicsContext;

// this class contains draw methods for the Hang-Man game
public class DrawHangMan {
	
	// attributes
	private GraphicsContext gc; // an instance of GraphicsContext class 
	private double width; // the width of the canvas
	private double height; // the height of the canvas
	
	// constructor
	DrawHangMan(GraphicsContext graphicsContext, double widthOfTheCanvas, double heightOfTheCanvas){
		gc = graphicsContext;
		width = widthOfTheCanvas;
		height = heightOfTheCanvas;
	}
	
	// this method draws the hanger for the Hang-Man
    void drawHanger(){
    	gc.strokeLine(width*0.5, height*0.9, width*0.9, height*0.9); // the base of the hanger
    	gc.strokeLine(width*0.8, height*0.2, width*0.8, height*0.9); // the pole of the hanger
    	gc.strokeLine(width*0.5, height*0.2, width*0.8, height*0.2); // the ceiling of the hanger
    	gc.strokeLine(width*0.5, height*0.2, width*0.5, height*0.3); // the rope of the hanger
    	gc.strokeLine(width*0.7, height*0.2, width*0.8, height*0.3); // support rod for stability 
    }
	
    // this method draws the head of the Hang-Man
    void drawHead(){
    	gc.strokeOval(width*0.45, height*0.3, width*0.1, height*0.1); // the head
    }
    
    // this method draws the body of the Hang-Man
    void drawBody() {
    	gc.strokeLine(width*0.5, height*0.4, width*0.5, height*0.6); // the body
    }
    
    // this method draws the first hand of the Hang-Man
    void drawFirstHand(){
    	gc.strokeLine(width*0.5, height*0.5, width*0.4, height*0.52); // the first hand 
    }
    
    // this method draws the second hand of the Hang-Man
    void drawSecondHand(){
    	gc.strokeLine(width*0.5, height*0.5, width*0.6, height*0.52); // the second hand 
    }
    
    // this method draws the first leg of the Hang-Man
    void drawFirstLeg(){
    	gc.strokeLine(width*0.5, height*0.6, width*0.425, height*0.75); // the first leg
    }
    
    // this method draws the second leg of the Hang-Man
    void drawSecondLeg(){
    	gc.strokeLine(width*0.5, height*0.6, width*0.575, height*0.75); // the second leg
    }
    
    // this method clears the canvas for restart the game
    void clearCanvas() {
    	gc.clearRect(0, 0, width, height);
    }
}
