import discoobjects.Customer;
import discoobjects.Event;
import discoobjects.SexEnum;

import java.util.ArrayList;

public class Application {

    // характеристики на клиенти
    public static String customerFirstName;
    public static String customerLastName;
    public static String customerSex;
    public static int customerAge;

    // допускаме че мога да организирам до 10 събития
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
        Event mainEvent = new Event("Мега Парти", true, 20, 65);
        addEvent(mainEvent);

        Event secondaryEvent = new Event("Тъпо Парти");
        addEvent(secondaryEvent);

        Event blackParty = new Event("Еминем ин ДЪ хаус", true);
        addEvent(blackParty);

        Event chalgaParty = new Event("Чалга парти", true);
        addEvent(chalgaParty);

        listAllEvent();

        // нов потребител
        Customer mainCustomer = new Customer("Mihail", "Petrov", SexEnum.MALE);
    }
}