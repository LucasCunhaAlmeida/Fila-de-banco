public class NoDuplamenteEncadeado {
    private int Indentificador;
    private NoDuplamenteEncadeado proximo;
    private NoDuplamenteEncadeado anterior;
    private int prioridade;

    public NoDuplamenteEncadeado(int indentificador,int prioridade) {
        Indentificador = indentificador;
        setAnterior(null);
        setProximo(null);
        this.prioridade = prioridade;
    }
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
