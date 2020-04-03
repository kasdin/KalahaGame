import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class GameBoard{

    Pane pane;
    public static LinkedList<House> list = new LinkedList<House>();
    private int houseid = 0;
    public static Button next;


    public GameBoard(Pane pane){
        this.pane = pane;
    }

    public void placeAll() {
        placeAllHousesP1();
        placeMancalaP1();
        placeAllHousesP2();
        placeMancalaP2();
        System.out.println(list);
    }

    public void placeAllHousesP1(){
        int x = 180;

        for (int i = 0; i < 6; i++) {
            House house = new House(x,500,houseid);
            pane.getChildren().add(house);
            list.addLast(house);
            x+= 150;
            houseid++;

        }

    }

    public void placeMancalaP1() {
        House mancalaP1 = new House(1050, 380, houseid);
        mancalaP1.setValue(0);
        mancalaP1.setShape(new Circle(180));
        mancalaP1.setPrefSize(180,180);
        pane.getChildren().add(mancalaP1);
        list.addLast(mancalaP1);
        houseid++;
    }

    public void placeAllHousesP2() {
        int x = 920;
        for (int i = 0; i < 6; i++) {
            House house = new House(x, 300, houseid);
            pane.getChildren().add(house);
            x -= 150;
            houseid++;
            list.addLast(house);

        }

    }

    public void placeMancalaP2() {
        House mancalaP2 = new House(10, 380, houseid);
        mancalaP2.setValue(0);
        mancalaP2.setShape(new Circle(180));
        mancalaP2.setPrefSize(180,180);
        pane.getChildren().add(mancalaP2);
        list.addLast(mancalaP2);
    }



}
