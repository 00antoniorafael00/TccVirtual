
package br.edu.ifrs.modelo;


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

     
     
   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   
    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    
    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    
    public String getAreaPrincipal() {
        return areaPrincipal;
    }

   
    public void setAreaPrincipal(String areaPrincipal) {
        this.areaPrincipal = areaPrincipal;
    }

    
    public String getAreaSecundaria() {
        return areaSecundaria;
    }

    
    public void setAreaSecundaria(String areaSecundaria) {
        this.areaSecundaria = areaSecundaria;
    }

   
    public String getResumo() {
        return resumo;
    }

    
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

   
    public String getSituacao() {
        return situacao;
    }

    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    public String getVersaoFinal() {
        return versaoFinal;
    }

    
    public void setVersaoFinal(String versaoFinal) {
        this.versaoFinal = versaoFinal;
    }

    
    public String getVersaoBanca() {
        return versaoBanca;
    }

   
    public void setVersaoBanca(String versaoBanca) {
        this.versaoBanca = versaoBanca;
    }

   
    public Estudante getAutor() {
        return autor;
    }

   
    public void setAutor(Estudante autor) {
        this.autor = autor;
    }

    
    public Orientador getOrientador() {
        return orientador;
    }

   
    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }




     
     
}
