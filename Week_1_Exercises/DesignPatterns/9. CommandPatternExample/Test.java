import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoteControl remote = new RemoteControl();
        Map<String, Light> lights = new HashMap<>();
        while (true) {
            System.out.println("Select command: 1. Light ON 2. Light OFF 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            if (choice == 3) {
                scanner.close();
                System.exit(0);
            }
            System.out.print("Enter light location: ");
            String location = scanner.nextLine();
            Light light = lights.get(location);
            if (light == null) {
                light = new Light(location);
                lights.put(location, light);
            }
            Command command;
            switch (choice) {
                case 1:
                    command = new LightOnCommand(light);
                    break;
                case 2:
                    command = new LightOffCommand(light);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            remote.setCommand(command);
            remote.pressButton();
        }
    }
}