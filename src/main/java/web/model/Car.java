package web.model;

public class Car {
    private String model;
    private String color;
    private int price;

    public Car() {
    }

    public Car(String voice, String color, int price) {
        this.model = voice;
        this.color = color;
        this.price = price;
    }

    public String getVoice() {
        return model;
    }

    public void setVoice(String voice) {
        this.model = voice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}