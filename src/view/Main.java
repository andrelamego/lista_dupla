package view;

import controller.ListaController;

public class Main {
    public static void main(String[] args) {
        try {
            ListaController lista = new ListaController();

            System.out.println(lista.printar());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
