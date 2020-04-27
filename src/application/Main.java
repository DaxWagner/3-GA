package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Calculator");

        List<String> math = new ArrayList<>();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button btn1 = new Button("1");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 1, 3);

        Button btn2 = new Button("2");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid.add(hbBtn2, 2, 3);

        Button btn3 = new Button("3");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid.add(hbBtn3, 3, 3);

        Button btn4 = new Button("4");
        HBox hbBtn4 = new HBox(10);
        hbBtn4.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn4.getChildren().add(btn4);
        grid.add(hbBtn4, 1, 2);

        Button btn5 = new Button("5");
        HBox hbBtn5 = new HBox(10);
        hbBtn5.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn5.getChildren().add(btn5);
        grid.add(hbBtn5, 2, 2);

        Button btn6 = new Button("6");
        HBox hbBtn6 = new HBox(10);
        hbBtn6.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn6.getChildren().add(btn6);
        grid.add(hbBtn6, 3, 2);

        Button btn7 = new Button("7");
        HBox hbBtn7 = new HBox(10);
        hbBtn7.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn7.getChildren().add(btn7);
        grid.add(hbBtn7, 1, 1);

        Button btn8 = new Button("8");
        HBox hbBtn8 = new HBox(10);
        hbBtn8.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn8.getChildren().add(btn8);
        grid.add(hbBtn8, 2, 1);

        Button btn9 = new Button("9");
        HBox hbBtn9 = new HBox(10);
        hbBtn9.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn9.getChildren().add(btn9);
        grid.add(hbBtn9, 3, 1);

        Button btn0 = new Button("0");
        HBox hbBtn0 = new HBox(10);
        hbBtn0.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn0.getChildren().add(btn0);
        grid.add(hbBtn0, 2, 4);

        Button btnp = new Button(" + ");
        HBox hbBtnp = new HBox(10);
        hbBtnp.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnp.getChildren().add(btnp);
        grid.add(hbBtnp, 0, 1);

        Button btnm = new Button(" - ");
        HBox hbBtnm = new HBox(10);
        hbBtnm.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnm.getChildren().add(btnm);
        grid.add(hbBtnm, 0, 2);

        Button btnt = new Button(" * ");
        HBox hbBtnt = new HBox(10);
        hbBtnt.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnt.getChildren().add(btnt);
        grid.add(hbBtnt, 0, 3);

        Button btnd = new Button(" / ");
        HBox hbBtnd = new HBox(10);
        hbBtnd.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnd.getChildren().add(btnd);
        grid.add(hbBtnd, 0, 4);
        
        Button btng = new Button(" log ");
        HBox hbBtng = new HBox(10);
        hbBtng.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtng.getChildren().add(btng);
        grid.add(hbBtng, 0, 5);

        Button btno = new Button(".");
        HBox hbBtno = new HBox(10);
        hbBtno.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtno.getChildren().add(btno);
        grid.add(hbBtno, 1, 4);

        Button btne = new Button("=");
        HBox hbBtne = new HBox(10);
        hbBtne.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtne.getChildren().add(btne);
        grid.add(hbBtne, 3, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 0);

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);

        Button[] bts = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnp, btnm, btnt, btnd, btno, btng};

        for (Button b : bts) {
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    math.add(b.getText());
                    actiontarget.setText(renderArguments(math));

                }
            });
        }

        btne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                actiontarget.setText(collapseArguments(math));
                math.clear();

            }
        });

        stage.show();
    }

    private static String collapseArguments(List<String> arguments){
        boolean dec = false;
        String op = "+";
        double total = 0;
        double arg = 0;
        double deep = 0.1;

        for (String a : arguments){
            double num = 100;
            if (a.equals("1")){
                num = 1;
            }
            else if (a.equals("2")){
                num = 2;
            }
            else if (a.equals("3")){
                num = 3;
            }
            else if (a.equals("4")){
                num = 4;
            }
            else if (a.equals("5")){
                num = 5;
            }
            else if (a.equals("6")){
                num = 6;
            }
            else if (a.equals("7")){
                num = 7;
            }
            else if (a.equals("8")){
                num = 8;
            }
            else if (a.equals("9")){
                num = 9;
            }
            else  if (a.equals("0")){
                num = 0;
            }
            else if (a.equals(".")){
                dec = true;
            }
            else{
                if (op.equals("+")){
                    total = total + arg;
                }
                if (op.equals("-")){
                    total = total - arg;
                }
                if (op.equals("*")){
                    total = total * arg;
                }
                if (op.equals("/")){
                	if (arg == 0.0) {
                		return("divide by zero error");
                	}
                    total = total / arg;
                }
                if (op.equals(" log ")){
                    
                    	total = Math.log(arg);

                }
                deep = 0.1;
                dec = false;
                op = a;
                arg = 0;
            }


            if (num < 100)
            {
                if (dec == false){
                    arg = arg * 10 + num;
                }
                else{
                    arg = arg + (deep*num);
                    deep = deep / 10;
                }

            }
        }
        if (op.equals(" + ")){
            total = total + arg;
        }
        if (op.equals(" - ")){
            total = total - arg;
        }
        if (op.equals(" * ")){
            total = total * arg;
        }
        if (op.equals(" / ")){
        	if (arg == 0.0) {
        		return("divide by zero error");
        	}
            total = total / arg;
        }
        if (op.equals(" log ")){
            
        	total = Math.log(arg);

    }
        
        arguments = new ArrayList<>();
        return Double.toString(total);

    }

    private static String renderArguments(List<String> arguments){
        String chain = "";
        for(String a : arguments){
            chain = chain + a;
        }
        return chain;
    }

}