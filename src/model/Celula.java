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
public class Celula {
  private Celula proximo;
  private Object elemento;

  public Celula() {
  }

  public Celula(Object elemento) {
    this.elemento = elemento;
  }

  public Celula(Celula proximo, Object elemento) {
    this.proximo = proximo;
    this.elemento = elemento;
  }

  public Celula getProximo() {
    return proximo;
  }

  public void setProximo(Celula proximo) {
    this.proximo = proximo;
  }

  public Object getElemento() {
    return elemento;
  }

  public void setElemento(Object elemento) {
    this.elemento = elemento;
  }

    
}
