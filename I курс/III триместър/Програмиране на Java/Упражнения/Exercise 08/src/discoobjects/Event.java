package discoobjects;

import java.util.Random;

public class Event {

    // характеристики на едно събитие
    private String eventTitle; // поле на класа
    private String eventId;
    private boolean isAdultOnly;
    private int ageUpperBound;
    private int ageLowerBound;

    public static final int LEGAL_ADULT_AGE = 18;
    public static final int LOWER_PARTY_AGE = 0;

    public Event(String eventTitle) {

        this.setEventTitle(eventTitle);
        this.setEventId();
    }

    public Event(String eventTitle, boolean isAdultOnly) {

        this.setEventTitle(eventTitle);
        this.setEventId();
        this.setIsAdultOnly(isAdultOnly);
    }

    public Event(String eventTitle, boolean isAdultOnly, int min, int max) {

        this.setEventTitle(eventTitle);
        this.setEventId();
        this.setIsAdultOnly(isAdultOnly);
        this.setAgeLowerBound(min);
        this.setAgeUpperBound(max);
    }

    public void setEventTitle(String title) {
        this.eventTitle = title;
    }

    public String getEventTitle() {
        return this.eventTitle;
    }

    public void setEventId() {
        this.eventId = this.generateUniqueId();
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setIsAdultOnly(boolean isAdultOnly) {
        this.isAdultOnly = isAdultOnly;
    }

    public boolean getIsAdultOnly() {
        return this.isAdultOnly;
    }

    public void setAgeUpperBound(int ageUpperBound) {
        this.ageUpperBound = ageUpperBound;
    }

    public int getAgeUpperBound() {
        return this.ageUpperBound;
    }

    public void setAgeLowerBound(int ageLowerBound) {

        int systemAgeLowerBound = (this.getIsAdultOnly())
                ? LEGAL_ADULT_AGE
                : LOWER_PARTY_AGE;

        this.ageLowerBound      = (ageLowerBound < systemAgeLowerBound)
                ? systemAgeLowerBound
                : ageLowerBound;
    }

    public int getAgeLowerBound() {
        return this.ageLowerBound;
    }

    public void showEventInfo() {

        // променлива в метода showEvent
        String eventTitle = "Единствено събитие";

        System.out.println(this.getEventTitle());
        System.out.println(eventId);
        System.out.println(isAdultOnly);
        System.out.println("***");
    }

    public String generateUniqueId() {

        Random randomGenerator = new Random();
        int numberOfIterations = randomGenerator.nextInt(100) + 5;

        String id = "";
        for(int i = 0; i < numberOfIterations; i++) {
            id += randomGenerator.nextInt(500000);
        }

        return id;
    }
}