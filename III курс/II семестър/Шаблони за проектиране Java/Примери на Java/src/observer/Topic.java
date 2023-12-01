package observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Observable {

    private List<Observer> observerList;
    private String topic;

    public Topic() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        this.observerList.add(observer);
        observer.setTopic(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observerList.remove(observer);
        observer.setTopic(null);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : this.observerList) {
            observer.update();
        }
    }

    @Override
    public String getUpdate() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
        this.notifyObservers();
    }
}
