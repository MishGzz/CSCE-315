package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

public class MainWindowController {

	private Main main;
	private final static double[] grid = new double[35];
	private static double[] answer = new double[26];
	private static int bestLetter;
	private static char letter;
	private static Neural_net net;
	@FXML
	private TextArea console;
	private PrintStream ps;
	
	public class Console extends OutputStream{
		private TextArea console;
		
		public Console(TextArea console)
		{
			this.console = console;
		}
		public void appendText(String valueOf)
		{
			Platform.runLater(() -> console.appendText(valueOf));
		}
		public void write(int b) throws IOException{
			appendText(String.valueOf((char)b));
		}
	}
	
	public void setMain(Main main)
	{
		this.main = main;
	}
	public void handleButton(ActionEvent e)
	{
		ToggleButton button = (ToggleButton) e.getSource();
		int x = (int)(button.getLayoutX() - 60)/56;
		int y = (int)(button.getLayoutY() - 14)/56;
		
		if(button.isSelected())
		{
			button.getStyleClass().add("pressed");
			grid[y*5+x] = 1.0f;
		}
		else{
			button.getStyleClass().remove("pressed");
			grid[y*5+x] = 0;
		}
		processLetter();
	}
	
	public static void Init_Neural_net() throws FileNotFoundException{
//		int test_inputs = 35;
//		int test_outputs = 26;
//		int test_num_layers = 3;
//		int test_hidden_length = 30;
//		net = new Neural_net(test_inputs, test_outputs, test_num_layers, test_hidden_length);
		net = new Neural_net();
		net.load_net("save");
	}
	
	public void processLetter()
	{
		answer = net.feed_forward(grid);
		bestLetter = net.max(answer);
		letter = (char) (bestLetter+65);
		
		//System.out.println("Sees letter " + letter);
		console.setText("Sees letter " + letter);
		
	}
}
