public class Jornal extends Item {
    private String dataEdicao;

    public Jornal(String titulo, String autor, String dataPublicacao, String dataEdicao) {
        super(titulo, autor, dataPublicacao);
        this.dataEdicao = dataEdicao;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Data da Edição: " + dataEdicao;
    }
}
