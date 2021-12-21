package hashset;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    List<Integer>[] container = null;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;

    public MyHashSet() {
        container = new LinkedList[cap];
    }
    public void add(int key) {
        if(contains(key)) return;
        if(loadFactor * cap == count) {
            count = 0;
            //rehash
            List<Integer>[] old = container;
            container = new LinkedList[cap];
            for(int i = 0; i < old.length; i++) {
                List<Integer> list = old[i];
                if(list != null) {
                    for(int entry : list) {
                        this.add(entry);
                    }
                }
            }
        }

        int hash = key % cap;
        if(container[hash] == null) {
            container[hash] = new LinkedList<>();
        }
        container[hash].add(key);
        ++count;
    }

    public void remove(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null) {
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext()) {
                if(itr.next() == key) {
                    itr.remove();
                    --count;
                }
            }
        }
    }

    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null) {
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext()) {
                if(itr.next() == key) {
                    return true;
                }
            }
        }
        return false;
    }


}
