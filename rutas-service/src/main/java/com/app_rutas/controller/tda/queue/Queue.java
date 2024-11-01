package com.app_rutas.controller.tda.queue;

public class Queue<E> {
    private QueueOperation<E> queueOperation;
    public Queue(Integer cant){
        this.queueOperation = new QueueOperation<>(cant);
    }
    public void queue(E data) throws Exception {
        this.queueOperation.enqueue(data);
    }
    public E dequeue() throws Exception {
        return this.queueOperation.dequeue();
    }
    public Integer getSize() {
        return this.queueOperation.getSize();
    }
    public void clear(){
        this.queueOperation.reset();
    }
    public Integer getTop() {
        return this.queueOperation.getTop();
    }

    public void print(){
        System.out.println("COLA");
        System.out.println(this.queueOperation.toString());
        System.out.println("********");
    }
    @Override
    public String toString(){
        return this.queueOperation.toString();
    }
}
