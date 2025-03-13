package model;

public class No {

    private String valor;
    private No anterior;
    private No proximo;

    public No(String valor) {
        this.anterior = null;
        this.proximo = null;
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }


    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }


    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString(){
        return valor.toString();
    }
}
