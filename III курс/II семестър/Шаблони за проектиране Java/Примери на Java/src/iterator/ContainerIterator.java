package iterator;

import java.util.List;

public class ContainerIterator implements Iterator {

    private List<String> containerList;
    private int index;
    private Object current;

    public ContainerIterator(List<String> list) {
        this.containerList = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < containerList.size();
    }

    @Override
    public Object next() {

        if(this.hasNext()) {
            this.current = this.containerList.get(this.index);
            this.index = this.index + 1;
            return this.current;
        }

        return null;
    }
}
