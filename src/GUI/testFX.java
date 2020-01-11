package GUI;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nodes.AbstractTreeNode;
import nodes.Context;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import com.parser.*;

@SuppressWarnings("restriction")
public class testFX extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception{
		GuiBase item = new GuiBase();
		final TextInputControlStream stream = new TextInputControlStream(item.textArea0, Charset.defaultCharset());
		final PrintStream out = new PrintStream(stream.getOut(), true);
		final InputStream in = stream.getIn();
		@SuppressWarnings("unused")
		Parser parser = new Parser(System.in);
		
		System.setOut(out);
		System.setIn(in);
		//System.setErr(out);
		
		
				
		Thread thread[] = new Thread[2] ;
		thread[0] = new Thread();
		item.button.setOnAction(e ->{ // Run Button
			thread[0] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					InputStream is = new ByteArrayInputStream( item.getText().getBytes());
					try {
						if (is.available() != 0) {
							item.textArea0.clear();
							Parser.ReInit(is);
							AbstractTreeNode node;
							try {
								node = Parser.start();
								node.execute(new Context());
							} 
							catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread[0].start();
		});
		item.button0.setOnAction(e ->{
			InputStream is = new ByteArrayInputStream( item.getText().getBytes());
			try {
				if (is.available() != 0) {
					item.textArea0.clear();
					Parser.ReInit(is);
					AbstractTreeNode node;
					try {
						node = Parser.start();
						System.out.print(node.convert(new Context()));
					} 
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}catch(IOException e1) {
				e1.printStackTrace();
			}
		}); //Stop Button
		StackPane pane = new StackPane(item);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// IMPORTANT: Save the old System.out!
	final PrintStream old = System.out;
	static ByteArrayOutputStream baos;
	public static void main(String args[]) {
		launch(args);
	}

}
