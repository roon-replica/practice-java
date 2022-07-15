package interface_lambda.sequence;

import java.util.List;

// List는 원소가 추가,삭제 될 수 있어서 size 정보를 초기에 가지고 있는게 의미가 없을듯

public class ListSequence implements Sequence<Number> {
    private List<Number> list;
    private int idx;

    public ListSequence(List<Number> list) {
        this.list = list;
    }

    @Override
    public synchronized boolean hasNext() {
        return idx < list.size() - 1;
    }

    @Override
    public synchronized Number next() {
        return list.get(idx++);
    }

    @Override
    public int size() {
        return list.size();
    }
}
