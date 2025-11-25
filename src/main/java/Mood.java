import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {
    private String name;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.MIDNIGHT;
    private String notes;

    public Mood(String name) {
        this.name = name;
    }

    public Mood(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Mood(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    public Mood(String moodName, String moodNotes) {
        this.name = moodName;
        this.notes = moodNotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String toString() {
        return name + " - " + date + " " + time + "\n" +notes;
    }
    public boolean equals(Mood mood) {
        if(mood.name.equalsIgnoreCase(this.name) &&
                mood.getDate().equals(this.date) &&
                mood.getTime().equals(this.time)) {
            return true;
        } else {
            return false;
        }
    }
}
