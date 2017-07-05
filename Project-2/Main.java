package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

//main method where all the GUI magic happens
public class Main extends Application {
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow()
	{
		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/application/MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
			
			Scene scene = new Scene(pane);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		MainWindowController.Init_Neural_net();
		launch(args);
	}
}
