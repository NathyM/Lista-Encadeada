/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author franklin
 */
public class Lista<T> {
    
  private Celula inicio;
  private Celula fim;
  private int quantidadeElementos = 0;

    public Lista() {
    }
    
 
    

  public void adiciona(T elemento, int posicao) {
    if (posicao == 0) {
      this.adicionaInicio(elemento);
    } else if (posicao == (this.quantidadeElementos - 1)) {
      this.adicionaFim(elemento);
    } else {
      try {
        this.verificaIntervaloAdicao(posicao);
        Celula anterior = this.recuperaCelula(posicao - 1);
        Celula proxima = this.recuperaCelula(posicao);
        Celula nova = new Celula(proxima, elemento);
        anterior.setProximo(nova);
        this.quantidadeElementos++;
      } catch (IndexOutOfBoundsException e) {
        System.out.println("ERRO! A posição " + posicao + " não é válida. Escolha um valor de 0 a " + this.quantidadeElementos + ".");
      }
    }
  }


  public void adicionaInicio(T elemento) {
    Celula nova = new Celula(elemento);
    if (this.vazio()) {
      this.inicio = this.fim = nova;
    } else {
      nova.setProximo(inicio);
      inicio = nova;
    }
    this.quantidadeElementos++;
  }


  public void adicionaFim(T elemento) {
    Celula nova = new Celula(elemento);
    if (this.vazio()) {
      this.inicio = this.fim = nova;
    } else {
      fim.setProximo(nova);
      fim = nova;
    }
    this.quantidadeElementos++;
  }

  // Verifica se o dado existe na Lista Encadeada;
  public boolean existeDado(T elemento) {
    if (this.quantidadeElementos != 0) {
      Iterador iterador = new Iterador(this.inicio);
      while (iterador.hasNext()) {
        if (elemento == iterador.next()) {
          return true;
        }
      }
    }
    return false;
  }

  // Recupera a Célula presente na posição passada como parâmetro;
  private Celula recuperaCelula(int posicao) {
    try {
      this.verificaIntervalo(posicao);
      Iterador iterador = new Iterador(this.inicio);
      int i = 0;
      while (iterador.hasNext()) {
        if (i != posicao) {
          iterador.next();
          i++;
        } else {
          break;
        }
      }
      return iterador.getAtual();
    } catch (IndexOutOfBoundsException e) {
      System.out.print("ERRO! A posição " + posicao + " não existe. A lista vai de 0 a " + (this.quantidadeElementos - 1) + ". ");
      return null;
    } catch (NullPointerException e) {
      System.out.print("ERRO! A posição " + posicao + " não existe. A lista está vazia. ");
      return null;
    }
  }

  // Recupera o objeto da posição passada como parâmetro;
  public T recupera(int posicao) {
    try {
      this.verificaIntervalo(posicao);
      Celula celula = this.recuperaCelula(posicao);
      return (T) celula.getElemento();
    } catch (IndexOutOfBoundsException e) {
      System.out.print("ERRO! A posição " + posicao + " não existe. A lista vai de 0 a " + (this.quantidadeElementos - 1) + ". ");
      return null;
    } catch (NullPointerException e) {
      System.out.print("ERRO! A posição " + posicao + " não existe. A lista está vazia. ");
      return null;
    }
  }

  // Método que verifica se a lista está vazia
  public boolean vazio() {
    return this.quantidadeElementos == 0;
  }

  // Remove o objeto da Lista Encadeada na posição passada como parâmetro;
  public void remove(int posicao) {
    if (posicao == 0) {
      this.removeInicio();
    } else if (posicao == (this.quantidadeElementos - 1)) {
      this.removeFim();
    } else {
      try {
        this.verificaIntervalo(posicao);
        Celula anterior = this.recuperaCelula(posicao - 1);
        Celula proxima = this.recuperaCelula(posicao + 1);
        anterior.setProximo(proxima);
        this.quantidadeElementos--;
      } catch (IndexOutOfBoundsException e) {
        System.out.println("ERRO! A posição " + posicao + " não existe. A lista vai de 0 a " + (this.quantidadeElementos - 1) + ".");
      } catch (NullPointerException e) {
        System.out.println("ERRO! A posição " + posicao + " não existe. A lista está vazia.");
      }
    }
  }

  //Remove a primeira posição da Lista Encadeada;
  public void removeInicio() {
    try {
      this.verificaIntervalo(0);
      this.inicio = this.inicio.getProximo();
      this.quantidadeElementos--;
    } catch (NullPointerException e) {
      System.out.println("ERRO! A lista está vazia.");
    }
  }

  // Remove a última posição da Lista Encadeada;
  public void removeFim() {
    try {
      this.verificaIntervalo(this.quantidadeElementos - 1);
      this.fim = this.recuperaCelula(this.quantidadeElementos - 2);
      this.fim.setProximo(null);
      this.quantidadeElementos--;
    } catch (NullPointerException e) {
      System.out.println("ERRO! A lista está vazia.");
    }
  }

  // Retorna o tamanho da Lista Encadeada (quantidade de elementos inseridos)
  public int tamanho() {
    return this.quantidadeElementos;
  }

  // Exclui todos os elementos da Lista Encadeada;
  public void limpa() {
    this.inicio = this.fim = null;
    this.quantidadeElementos = 0;
  }

  @Override
  public String toString() {
    if (this.quantidadeElementos == 0) return "[]";
    Iterador<T> iterador = new Iterador<>(inicio);
    String listaToString = "[" + iterador.next();
    while (iterador.hasNext()) {
      listaToString += ", " + iterador.next();
    }
    listaToString += "]";

    return listaToString;
  }

  // Retorna erro se a posição não estiver no intervalo de elementos existentes
  private void verificaIntervalo(int posicao) {
    if (this.vazio()) {
      throw new NullPointerException("Lista vazia");
    }
    if ((posicao < 0 || posicao >= this.quantidadeElementos)) {
      throw new ArrayIndexOutOfBoundsException("Posição Inválida");
    }
  }

  // Retorna erro se a posição não estiver no intervalo de elementos existentes ou no primeiro elemento vazio
  private void verificaIntervaloAdicao(int posicao) {
    if ((posicao < 0 || posicao > this.quantidadeElementos)) {
      throw new ArrayIndexOutOfBoundsException("Posição Inválida");
    }
  }
    
}
