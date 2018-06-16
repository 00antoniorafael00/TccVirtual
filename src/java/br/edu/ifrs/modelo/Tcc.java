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
public class Tcc {
     private int id;
     private String titulo;
     private String palavrasChaves;
     private String areaPrincipal; 
     private String areaSecundaria;
     private String resumo;
     private String situacao;
     private String versaoFinal;
     private String versaoBanca;
     private Estudante autor;
     private Orientador orientador;

     
     
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the palavrasChaves
     */
    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    /**
     * @param palavrasChaves the palavrasChaves to set
     */
    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    /**
     * @return the areaPrincipal
     */
    public String getAreaPrincipal() {
        return areaPrincipal;
    }

    /**
     * @param areaPrincipal the areaPrincipal to set
     */
    public void setAreaPrincipal(String areaPrincipal) {
        this.areaPrincipal = areaPrincipal;
    }

    /**
     * @return the areaSecundaria
     */
    public String getAreaSecundaria() {
        return areaSecundaria;
    }

    /**
     * @param areaSecundaria the areaSecundaria to set
     */
    public void setAreaSecundaria(String areaSecundaria) {
        this.areaSecundaria = areaSecundaria;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
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
     * @return the versaoFinal
     */
    public String getVersaoFinal() {
        return versaoFinal;
    }

    /**
     * @param versaoFinal the versaoFinal to set
     */
    public void setVersaoFinal(String versaoFinal) {
        this.versaoFinal = versaoFinal;
    }

    /**
     * @return the versaoBanca
     */
    public String getVersaoBanca() {
        return versaoBanca;
    }

    /**
     * @param versaoBanca the versaoBanca to set
     */
    public void setVersaoBanca(String versaoBanca) {
        this.versaoBanca = versaoBanca;
    }

    /**
     * @return the autor
     */
    public Estudante getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Estudante autor) {
        this.autor = autor;
    }

    /**
     * @return the orientador
     */
    public Orientador getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }




     
     
}
