package GUI;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

@SuppressWarnings("restriction")
public class GuiBase extends VBox {

   
	private final MenuBar menuBar;
    private final Menu menu;
    private final MenuItem menuItem;
    private final MenuItem menuItem0;
    private final Menu menu0;
    private final SeparatorMenuItem separatorMenuItem;
    private final MenuItem menuItem1;
    private final MenuItem menuItem2;
    private final MenuItem menuItem3;
    private final MenuItem menuItem4;
    private final SeparatorMenuItem separatorMenuItem0;
    private final MenuItem menuItem5;
    private final SeparatorMenuItem separatorMenuItem1;
    private final MenuItem menuItem6;
    private final Menu menu1;
    private final MenuItem menuItem7;
    private final MenuItem menuItem8;
    private final SeparatorMenuItem separatorMenuItem2;
    private final MenuItem menuItem9;
    private final MenuItem menuItem10;
    private final MenuItem menuItem11;
    private final MenuItem menuItem12;
    private final SeparatorMenuItem separatorMenuItem3;
    private final MenuItem menuItem13;
    private final MenuItem menuItem14;
    private final Menu menu2;
    private final MenuItem menuItem15;
    private final SplitPane splitPane;
    private final AnchorPane anchorPane;
    private final Label label;
    private final ScrollPane scrollPane;
    private final AnchorPane anchorPane0;
    private final Label label0;
    private final HBox hBox;
    public final JFXButton button;
    public final JFXButton button0;
    public final JFXTextArea textArea;
    private final AnchorPane anchorPane1;
    private final Label label1;
    public final JFXTextArea textArea0;

