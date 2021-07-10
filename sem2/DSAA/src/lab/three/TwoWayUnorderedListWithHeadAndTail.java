package lab.three;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class TwoWayUnorderedListWithHeadAndTail<E> implements IList<E> {

    private class Element{

        E object;
        Element next=null;
        Element prev=null;

        public Element(E e) {
            this.object=e;
        }
        public Element(E e, Element next, Element prev) {
            this.object=e;
            this.next=next;
            this.prev=prev;
        }

        public E getObject() {
            return object;
        }

        public void setObject(E object) {
            this.object = object;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }
    }

    Element head;
    Element tail;
    // can be realization with the field size or without
    int size = 0;

    private class InnerIterator implements Iterator<E>{
        Element pos;
        // TODO maybe more fields....

        public InnerIterator() {
            pos=head;
            //TODO
        }
        @Override
        public boolean hasNext() {
            //TODO
            return pos!=null;
        }

        @Override
        public E next() {
            //TODO
           E value = pos.getObject();
           pos = pos.getNext();
           return value;
        }

    }

    private class InnerListIterator implements ListIterator<E>{
        Element p;
        int pos = 0;
        // TODO maybe more fields....

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();

        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return pos<size;
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            return pos>0;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            return get(pos+1);
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            // TODO Auto-generated method stub
            return get(pos-1);
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

        @Override
        public void set(E e) {
            // TODO Auto-generated method stub
            Element elem = getElement(pos);
            elem.setObject(e);
        }
    }

    public TwoWayUnorderedListWithHeadAndTail() {
        // make a head and a tail
        head=null;
        tail=null;
    }

    public Element getElement(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException();
        }
        Element actElem = head;
        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }
        if (actElem == null)
            throw new NoSuchElementException();

        return actElem;
    }

    @Override
    public boolean add(E e) {
        Element newElem = new Element(e);

        if (head == null) {
            head = newElem;
            size++;
            return true;
        }
        Element tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(newElem);
        newElem.setPrev(tail);
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }
        Element newElem = new Element(element);

        if (index == 0) {
            if (size != 0) {
                newElem.setNext(head);
                head.setPrev(newElem);
            }
            head = newElem;
            size++;
            return;
        }

        if (index == size) {
            add(element);
            return;
        }


        Element beforeElem = getElement(index - 1);
        Element afterElem = getElement(index);


        beforeElem.setNext(newElem);
        newElem.setPrev(beforeElem);
        newElem.setNext(afterElem);
        afterElem.setPrev(beforeElem);
        size++;
    }


    @Override
    public void clear() {
        //TODO
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        //TODO
        return indexOf(element)>=0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size || head == null) {
            throw new NoSuchElementException();
        }
        Element elem = getElement(index);
        return elem.getObject();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size || head == null) {
            throw new NoSuchElementException();
        }
        Element elem = getElement(index);
        E value = elem.getObject();
        elem.setObject(element);
        return value;
    }

    @Override
    public int indexOf(E element) {

        Element actElem = head;
        int pos = 0;
        while (actElem != null) {
            if (actElem.getObject().equals(element)) {
                return pos;
            }
            pos++;
            actElem = actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        //TODO
        if (index < 0 || index >= size || head == null) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            E value = head.getObject();
            head = head.getNext();
            size--;
            return value;
        }

        if (index == size - 1) {
            E value = getElement(index).getObject();
            getElement(index).getPrev().setNext(null);
            size--;
            return value;
        }

        Element actElem = getElement(index - 1);
        if (actElem.getNext() == null) {
            throw new NoSuchElementException();
        }
        E value = actElem.getNext().getObject();
        Element beforeElem = getElement(index - 1);
        Element afterElem = getElement(index + 1);

        beforeElem.setNext(afterElem);
        afterElem.setPrev(beforeElem);
        size--;
        return value;
    }


    @Override
    public boolean remove(E e) {
        //TODO
        if (contains(e)) {
            remove(indexOf(e));
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        //TODO
        return size;
    }
    public String toStringReverse() {

        ListIterator<E> iter = new InnerListIterator();
        while (iter.hasNext())
            iter.next();
        String retStr = "";
        return retStr;
    }

    public void add(TwoWayUnorderedListWithHeadAndTail<E> other) {
        //TODO
        boolean theSame = true;

        if (this.size != other.size) {
            theSame = false;
        }

        if (theSame) {
            for (int i = 0; i < this.size; i++) {
                if (!this.getElement(i).object.equals(other.getElement(i).object)) {
                    theSame = false;
                }
            }
        }
        if (!theSame) {
            tail.setNext(other.head);
        }
    }
}