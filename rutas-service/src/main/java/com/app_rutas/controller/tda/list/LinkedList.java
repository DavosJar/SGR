package com.app_rutas.controller.tda.list;

import java.util.ArrayList;
import java.util.List;

import com.app_rutas.controller.excepcion.ListEmptyException;

public class LinkedList <E> {

    private Node<E> head;
    private Node<E> tail;
    private Integer size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    /**
     * Metodo verifica si la lista esta vacia
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Metodo que agrega un elemento header a la lista
     * @param data
     */
    public void addHeader(E data) {
        Node<E> aux = new Node<>(data);
        if (isEmpty()) {
            head = aux;
            tail = head;
        } else {
            aux.setNext(head);
            head = aux;
        }
        size++;
    }

    private void addTail(E data) {
        Node<E> aux = new Node<>(data); 
        if (isEmpty()) {
            head = aux;  
            tail = head;  
        } else {
            tail.setNext(aux); 
            tail = aux; 
        }
        size++; 
    }
    public void add(E data) {
        addTail(data);
    }

    /**
     * metodo que agrega un elemento en la posicion index
     * @param data
     * @param index
     * @throws ListEmptyException
     * @throws IndexOutOfBoundsException
     */
    public void add(E data, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        System.out.println("Agregando en índice: " + index + ", data: " + data);
        
        if (index == 0) {
            addHeader(data);
        } else if (index.intValue() == size) {
            addTail(data);
        } else {
            Node<E> search = getNode(index - 1);
            System.out.println("Nodo anterior encontrado: " + search.getData());
            
            Node<E> aux = new Node<>(data);
            aux.setNext(search.getNext());
            search.setNext(aux);
            size++;
        }
    }

    private Node<E> getNode(Integer index)throws ListEmptyException, IndexOutOfBoundsException{
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        if (index == size - 1) {
            return tail;
        }
        Node<E> search = head;
        Integer count = 0;
        while (count < index) {
            search = search.getNext();
            count++;
        }
        return search;
    }
    public E get(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        return getNode(index).getData();
    }

    public void set(Integer index, E data) throws ListEmptyException, IndexOutOfBoundsException {
            getNode(index).setData(data);
    }

    public void reset() {
        head = null;
        tail = null;
        size = 0;
    }

    public E delete(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }else if(index == 0){
            return deleteHeader();
        }else if(index == size - 1){
            return deleteTail();
        }else{
            Node<E> prevNode = getNode(index - 1);
            Node<E> actualNode = getNode(index);
            E element = prevNode.getData();
            Node<E> nextNode = actualNode.getNext();
            actualNode = null;
            prevNode.setNext(nextNode);
            size--;
            return element;
        }
    }
    public E deleteHeader() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }else{
            E element = head.getData();
            Node<E> aux = head.getNext();
            head = aux;
            if(size == 1){
                tail = null;
            }
            size--;
            return element;
        }
    }
    public E deleteTail() throws ListEmptyException {
        if(isEmpty()){
            throw new ListEmptyException("La lista esta vacia");
        }else{
            E element = tail.getData();
            Node<E> aux = getNode(size - 2);
            if(aux == null){
                head = null;
                tail = null;
                if(size == 2 ){
                    tail = head;
                }else{
                    head = null;
                }
            }else{
                tail = null;
                tail = aux;
                tail.setNext(null);
            }
            size--;
            return element;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> search = head;
        while (search != null) {
            sb.append(search.getData());
            sb.append("\n");
            search = search.getNext();
        }
        return sb.toString();
    }
    public void update(E data, Integer post)throws ListEmptyException, IndexOutOfBoundsException{
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }
        if (post < 0 || post >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }else if(post == 0){
            head.setData(data);
        }else if(post == size - 1){
            tail.setData(data);
        }else{
            Node<E> search = head;
            Integer count = 0;
            while (count < post) {
                count++;
                search = search.getNext();
            }
            search.setData(data);
        }
    }

    public Object[] toArray() {
    // Usamos una lista temporal para evitar posiciones null
    List<Object> tempArray = new ArrayList<>();
    Node<E> current = head;
    
    while (current != null) {
        tempArray.add(current.getData());  // Añadimos solo nodos con data
        current = current.getNext();
    }
    
    return tempArray.toArray();
}
    public static<E> LinkedList<E> toList(E[] matrix) {
        LinkedList<E> list = new LinkedList<>();
        for (E data : matrix) {
            list.add(data);
        }
        return list;
    }
    
}
