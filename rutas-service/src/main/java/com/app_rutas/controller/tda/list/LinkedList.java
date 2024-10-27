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
        Node<E> aux = new Node<>(data);  // Crear el nuevo nodo
        if (isEmpty()) {
            head = aux;  // Si la lista está vacía, asignar head
            tail = head;  // También asignar tail
        } else {
            tail.setNext(aux); // Conectar el nodo anterior al nuevo
            tail = aux; // Mover tail al nuevo nodo
        }
        size++; // Incrementar el tamaño aquí
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

    public void delete(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        if (index == 0) {
            head = head.getNext();
            if (size == 1) {
                tail = null;
                head = null;
            }
            size--;
        } else { 
            Node<E> prevNode = getNode(index - 1); 
            Node<E> delNode = prevNode.getNext(); 
            if (delNode == null) {
                throw new IndexOutOfBoundsException("El nodo a eliminar es nulo");
            }
            prevNode.setNext(delNode.getNext());
            if (index == size - 1) {
                tail = prevNode; 
            }
        }
        size--; 
    }
    public void deleteHeader() throws ListEmptyException {
        delete(0);
    }
    public void deleteTail() throws ListEmptyException {
        delete(size - 1);
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
