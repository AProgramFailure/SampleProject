package groupNumber.uno.client.model.card;

public class Card {

    private String color;

    private String value;

    private String currentColor;


    public Card(String color, String value){
        this.color = color;
        this.value = value;
        this.currentColor = color;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "[" + getColor() + " " + getValue() + "]";
    }
}
