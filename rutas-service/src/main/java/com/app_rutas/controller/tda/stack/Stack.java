package com.app_rutas.controller.tda.stack;

public class Stack <E>{
    private StackOperation<E> stackOperation;

    public Stack(Integer cant){
        stackOperation = new StackOperation<>(cant);
    }
    public void push(E data) throws Exception {
        stackOperation.push(data);
    }

    public Integer getSize() {
        return stackOperation.getSize();
    }
    public void clear(){
        this.stackOperation.reset();
    }
    public Integer getTop() {
        return this.stackOperation.getTop();
    }
    public E pop() throws Exception {
        return stackOperation.pop();
    }
    public void print(){
        System.out.println("PILA");
        System.out.println(stackOperation.toString());
        System.out.println("********");
    }

    @Override
    public String toString(){
        return stackOperation.toString();
    }
}
