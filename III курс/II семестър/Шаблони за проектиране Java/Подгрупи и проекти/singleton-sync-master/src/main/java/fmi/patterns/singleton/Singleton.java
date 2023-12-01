package fmi.patterns.singleton;

/**
 * Пример за шаблона Singleton към дисциплината "Проектиране на софтуер и архитектури"
 */
public class Singleton {

    // Референция към единствената инстанция.
    private static Singleton uniqueInstance = null;

    // Някакъв атрибут на инстанцията.
    private int data = 0;

    /**
     * Връща референция към единствената инстанция. Създава инстанцията ако все
     * още не съществува (това се нарича lazy (мързелива, отложена)
     * инициализация). Част от тялото на метода е синхронизирано за да е Thread Safe.
     */
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (uniqueInstance == null)
                uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }

    /**
     * Singleton констурктора. Забележете, че е private! Външен клас не може да
     * създаде инстанция.
     */
    private Singleton() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
