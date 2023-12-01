package iterator;

import java.util.Arrays;

public class NameRepository implements Container {

    private String names[] = {
            "Ivan",
            "Peter",
            "Georgi"
    };

    @Override
    public Iterator getIterator() {
        return new ContainerIterator(Arrays.asList(names));
    }
}
