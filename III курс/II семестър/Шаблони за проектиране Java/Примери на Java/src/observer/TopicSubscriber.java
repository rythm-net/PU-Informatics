package observer;

public class TopicSubscriber implements Observer {

    private Observable topic;
    private String name;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this.getName() + " Updated with: " +
                this.topic.getUpdate());
    }

    @Override
    public void setTopic(Observable topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }
}
