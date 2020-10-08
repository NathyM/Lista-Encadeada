/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaencadeada;

import model.Aluno;
import model.Lista;

/**
 *
 * @author franklin
 */
public class ListaEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lista<Aluno> alunos = new Lista<>();
    
        Aluno aluno1 = new Aluno("Josefa", 30);
        Aluno aluno2 = new Aluno("Claudia", 25);
        Aluno aluno3 = new Aluno("Francisco", 40);
        Aluno aluno4 = new Aluno("Natan", 27);
        Aluno aluno5 = new Aluno("Vitor", 34);
        Aluno aluno6 = new Aluno("Cristovão", 20);

        System.out.println("\n Teste dos métodos de adição (e método redimensiona)\n");

        System.out.println(alunos); 
        alunos.adicionaFim(aluno1);
        alunos.adicionaFim(aluno2);
        alunos.adicionaFim(aluno3);
        System.out.println(alunos);
        alunos.adicionaInicio(aluno4);
        alunos.adicionaInicio(aluno5);
        System.out.println(alunos); 
        alunos.adiciona(aluno6, 3);
        System.out.println(alunos); 

        System.out.println("\n Teste do método existeDado \n");

        System.out.println(alunos.existeDado(aluno5)); 
        System.out.println(alunos.existeDado(new Aluno("Adriano", 45))); 

        System.out.println("\nTeste do método recupera \n");
        System.out.println(alunos.recupera(3)); 
        System.out.println(alunos.recupera(10)); 

        System.out.println("\n Teste dos métodos de remoção \n");
        System.out.println(alunos); 
        alunos.removeFim();
        System.out.println(alunos); 
        alunos.removeInicio();
        System.out.println(alunos); 
        alunos.remove(2);
        System.out.println(alunos); 
        alunos.remove(10); 

        System.out.println("\n Teste do método tamanho \n");
        System.out.println(alunos.tamanho()); 

        System.out.println("\nTeste dos métodos vazio e limpa \n");
        System.out.println(alunos); 
        System.out.println(alunos.vazio());
        alunos.limpa();
        System.out.println(alunos); 
        System.out.println(alunos.vazio()); 

      }


    }
