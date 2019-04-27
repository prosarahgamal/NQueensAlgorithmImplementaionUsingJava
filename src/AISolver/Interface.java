package AISolver;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Interface{

    TextField numOfQueens;
    Label numOfQueensLbl;
    Button goBtn;
    VBox vBox;
    Scene scene;
    public Interface(){

        numOfQueens = new TextField();
        numOfQueensLbl = new Label("Num Of Queens");
        goBtn = new Button("GO");

        vBox = new VBox(10);
        vBox.getChildren().addAll(numOfQueensLbl, numOfQueens, goBtn);
        vBox.setAlignment(Pos.CENTER);
        scene = new Scene(vBox, 400, 400);

        goBtn.setMinWidth(scene.getWidth());

        scene.getStylesheets().add(Interface.class.getResource("style.css").toExternalForm());
    }
}
