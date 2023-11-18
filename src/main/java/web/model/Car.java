package web.model;

public class Car {
    private String voice;
    private String color;
    private int price;

    public Car() {
    }

    public Car(String voice, String color, int price) {
        this.voice = voice;
        this.color = color;
        this.price = price;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
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