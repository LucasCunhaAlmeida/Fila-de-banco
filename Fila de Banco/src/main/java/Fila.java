public class Fila {

    private NoDuplamenteEncadeado cabeca;

    public void inserirOrdenado(NoDuplamenteEncadeado no) {

        if (ListaVazia()) {
            setCabeca(no);
        } else {
            NoDuplamenteEncadeado noTemp = getCabeca();

            if (no.getPrioridade() < noTemp.getPrioridade()) {
                no.setProximo(noTemp);
                noTemp.setAnterior(no);
                setCabeca(no);
            }else{
                while (noTemp.getProximo() != null && noTemp.getProximo().getPrioridade() <= no.getPrioridade()) {
                    noTemp = noTemp.getProximo();
                }

                no.setProximo(noTemp.getProximo());
                no.setAnterior(noTemp);

                if (noTemp.getProximo() != null) {
                    noTemp.getProximo().setAnterior(no);
                }

                noTemp.setProximo(no);
            }
        }
    }

    public void removerInicio() {
        if (!ListaVazia()) {
            if (cabeca.getProximo() == null) {
                setCabeca(null);
            } else {
                cabeca.getProximo().setAnterior(null);
                setCabeca(cabeca.getProximo());
            }
        }
    }

    public boolean ListaVazia() {
        return getCabeca() == null;
    }

    public Fila() {
        this.cabeca = null;
    }

    public NoDuplamenteEncadeado getCabeca() {
        return cabeca;
    }

    public void setCabeca(NoDuplamenteEncadeado cabeca) {
        this.cabeca = cabeca;
    }

    public void imprimirLista(Fila fila){

        // Começa pelo primeiro nó da fila
        NoDuplamenteEncadeado atual = fila.getCabeca();

        // Percorre a lista até o final
        while (atual != null) {
            // Imprime o valor do nó atual
            System.out.printf(" " + atual.getIndentificador() + ", " + atual.getPrioridade() +" | ");

            // Avança para o próximo nó
            atual = atual.getProximo();
        }
    }
}