    public String getText() {
    	return this.textArea.getText();
    }
    public GuiBase() {

        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menu0 = new Menu();
        separatorMenuItem = new SeparatorMenuItem();
        menuItem1 = new MenuItem();
        menuItem2 = new MenuItem();
        menuItem3 = new MenuItem();
        menuItem4 = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        menuItem5 = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        menuItem6 = new MenuItem();
        menu1 = new Menu();
        menuItem7 = new MenuItem();
        menuItem8 = new MenuItem();
        separatorMenuItem2 = new SeparatorMenuItem();
        menuItem9 = new MenuItem();
        menuItem10 = new MenuItem();
        menuItem11 = new MenuItem();
        menuItem12 = new MenuItem();
        separatorMenuItem3 = new SeparatorMenuItem();
        menuItem13 = new MenuItem();
        menuItem14 = new MenuItem();
        menu2 = new Menu();
        menuItem15 = new MenuItem();
        splitPane = new SplitPane();
        anchorPane = new AnchorPane();
        label = new Label();
        scrollPane = new ScrollPane();
        anchorPane0 = new AnchorPane();
        label0 = new Label();
        hBox = new HBox();
        button = new JFXButton();
        button.setStyle("-fx-background-color:#4ee44e");
        button0 = new JFXButton();
        button0.setStyle("-fx-background-color:#ff726f");
        
        textArea = new JFXTextArea();
        textArea.setStyle("-fx-font-family: Consolas;-fx-font-size: 20pt;-fx-background-color:aliceblue");
        
        anchorPane1 = new AnchorPane();
        label1 = new Label();
        textArea0 = new JFXTextArea();
        textArea0.setStyle("-fx-font-family: Consolas;-fx-font-size: 20pt;-fx-background-color:#d2f8d2");
        

        setPrefHeight(1000.0);
        setPrefWidth(1800.0);
        

        VBox.setVgrow(menuBar, javafx.scene.layout.Priority.NEVER);
        menuBar.setPrefHeight(7.0);
        menuBar.setPrefWidth(892.0);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("New");

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Open�");

        menu0.setMnemonicParsing(false);
        menu0.setText("Open Recent");

        separatorMenuItem.setMnemonicParsing(false);

        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Close");

        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("Save");

        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("Save As�");

        menuItem4.setMnemonicParsing(false);
        menuItem4.setText("Revert");

        separatorMenuItem0.setMnemonicParsing(false);

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Preferences�");

        separatorMenuItem1.setMnemonicParsing(false);

        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Quit");

        menu1.setMnemonicParsing(false);
        menu1.setText("Edit");

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Undo");

        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("Redo");

        separatorMenuItem2.setMnemonicParsing(false);

        menuItem9.setMnemonicParsing(false);
        menuItem9.setText("Cut");

        menuItem10.setMnemonicParsing(false);
        menuItem10.setText("Copy");

        menuItem11.setMnemonicParsing(false);
        menuItem11.setText("Paste");

        menuItem12.setMnemonicParsing(false);
        menuItem12.setText("Delete");

        separatorMenuItem3.setMnemonicParsing(false);

        menuItem13.setMnemonicParsing(false);
        menuItem13.setText("Select All");

        menuItem14.setMnemonicParsing(false);
        menuItem14.setText("Unselect All");

        menu2.setMnemonicParsing(false);
        menu2.setText("Help");

        menuItem15.setMnemonicParsing(false);
        menuItem15.setText("About MyHelloApp");

        VBox.setVgrow(splitPane, javafx.scene.layout.Priority.ALWAYS);
        splitPane.setDividerPositions(0.2505567928730512, 0.7505567928730512);
        splitPane.setFocusTraversable(true);
        splitPane.setPrefHeight(-1.0);
        splitPane.setPrefWidth(-1.0);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        label.setMinWidth(60.0);
        label.setPrefWidth(-1.0);
        
        label.setText("File Explorer");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setWrapText(false);
        label.setFont(new Font(18.0));

        scrollPane.setPrefHeight(-1.0);
        scrollPane.setPrefWidth(-1.0);

        anchorPane0.setId("Content");
        anchorPane0.setMinHeight(-1.0);
        anchorPane0.setMinWidth(-1.0);
        anchorPane0.setPrefHeight(572.0);
        anchorPane0.setPrefWidth(442.0);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(14.0);
        label0.setLayoutY(14.0);
   
        label0.setText("Code");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setWrapText(false);

        hBox.setLayoutX(115.0);
        hBox.setLayoutY(14.0);
        hBox.setPrefHeight(61.0);
        hBox.setPrefWidth(200.0);

        button.setMnemonicParsing(false);
        button.setPrefHeight(60.0);
        button.setPrefWidth(98.0);
        button.setText("Run");
        button.setFont(new Font(19.0));

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(60.0);
        button0.setPrefWidth(98.0);
        button0.setText("Stop");
        button0.setFont(new Font(19.0));

       /* AnchorPane.setBottomAnchor(textArea, 0.0);
        AnchorPane.setLeftAnchor(textArea, 0.0);
        AnchorPane.setRightAnchor(textArea, 0.0);
        AnchorPane.setTopAnchor(textArea, 77.0);
        */textArea.setLayoutX(5.0);
        textArea.setLayoutY(80.0);
        textArea.setPrefHeight(850.0);
        textArea.setPrefWidth(880.0);
        textArea.setPromptText("type here..");
        scrollPane.setContent(anchorPane0);

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(14.0);
        label1.setLayoutY(14.0);
   
        label1.setText("Console");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setWrapText(false);

        AnchorPane.setBottomAnchor(textArea0, 0.0);
        AnchorPane.setLeftAnchor(textArea0, 0.0);
        AnchorPane.setRightAnchor(textArea0, 0.0);
        AnchorPane.setTopAnchor(textArea0, 77.0);
        textArea0.setLayoutX(2.0);
        textArea0.setLayoutY(77.0);
        textArea0.setPrefHeight(419.0);
        textArea0.setPrefWidth(215.0);

        menu.getItems().add(menuItem);
        menu.getItems().add(menuItem0);
        menu.getItems().add(menu0);
        menu.getItems().add(separatorMenuItem);
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem3);
        menu.getItems().add(menuItem4);
        menu.getItems().add(separatorMenuItem0);
        menu.getItems().add(menuItem5);
        menu.getItems().add(separatorMenuItem1);
        menu.getItems().add(menuItem6);
        menuBar.getMenus().add(menu);
        menu1.getItems().add(menuItem7);
        menu1.getItems().add(menuItem8);
        menu1.getItems().add(separatorMenuItem2);
        menu1.getItems().add(menuItem9);
        menu1.getItems().add(menuItem10);
        menu1.getItems().add(menuItem11);
        menu1.getItems().add(menuItem12);
        menu1.getItems().add(separatorMenuItem3);
        menu1.getItems().add(menuItem13);
        menu1.getItems().add(menuItem14);
        menuBar.getMenus().add(menu1);
        menu2.getItems().add(menuItem15);
        menuBar.getMenus().add(menu2);
        getChildren().add(menuBar);
        anchorPane.getChildren().add(label);
        splitPane.getItems().add(anchorPane);
        anchorPane0.getChildren().add(label0);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        anchorPane0.getChildren().add(hBox);
        anchorPane0.getChildren().add(textArea);
        splitPane.getItems().add(scrollPane);
        anchorPane1.getChildren().add(label1);
        anchorPane1.getChildren().add(textArea0);
        splitPane.getItems().add(anchorPane1);
        getChildren().add(splitPane);

    }
}
