package L02WorkingWithAbstractionEx.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lights = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        List<Light> trafficLight = new ArrayList<>();
        for (String colour : lights) {
            Light light = new Light(Colour.valueOf(colour));
            trafficLight.add(light);
        }
        for (int i = 0; i < n; i++) {
            trafficLight.forEach(light -> {
                light.changeColour();
                System.out.print(light.getColour() + " ");
            });
            System.out.println();
        }
    }
}
