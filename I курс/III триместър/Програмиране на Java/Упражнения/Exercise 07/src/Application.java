import java.util.ArrayList;

public class Application {

    // характеристики на клиенти
    public static String customerFirstName;
    public static String customerLastName;
    public static String customerSex;
    public static int customerAge;

    public static ArrayList<Event> eventCollection = new ArrayList();

    public static void addEvent(Event event) {
        eventCollection.add(event);
    }

    public static void listAllEvent() {

        for(Event element: eventCollection) {

            if(element != null) {
                element.showEventInfo();
            }
        }
    }

    public static void main(String[] args) {

        // създавам нов обект, с данни
        Event mainEvent = new Event();
        mainEvent.eventTitle = "Мега Парти";
        mainEvent.eventId = "abcdef";
        mainEvent.isAdultOnly = true;
        addEvent(mainEvent);

        Event secondaryEvent = new Event();
        secondaryEvent.eventTitle = "Тъпо Парти";
        secondaryEvent.eventId = "123456";
        secondaryEvent.isAdultOnly = false;
        addEvent(secondaryEvent);

        Event blackParty = new Event();
        blackParty.eventTitle = "Еминем ин ДЪ хаус";
        blackParty.eventId = "966325445";
        blackParty.isAdultOnly = true;
        addEvent(blackParty);

        Event chalgaParty = new Event();
        chalgaParty.eventTitle = "Чалга парти";
        chalgaParty.eventId = "745864";
        chalgaParty.isAdultOnly = true;
        addEvent(chalgaParty);

        listAllEvent();
    }
}