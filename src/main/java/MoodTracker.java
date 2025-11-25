import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoodTracker {
    private static List<Mood> moodObjs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("Press 'a' to add mood\n" +
                    "'d' to delete mood(s)\n" +
                    "'e' to edit mood\n" +
                    "'s' to search for moods\n" +
                    "'M' to get all moods\n" +
                    "'w' to write the moods to a file\n" +
                    "Type 'Exit' to exit");
            String menuOption = scanner.nextLine();
            switch(menuOption) {
                case "a": 	//add code to add mood
                    continue;
                case "d": 	//add code to delete mood
                    continue;
                case "e": 	//add code to edit mood
                    continue;
                case "s": 	//add code to search mood
                    continue;
                case "M": 	//add code to get all moods
                    continue;
                case "w": 	//add code to write mood to a file
                    continue;
                case "Exit": 	System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    break;
                default: 	System.out.println("Not a valid input!");
            }
        }
    }
}
