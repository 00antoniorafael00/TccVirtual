/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import java.util.Date;
import java.util.List;


/**
 *
 * @author rafael
 */
public class Banca {
      private int id;
      private Date dataBanca;  //perguntar para Gleison
      private Date horarioBanca; //perguntar para Gleison
      private String modalidadeBanca;
      private int numeroSala;
      private String situacao;
      private Tcc tcc;
      private List<Professor> professoresBanca;
      

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
     * @return the dataBanca
     */
    public Date getDataBanca() {
        return dataBanca;
    }

    /**
     * @param dataBanca the dataBanca to set
     */
    public void setDataBanca(Date dataBanca) {
        this.dataBanca = dataBanca;
    }

    /**
     * @return the horarioBanca
     */
    public Date getHorarioBanca() {
        return horarioBanca;
    }

    /**
     * @param horarioBanca the horarioBanca to set
     */
    public void setHorarioBanca(Date horarioBanca) {
        this.horarioBanca = horarioBanca;
    }

    /**
     * @return the modalidadeBanca
     */
    public String getModalidadeBanca() {
        return modalidadeBanca;
    }

    /**
     * @param modalidadeBanca the modalidadeBanca to set
     */
    public void setModalidadeBanca(String modalidadeBanca) {
        this.modalidadeBanca = modalidadeBanca;
    }

    /**
     * @return the numeroSala
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * @param numeroSala the numeroSala to set
     */
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
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

    /**
     * @return the professoresBanca
     */
    public List<Professor> getProfessoresBanca() {
        return professoresBanca;
    }

    /**
     * @param professoresBanca the professoresBanca to set
     */
    public void setProfessoresBanca(List<Professor> professoresBanca) {
        this.professoresBanca = professoresBanca;
    }
      
      

}
