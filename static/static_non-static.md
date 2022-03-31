[stackexchange 글 - static vs non-static 사용 예시](https://softwareengineering.stackexchange.com/questions/238782/why-prefer-non-static-inner-classes-over-static-ones)

## 1. static
- enum이 대표적 
  - enum type is implicitly static
- as a public helper class
- 장점
  - outer attribute 접근 불가 (Non-static field cannot be referenced from a static context)
  ==> less coupling?
``` java
public class Calculator {
    public enum Operation {
        PLUS, MINUS;
    }

    int outerAttr;

    public static void main(String[] args) {
        System.out.println(Operation.PLUS);
    }
}
```

## 2. non static
- adapter pattern
  - [sample code from my previous github](https://github.com/auddl0756/DesignPattern/commit/23e44017e487d52609004ba3fbbd20245079696b)
- 단점(주의할 점?)
  - outer filed 접근 가능
  - .class file decompile 해보면 생성자 param에 outer class로의 참조 존재함 (implicitly done)

``` java
// in java.util.HashMap
final class KeySet extends AbstractSet<K> {
        public final int size()                 { return size; }
        public final void clear()               { HashMap.this.clear(); }
        public final Iterator<K> iterator()     { return new KeyIterator(); }
        public final boolean contains(Object o) { return containsKey(o); }
        public final boolean remove(Object key) {
            return removeNode(hash(key), key, null, false, true) != null;
        }
        public final Spliterator<K> spliterator() {
            return new KeySpliterator<>(HashMap.this, 0, -1, 0, 0);
        }
        public final void forEach(Consumer<? super K> action) {
            Node<K,V>[] tab;
            if (action == null)
                throw new NullPointerException();
            if (size > 0 && (tab = table) != null) {
                int mc = modCount;
                for (Node<K,V> e : tab) {
                    for (; e != null; e = e.next)
                        action.accept(e.key);
                }
                if (modCount != mc)
                    throw new ConcurrentModificationException();
            }
        }
    }
```


