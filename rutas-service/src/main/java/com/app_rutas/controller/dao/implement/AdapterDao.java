package com.app_rutas.controller.dao.implement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Scanner;

import com.app_rutas.controller.tda.list.LinkedList;
import com.google.gson.Gson;

//clase AdapterDao
public class AdapterDao<T> implements InterfazDao<T> {
    private Class<T> clazz;
    protected Gson g;
    public String URL = "media/";

    public AdapterDao(Class<T> clazz) {
        this.clazz = clazz;
        this.g = new Gson();
    }

    public void persist(T object) throws Exception {
        LinkedList<T> list = listAll();
        list.add(object); 
        
        String info = "";
        try {
            info = g.toJson(list.toArray());
        } catch (Exception e) {
            throw new Exception("Error al convertir a JSON");
        }
        saveFile(info);
    }

    public void merge(Integer index, T object) throws Exception {
        LinkedList<T> list = listAll();
        list.set(index, object);

        String info = "";
        try {
            info = g.toJson(list.toArray());
        } catch (Exception e) {
            throw new Exception("Error al convertir a JSON");
        }
        saveFile(info);
    }

    public LinkedList<T> listAll() throws Exception {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();

            Type arrayType = Array.newInstance(clazz, 0).getClass();
            T[] arrayObjects = g.fromJson(data, arrayType);

            for (T obj : arrayObjects) {
                if (obj != null) {
                    list.add(obj);
                }
            }

        } catch (Exception e) {
            throw new Exception("Error al convertir a JSON");
        }
        return list;
    }

    public T get(Integer id) throws Exception {
        return listAll().get(id - 1);
    }

    private String readFile() throws Exception {
        File file = new File(URL + clazz.getSimpleName() + ".json");
        if (!file.exists()) {
            return "[]"; 
        }

        Scanner in = new Scanner(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }

    private void saveFile(String info) throws Exception {
        File dir = new File(URL);
        if (!dir.exists()) {
            dir.mkdirs(); // Crea la carpeta si no existe
        }

        File file = new File(URL + clazz.getSimpleName() + ".json");
        FileWriter f = new FileWriter(file);
        f.write(info);
        f.flush();
        f.close();
    }
}

