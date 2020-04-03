import javafx.scene.control.Button;
import javafx.scene.shape.Circle;


public class House extends Button {

    private int value = 4; //Start value is 4
    private int houseID;
    GameMain gameMain = new GameMain();



    public House(int x, int y, int houseID) {
        super.setText(String.valueOf(value));
        super.setShape(new Circle(120));
        super.setPrefSize(120,120);
        super.setLayoutX(x);
        super.setLayoutY(y);
        super.setId("" + houseID);
        this.houseID = houseID;
}

    public void logicInteraction() {
        gameMain.step3(houseID);
    }

    public void activateButton(){
        super.setOnAction(event -> logicInteraction());
    }

    public void disableButton() {
        super.setOnAction(null);
    }

    public int getHouseID() {
        return houseID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        super.setText(String.valueOf(value));
    }

}
