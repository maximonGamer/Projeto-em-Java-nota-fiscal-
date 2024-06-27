import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Item> biblioteca = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Criar Livro");
            System.out.println("2. Criar Revista");
            System.out.println("3. Criar Jornal");
            System.out.println("4. Criar DVD");
            System.out.println("5. Listar Itens");
            System.out.println("6. Atualizar Item");
            System.out.println("7. Excluir Item");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    criarLivro();
                    break;
                case 2:
                    criarRevista();
                    break;
                case 3:
                    criarJornal();
                    break;
                case 4:
                    criarDVD();
                    break;
                case 5:
                    listarItens();
                    break;
                case 6:
                    atualizarItem();
                    break;
                case 7:
                    excluirItem();
                    break;
                case 8:
                    sair = true;
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close(); // Fechar o scanner ao sair do programa
    }

    private static void criarLivro() {
        System.out.println("\n=== Criar Livro ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Data de Publicação: ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Item livro = new Livro(titulo, autor, dataPublicacao, isbn);
        biblioteca.add(livro);
        System.out.println("Livro criado com sucesso.");
    }

    private static void criarRevista() {
        System.out.println("\n=== Criar Revista ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Data de Publicação: ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("Edição: ");
        int edicao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Item revista = new Revista(titulo, autor, dataPublicacao, edicao);
        biblioteca.add(revista);
        System.out.println("Revista criada com sucesso.");
    }

    private static void criarJornal() {
        System.out.println("\n=== Criar Jornal ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Data de Publicação: ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("Data da Edição: ");
        String dataEdicao = scanner.nextLine();

        Item jornal = new Jornal(titulo, autor, dataPublicacao, dataEdicao);
        biblioteca.add(jornal);
        System.out.println("Jornal criado com sucesso.");
    }

    private static void criarDVD() {
        System.out.println("\n=== Criar DVD ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Data de Publicação: ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("Duração (minutos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Item dvd = new DVD(titulo, autor, dataPublicacao, duracao);
        biblioteca.add(dvd);
        System.out.println("DVD criado com sucesso.");
    }

    private static void listarItens() {
        System.out.println("\n=== Listar Itens ===");
        if (biblioteca.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
        } else {
            for (int i = 0; i < biblioteca.size(); i++) {
                System.out.println(i + ": " + biblioteca.get(i).toString());
            }
        }
    }

    private static void atualizarItem() {
        System.out.println("\n=== Atualizar Item ===");
        if (biblioteca.isEmpty()) {
            System.out.println("A biblioteca está vazia. Não há itens para atualizar.");
        } else {
            System.out.print("Informe o índice do item a ser atualizado (começando em 0): ");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (indice >= 0 && indice < biblioteca.size()) {
                Item item = biblioteca.get(indice);

                System.out.print("Novo Título: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Novo Autor: ");
                String novoAutor = scanner.nextLine();
                System.out.print("Nova Data de Publicação: ");
                String novaDataPublicacao = scanner.nextLine();

                item.setTitulo(novoTitulo);
                item.setAutor(novoAutor);
                item.setDataPublicacao(novaDataPublicacao);

                if (item instanceof Livro) {
                    System.out.print("Novo ISBN: ");
                    String novoIsbn = scanner.nextLine();
                    ((Livro) item).setIsbn(novoIsbn);
                } else if (item instanceof Revista) {
                    System.out.print("Nova Edição: ");
                    int novaEdicao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    ((Revista) item).setEdicao(novaEdicao);
                } else if (item instanceof Jornal) {
                    System.out.print("Nova Data da Edição: ");
                    String novaDataEdicao = scanner.nextLine();
                    ((Jornal) item).setDataEdicao(novaDataEdicao);
                } else if (item instanceof DVD) {
                    System.out.print("Nova Duração (minutos): ");
                    int novaDuracao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    ((DVD) item).setDuracao(novaDuracao);
                }

                System.out.println("Item atualizado com sucesso.");
            } else {
                System.out.println("Índice inválido. Tente novamente.");
            }
        }
    }

    private static void excluirItem() {
        System.out.println("\n=== Excluir Item ===");
        if (biblioteca.isEmpty()) {
            System.out.println("A biblioteca está vazia. Não há itens para excluir.");
        } else {
            System.out.print("Informe o índice do item a ser excluído (começando em 0): ");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (indice >= 0 && indice < biblioteca.size()) {
                biblioteca.remove(indice);
                System.out.println("Item excluído com sucesso.");
            } else {
                System.out.println("Índice inválido. Tente novamente.");
            }
        }
    }
}
