public class Fila {

    /**
     * A cabeça é sempre o primeiro elemento da fila
     */
    private NoDuplamenteEncadeado cabeca;

    /**
     * Esté método serve para inserir um novo no duplamente encadeado, de uma forma
     * já ordenada, a partir de sua prioridade:
     * prioridade 0 -> PCD (prioridade maxíma)
     * prioridade 1 -> IGA (prioridade abaixo do 0)
     * prioridade 2 -> SP (Sem prioridade alguma)
     *
     * @param no Esse é um no do tipo duplamente encadeado que identfica uma pessoa
     * e queremos inserir na fila.
     */
    public void inserirOrdenado(NoDuplamenteEncadeado no) {

        if (ListaVazia()) {
            // se a fila está vazia, então esse novo no será a cabeça.
            setCabeca(no);
        } else {
            // Pegamos um auxiliar para percorrer a lista.
            NoDuplamenteEncadeado noTemp = getCabeca();

            if (no.getPrioridade() < noTemp.getPrioridade()) {
                /**
                 * Se o no que deseja inserir tem mais prioridade do que
                 * a cabeca, então a nova cabeca vai ser o novo no a ser inserido.
                 * A cabeca antiga vai para a posicao seguinte
                 */
                no.setProximo(noTemp);
                noTemp.setAnterior(no);
                setCabeca(no);
            }else{

                while (noTemp.getProximo() != null && noTemp.getProximo().getPrioridade()
                        <= no.getPrioridade()) {
                    /**
                     * Se o no da repetição tiver uma prioridade menor ou igual do que o que
                     * queremos inserir, então atualizamos o noTemp para ir ao proximo no.
                     */
                    noTemp = noTemp.getProximo();
                }

                // O no a ser inserido vai apontar para o proximo do noTemp.
                no.setProximo(noTemp.getProximo());
                // E o anterior desse no a ser inserido vai apontar para o noTemp.
                no.setAnterior(noTemp);

                if (noTemp.getProximo() != null) {
                    // Se o noTemp estiver na ultima posição, a inserção será no final.
                    noTemp.getProximo().setAnterior(no);
                }

                // noTemp para passar a apontar para o no a ser inserido.
                noTemp.setProximo(no);
            }
        }
    }

    /**
     * Esté método serve para remover uma pessoa da lista (essa pessoa será
     * chamada e por isso deve sair da fila), sempre iremos remover uma pessoa
     * que está no início da fila
     */
    public void removerInicio() {
        if (!ListaVazia()) {
            // Se a fila não estiver vazia temos elementos a serem removidos
            if (cabeca.getProximo() == null) {
                // Só existe a cabeca na fila, então é só colocar ela como vazia
                setCabeca(null);
            } else {
                // Senão, a cabeça passa a ser o proximo da cabeca atual
                cabeca.getProximo().setAnterior(null);
                setCabeca(cabeca.getProximo());
            }
        }
    }

    /**
     * Esté método serve para saber se a fila está vazia(sem nenhum no duplamente
     * encadeado).
     *
     * @return se a cabeca estiver vazia, retorna verdadeiro, se estiver apontando
     * para outro no duplamente encadeado retorna falso.
     */
    public boolean ListaVazia() {
        return getCabeca() == null;
    }

    /**
     * Construtor da classe fila, sempre que instanciado, a cabeca é vazia,
     * ou seja, a quantidade de nos duplamente encadeados na fila é 0.
     */
    public Fila() {
        this.cabeca = null;
    }

    /**
     * Métodos getters e setters de cabeca
     */
    public NoDuplamenteEncadeado getCabeca() {
        return cabeca;
    }

    public void setCabeca(NoDuplamenteEncadeado cabeca) {
        this.cabeca = cabeca;
    }

    /**
     * No momento esté método de imprimir toda a fila não está sendo usada no código,
     * pois a interface gráfica já está fazendo esse papel.
     * @param fila recebe a lista duplamente encadeada
     */
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
