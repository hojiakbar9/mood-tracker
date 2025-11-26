import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MoodTracker {
    private static final List<Mood> moodsList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

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
                case "a":
                    addMood();
                    continue;
                case "d":
                    deleteMoodOptions();
                    continue;
                case "e": 	//add code to edit mood
                    continue;
                case "s": 	//add code to search mood
                    continue;
                case "M": 	//add code to get all moods
                    continue;
                case "w": 	//add code to write mood to a file
                    continue;
                case "Exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    return;
                default: 	System.out.println("Not a valid input!");
            }
        }
    }
    private static void addMood(){
        System.out.println("Enter the mood name");
        String moodName = scanner.nextLine();
        System.out.println("Are you tracking the mood for a current day? y/n");
        String isForCurrentDate = scanner.nextLine();
        Mood moodToAdd = null;
        if(isForCurrentDate.equalsIgnoreCase("n")) {
            try {
                Mood moodPropsFromUser = getMoodPropsFromUser(moodName);
                System.out.println("Add notes about this mood");
                String moodNotes = scanner.nextLine();
                if(!moodNotes.strip().equalsIgnoreCase(""))
                    moodPropsFromUser.setNotes(moodNotes);
            } catch (DateTimeParseException dfe) {
                System.out.println("Incorrect format of date or time. Cannot create mood.\n");
                return;
            }
        } else {
            System.out.println("Add notes about this mood");
            String moodNotes = scanner.nextLine();
            if(moodNotes.strip().equalsIgnoreCase("")) {
                moodToAdd = new Mood(moodName);
            } else {
                moodToAdd = new Mood(moodName, moodNotes);
            }
        }
        try {
            boolean isValid = isMoodValid(moodToAdd);
            if(isValid) {
                moodsList.add(moodToAdd);
                System.out.println("The mood has been added to the tracker");

            }
        } catch(InvalidMoodException ime) {
            System.out.println("The mood is not valid");
        }
    }

    private static boolean isMoodValid(Mood mood) throws InvalidMoodException {
        for(Mood tempMood: MoodTracker.moodsList) {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }
    private static void deleteMoodOptions(){
        System.out.println("Enter '1' to delete all moods by date\n"+
                "Enter '2' to delete a specific mood");
        String deleteOption = scanner.nextLine();
        if(deleteOption.equals("1"))
            deleteMoodsByDate();
        else if(deleteOption.equals("2"))
            deleteSingleMood();
    }
    private static void deleteMoodsByDate(){
        try{
            System.out.println("Enter the date in MM/dd/yyyy format");
            String inputDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate date = LocalDate.parse(inputDate.strip(), formatter);
            if(deleteMoods(date)) System.out.println("The moods have been deleted");
            else System.out.println("No matching moods found");
        }catch(DateTimeParseException exception){
            System.out.println("Invalid date format. Deletion failed.");
        }
    }

    private static boolean deleteMoods(LocalDate date){
        boolean removed = false;
        Iterator<Mood> iterator = moodsList.iterator();
        while ((iterator.hasNext())){
            Mood current = iterator.next();
            if(current.getDate().equals(date)){
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }
    private static void deleteSingleMood(){
        try{
            System.out.println("Enter the mood name");
            String moodName = scanner.nextLine();
            Mood moodPropsFromUser = getMoodPropsFromUser(moodName);
            boolean isMoodDeleted = deleteMood(moodPropsFromUser);
            if(isMoodDeleted) {
                System.out.println("The mood has been deleted");
            } else {
                System.out.println("No matching mood found");
            }
        }
        catch (DateTimeParseException ex){
            System.out.println("Invalid date format. Failed to delete the mood");
        }
    }
    private static Mood getMoodPropsFromUser(String moodName){
        System.out.println("Input the date in MM/dd/yyyy format:");
        String moodDateStr = scanner.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
        System.out.println("Input the time in HH:mm:ss format:");
        String moodTimeStr = scanner.nextLine();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
        return new Mood(moodName, moodDate, moodTime);
    }
    private static boolean deleteMood(Mood mood){
        boolean removed = false;
        Iterator<Mood> iterator = moodsList.iterator();
        while ((iterator.hasNext())){
            Mood current = iterator.next();
            if(mood.equals(current)){
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }


}
