public class Principal {

    public static void main(String[] args) {
        Fila fila = new Fila();

        NoDuplamenteEncadeado no1 = new NoDuplamenteEncadeado(0,1);
        NoDuplamenteEncadeado no2 = new NoDuplamenteEncadeado(1,2);
        NoDuplamenteEncadeado no3 = new NoDuplamenteEncadeado(2,0);
        NoDuplamenteEncadeado no4 = new NoDuplamenteEncadeado(3,0);
        NoDuplamenteEncadeado no5 = new NoDuplamenteEncadeado(4,2);
        NoDuplamenteEncadeado no6 = new NoDuplamenteEncadeado(5,0);
        NoDuplamenteEncadeado no7 = new NoDuplamenteEncadeado(6,0);
        NoDuplamenteEncadeado no8 = new NoDuplamenteEncadeado(7,1);
        NoDuplamenteEncadeado no9 = new NoDuplamenteEncadeado(8,2);

        fila.inserirOrdenado(no1);
        fila.inserirOrdenado(no2);
        fila.inserirOrdenado(no3);
        fila.inserirOrdenado(no4);
        fila.inserirOrdenado(no5);
        fila.inserirOrdenado(no6);
        fila.inserirOrdenado(no7);
        fila.inserirOrdenado(no8);
        fila.inserirOrdenado(no9);

        fila.imprimirLista(fila);

        System.out.println(" ");
        fila.removerInicio();
        fila.imprimirLista(fila);
    }
}
