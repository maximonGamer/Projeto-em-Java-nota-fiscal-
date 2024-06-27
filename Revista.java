public class Revista extends Item {
    private int edicao;

    public Revista(String titulo, String autor, String dataPublicacao, int edicao) {
        super(titulo, autor, dataPublicacao);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Edição: " + edicao;
    }
}
