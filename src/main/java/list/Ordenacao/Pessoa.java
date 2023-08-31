package main.java.list.Ordenacao;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa> {
    //atributos
    private String nome;
    private int idade;
    private double altura;

    // Constructor
    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    //Método comparable
    @Override
    public int compareTo(Pessoa p) { // Recebe a idade
        return Integer.compare(idade, p.getIdade()); //compara a idade recebida
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    //ToString
    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
}

// Para usar o comparator, precisamos de uma nova classe que implemente Comparator<Pessoa>
class ComparatorPorAltura implements Comparator<Pessoa> {
    @Override
    // o método compare é usado para comparar dois objetos
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura()); //retorna um Double com a comparação entre as alturas;
    }
}
