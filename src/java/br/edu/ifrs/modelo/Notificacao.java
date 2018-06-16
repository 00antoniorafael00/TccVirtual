/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

/**
 *
 * @author rafael
 */
public class Notificacao {
      private int id;
      private int usuarioOrigem;
      private int usuarioDestino;
      private String mensagem;
      private Usuario origem;
      private Usuario destino;
      private Tcc tcc;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the usuarioOrigem
     */
    public int getUsuarioOrigem() {
        return usuarioOrigem;
    }

    /**
     * @param usuarioOrigem the usuarioOrigem to set
     */
    public void setUsuarioOrigem(int usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    /**
     * @return the usuarioDestino
     */
    public int getUsuarioDestino() {
        return usuarioDestino;
    }

    /**
     * @param usuarioDestino the usuarioDestino to set
     */
    public void setUsuarioDestino(int usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }


    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the origem
     */
    public Usuario getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Usuario origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public Usuario getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    /**
     * @return the tcc
     */
    public Tcc getTcc() {
        return tcc;
    }

    /**
     * @param tcc the tcc to set
     */
    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }
      
      
}
