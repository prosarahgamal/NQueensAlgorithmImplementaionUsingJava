package AISolver;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Solution {
    Label[][] squares;
    int queens;
    GridPane gridPane;
    Scene scene;
    int board[][];
    VBox vBox;
    Button backBtn;

    Image image = new Image(getClass().getResourceAsStream("queen.png"));

    public Solution(int queens, int board[][]) {
        this.queens = queens;
        this.board = board;
        squares = new Label[queens][queens];

        gridPane = new GridPane();

        intialLbls();

        gridPane.setAlignment(Pos.CENTER);

        backBtn = new Button("Back");


        vBox = new VBox(10);

        vBox.getChildren().addAll(gridPane, backBtn);
        vBox.setAlignment(Pos.CENTER);

        scene = new Scene(vBox);

        backBtn.setMinWidth(scene.getWidth());

        scene.getStylesheets().add(Solution.class.getResource("style.css").toExternalForm());
    }

    public void intialLbls(){
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = new Label();
                gridPane.add(squares[i][j], j, i);
                squares[i][j].setMinWidth(34);
                squares[i][j].setMinHeight(34);
                squares[i][j].setStyle("-fx-border-color: #ccc;");
                if (board[i][j] == 1) {
                    squares[i][j].setGraphic(new ImageView(image));
                }
                if ((i%2 == 0) && (j%2 == 1)){
                    squares[i][j].setStyle("-fx-background-color: #42d7f4;");
                }else if ((i%2 == 1) && (j%2 == 0)){
                    squares[i][j].setStyle("-fx-background-color: #42d7f4;");
                }
            }
        }
    }
}
