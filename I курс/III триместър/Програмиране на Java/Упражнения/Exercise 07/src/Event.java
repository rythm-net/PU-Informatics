public class Event {

    // характеристики на едно събитие
    public String eventTitle; // поле на класа
    public String eventId;

    public boolean isAdultOnly;

    public void showEventInfo() {

        // променлива в метода showEvent
        String eventTitle = "Единствено събитие";

        System.out.println(this.eventTitle);
        System.out.println(eventId);
        System.out.println(isAdultOnly);
        System.out.println("***");
    }
}