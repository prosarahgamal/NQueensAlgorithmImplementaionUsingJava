package AISolver;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Main extends Application {

    Interface anInterface;
    int queens;
    Backtracking backtracking;

    Solution solution;

    @Override
    public void start(Stage primaryStage) throws Exception{

        anInterface = new Interface();
        primaryStage.setScene(anInterface.scene);
        primaryStage.setTitle("N-Queen Puzzle");
        primaryStage.show();


        anInterface.goBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                queens = Integer.parseInt(anInterface.numOfQueens.getText());
                backtracking = new Backtracking(queens);
                solution = new Solution(queens, backtracking.getBoard());
                solution.backBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(anInterface.scene);
                    }
                });
                primaryStage.setScene(solution.scene);
            }
        });


    }


    public static void main(String[] args) {
        launch(args);
    }
}
