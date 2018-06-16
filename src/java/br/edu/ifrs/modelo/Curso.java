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
public class Curso {
      private int id;
      private String nome;
      private String descricao;
      private String periodoIntegralizacao;
      private String cargaHoraria;
      private String situacao;
      private Coordenador coordenador;

  
  
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the periodoIntegralizacao
     */
    public String getPeriodoIntegralizacao() {
        return periodoIntegralizacao;
    }

    /**
     * @param periodoIntegralizacao the periodoIntegralizacao to set
     */
    public void setPeriodoIntegralizacao(String periodoIntegralizacao) {
        this.periodoIntegralizacao = periodoIntegralizacao;
    }

    /**
     * @return the cargaHoraria
     */
    public String getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the coordenador
     */
    public Coordenador getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
    
    
}

