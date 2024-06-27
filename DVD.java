public class DVD extends Item {
    private int duracao; // duração em minutos

    public DVD(String titulo, String autor, String dataPublicacao, int duracao) {
        super(titulo, autor, dataPublicacao);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duração: " + duracao + " minutos";
    }
}
