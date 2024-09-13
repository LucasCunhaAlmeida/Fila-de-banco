public class Principal {

    public static void main(String[] args) {
        Fila fila = new Fila();

        NoDuplamenteEncadeado no1 = new NoDuplamenteEncadeado(0,1);
        NoDuplamenteEncadeado no2 = new NoDuplamenteEncadeado(1,2);
        NoDuplamenteEncadeado no3 = new NoDuplamenteEncadeado(2,0);

        fila.inserirOrdenado(no1);
        fila.inserirOrdenado(no2);
        fila.inserirOrdenado(no3);

        //System.out.println(" " + fila.getCabeca().getPrioridade());

        fila.imprimirLista(fila);
    }
}
