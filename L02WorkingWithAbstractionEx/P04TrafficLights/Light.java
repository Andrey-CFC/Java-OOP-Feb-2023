package L02WorkingWithAbstractionEx.P04TrafficLights;

public class Light {
    private Colour colour;

    public Light(Colour colour){
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void changeColour(){
        if (this.colour == Colour.RED){
            this.colour = Colour.GREEN;
        } else if (this.colour == Colour.GREEN){
            this.colour = Colour.YELLOW;
        } else if (this.colour == Colour.YELLOW){
            this.colour = Colour.RED;
        }
    }
}
