package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogoLivros {

    private List<Livro> listaLivro;

    public CatalogoLivros() {
        this.listaLivro = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        listaLivro.add(new Livro(titulo, autor, anoPublicacao));
    }

    //Método que retorna uma lista de livros que possuem o mesmo autor;
    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!listaLivro.isEmpty()) {
            for ( Livro livro : listaLivro) {
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
            return livrosPorAutor;
        }
        else {
            throw new RuntimeException("A lista esta vazia!");
        }
    }

    //Pesquisar uma lista de livros pelo intervalo de anos de publicação;
    public List<Livro> pesquisarPorAnoPublicacao(int anoInicial, int anoFinal) {
        List<Livro> livrosPorAnoPublicacao = new ArrayList<>();
        if (!listaLivro.isEmpty()) {
            // itera a lista de livros. Se houver livros publicados entre o período informado, adiciona na nova lista.
            for (Livro livro: listaLivro) {
                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao()<= anoFinal){
                    livrosPorAnoPublicacao.add(livro);
                }
            }
            return livrosPorAnoPublicacao;
        }
        else {
            throw new RuntimeException("A lista de livros está vazia!");
        }
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livropesquisado = null;
        if (!listaLivro.isEmpty()) {
            for (Livro livro: listaLivro) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)){
                    livropesquisado = livro;
                    break;
                }
            }
            return livropesquisado;
        }
        else {
            throw new RuntimeException("A lista de livros está vazia!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do catálogo de livros
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        // Adicionando livros ao catálogo
        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);

        // Exibindo livros pelo mesmo autor
        System.out.println(catalogoLivros.pesquisarPorAutor("Robert C. Martin"));

        // Exibindo livros pelo mesmo autor (caso em que não há livros de um autor específico)
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

        // Exibindo livros dentro de um intervalo de anos
        System.out.println(catalogoLivros.pesquisarPorAnoPublicacao(2010, 2022));

        // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
        System.out.println(catalogoLivros.pesquisarPorAnoPublicacao(2025, 2030));

        // Exibindo livros por título
        System.out.println(catalogoLivros.pesquisarPorTitulo("Java Guia do Programador"));

        // Exibindo livros por título (caso em que não há livros com o título especificado)
        System.out.println(catalogoLivros.pesquisarPorTitulo("Título Inexistente"));
    }
}

