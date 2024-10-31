package com.app_rutas.controller.dao.implement;

import com.app_rutas.controller.tda.list.LinkedList;

public interface InterfazDao<T> {
    public void persist(T object) throws Exception;
    public void merge(Integer Index, T object) throws Exception;
    public LinkedList<T> listAll() throws Exception;
    public T get(Integer id) throws Exception;
}
