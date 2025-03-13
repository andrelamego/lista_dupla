package controller;

import model.ListaEncadeadaDupla;

public class ListaController {
    public ListaController(){
        super();
    }

    public String printar(){
        ListaEncadeadaDupla lista = new ListaEncadeadaDupla();

        lista.insert("Victor");
        lista.insert("Joao Victor");
        lista.insert("Joao");
        lista.insert("Gabriel");
        lista.insert("Bruno");
        lista.insert("Andre");
        lista.insert("Henrique");

        return lista.printAsc();
    }

}
