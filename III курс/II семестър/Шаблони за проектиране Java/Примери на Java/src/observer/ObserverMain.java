package observer;

public class ObserverMain {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer obs1 = new TopicSubscriber("Obs1");
        Observer obs2 = new TopicSubscriber("Obs2");
        Observer obs3 = new TopicSubscriber("Obs3");

        topic.subscribe(obs1);
        topic.subscribe(obs2);
        topic.subscribe(obs3);

        topic.setTopic("Breaking news: Something good happened!");

        topic.unsubscribe(obs2);
        topic.setTopic("Breaking news: Nothing happened.");
    }
}
