public class NoDuplamenteEncadeado {

    /**
     * Atributos para a criação do NoDuplamenteEncadeado
     */
    private int Indentificador;
    private NoDuplamenteEncadeado proximo;
    private NoDuplamenteEncadeado anterior;
    private int prioridade;

    /**
     * Construtor para a classe NoDuplamenteEncadeado.
     *
     * @param indentificador O identificador único do nó, passado automaticamente
     *                       pelo programa ao adicionar uma pessoa na fila.
     * @param prioridade A prioridade do nó, que o usuário escolhe entre as 3 opçõoes.
     */
    public NoDuplamenteEncadeado(int indentificador,int prioridade) {
        Indentificador = indentificador;
        setAnterior(null);
        setProximo(null);
        this.prioridade = prioridade;
    }

    /**
     * Métodos getters e setters de cada atributo para a sua manipulação.
     */
    public int getIndentificador() {
        return Indentificador;
    }
    public NoDuplamenteEncadeado getProximo() {
        return proximo;
    }
    public NoDuplamenteEncadeado getAnterior() {
        return anterior;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setIndentificador(int indentificador) {
        Indentificador = indentificador;
    }
    public void setProximo(NoDuplamenteEncadeado proximo) {
        this.proximo = proximo;
    }
    public void setAnterior(NoDuplamenteEncadeado anterior) {
        this.anterior = anterior;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
