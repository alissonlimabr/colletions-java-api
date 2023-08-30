package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaItem;

    // constructor
    public CarrinhoDeCompras() {
        this.listaItem = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listaItem.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> listaItensRemover = new ArrayList<>();
        if (!listaItem.isEmpty()) {
            for (Item item : listaItem) {
                //itera a lista. Se houver o nome especificado, adiciona para remover;
                if (item.getNome().equalsIgnoreCase(nome))
                    listaItensRemover.add(item);
            }
            listaItem.removeAll(listaItensRemover);
        } else
            System.out.println("A lista esta vazia!");
    }

    public double calcularValorTotal() {
        double valorTotalCarrinho = 0d;
        if (!listaItem.isEmpty()) {
            // Laço para iterar a lista de itens
            for (Item item: listaItem) {
                double precoQuantidadeItem = item.getPreco() * item.getQuantidade();
                valorTotalCarrinho += valorTotalCarrinho + precoQuantidadeItem;
            }
            return valorTotalCarrinho;
        }
        else
            throw new RuntimeException("O Carrinho de compras está vazio!");
    }

    public void exibirItens() {
        if (!listaItem.isEmpty())
            System.out.println(this.listaItem);
        else
            System.out.println("A lista de itens esta vazia!");
    }
    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItem("Lápis de cor", 7d, 2);
        carrinhoDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}

