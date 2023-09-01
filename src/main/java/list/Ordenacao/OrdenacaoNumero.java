package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumero {

    private final List<Integer> listaDeNumeros;

    //construtor de listaDeNumeros
    public OrdenacaoNumero() {
        this.listaDeNumeros = new ArrayList<>();
    }

    //Adicionan número na lista
    public void adicionarNumero(int numero) {
        this.listaDeNumeros.add(numero);
    }

    //Ordena numeros em ordem ascendente (sort)

    List<Integer> ordenarAscendente() {
        List<Integer> numerosOrdenadosAsc = new ArrayList<>(this.listaDeNumeros);
        if (!listaDeNumeros.isEmpty()) {
            //Usa Colletions.sort para ordenar os números
            Collections.sort(numerosOrdenadosAsc);
            return numerosOrdenadosAsc;
        }
        else {
            throw new RuntimeException("Lista vazia");
        }
    }

    //Ordenação Decrescente da lista de números (reverseOrder)
    List<Integer> ordenarDecrescente() {
        List<Integer> numerosOrdenadosDec = new ArrayList<>(this.listaDeNumeros);
        if (!listaDeNumeros.isEmpty()) {
            //Pega a nova lista e reverte a ordem por meio do Collections.reverseOrder();
            numerosOrdenadosDec.sort(Collections.reverseOrder());
            //Retorna a lista ordenada em ordem decrescente;
            return numerosOrdenadosDec;
        }
        else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoNumeros
        OrdenacaoNumero numeros = new OrdenacaoNumero();

        // Adicionando números à lista
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(7);
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(56);


        // Ordenando e exibindo em ordem ascendente
        System.out.println("Ordem Ascendente:" + numeros.ordenarAscendente());


        // Ordenando e exibindo em ordem descendente
        System.out.println("Ordem Decrescente:" + numeros.ordenarDecrescente());

    }
}
