public class Livro extends Item {
    private String isbn;

    public Livro(String titulo, String autor, String dataPublicacao, String isbn) {
        super(titulo, autor, dataPublicacao);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + ", ISBN: " + isbn;
    }
}
