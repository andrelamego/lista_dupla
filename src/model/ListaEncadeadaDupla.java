package model;

public class ListaEncadeadaDupla {
    private No inicio = null;
    private No fim = null;


    public int getTotal() {
        int total = 0;

        if(this.inicio == null)
            return 0;
        else {
            No buffer = this.inicio;

            do{
                total++;
                buffer = buffer.getProximo();
            }while (buffer.getProximo() != null);
        }
        return total;
    }


    public void insert(String elemento){
        No novo = new No(elemento);

        if(this.inicio == null){
            this.inicio = novo;
            this.fim = novo;
        }
        else{
            No buffer = this.inicio;
            insert(buffer, novo);
        }
    }

    private void insert(No buffer, No novo) {

        if(buffer.getProximo() != null){
            if(buffer.getValor().compareToIgnoreCase(novo.getValor()) > 0){

                if(buffer.getAnterior() != null) {
                    No anterior = buffer.getAnterior();
                    anterior.setProximo(novo);
                    novo.setAnterior(anterior);
                }
                else{
                    this.inicio = novo;
                }
                novo.setProximo(buffer);
                buffer.setAnterior(novo);

                return;
            }
            else{
                insert(buffer.getProximo(), novo);
            }
        }
        else {
            if(buffer.getValor().compareToIgnoreCase(novo.getValor()) > 0){

                if(buffer.getAnterior() != null) {
                    No anterior = buffer.getAnterior();
                    anterior.setProximo(novo);
                    novo.setAnterior(anterior);
                }
                else{
                    this.inicio = novo;
                }
                novo.setProximo(buffer);
                buffer.setAnterior(novo);
            }
            else {
                this.fim = novo;
                novo.setAnterior(buffer);
                buffer.setProximo(novo);
            }
            return;
        }
    }


    public void remove(int index) throws IllegalArgumentException{
        if(this.inicio == null)
            throw new IllegalArgumentException("Não há itens na lista");

        if(index == 0){
            this.inicio.setValor(null);
            this.inicio.setAnterior(null);

            if(this.inicio.getProximo() == null){
                this.inicio = null;
                this.fim = null;
            }
            else {
                No buffer = this.inicio.getProximo();
                this.inicio.setProximo(null);
                this.inicio = buffer;
            }
            return;
        }

        No anterior = this.get(index - 1);
        No item = anterior.getProximo();
        No proximo = item.getProximo();
        anterior.setProximo(proximo);
        item.setProximo(null);
        item.setValor(null);
    }

    private No get(int index) throws IllegalArgumentException{
        if(this.inicio == null)
            throw new IllegalArgumentException("Não existe item na lista");

        No buffer = this.inicio;
        int i;
        for (i = 0; i < index; i++) {
            if(buffer.getProximo() == null){
                break;
            }
            buffer = buffer.getProximo();
        }

        if(i < index){
            throw new IllegalArgumentException("O indice informado não existe");
        }
        return buffer;
    }

    public String printAsc() {
        if (this.inicio == null)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        No buffer = this.inicio;
        builder.append(buffer.getValor());
        while(buffer.getProximo() != null){
            builder.append(", ");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");

        return builder.toString();
    }

    public String printDesc() {
        if (this.fim == null)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        No buffer = this.fim;
        builder.append(buffer.getValor());
        while(buffer.getAnterior() != null){
            builder.append(", ");
            buffer = buffer.getAnterior();
            builder.append(buffer.getValor());
        }
        builder.append("]");
        return builder.toString();
    }
}
