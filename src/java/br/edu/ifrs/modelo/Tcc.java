
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tcc {
     private int id;
     private String titulo;
     private String palavrasChaves;
     private String areaPrincipal; 
     private String areaSecundaria;
     private String resumo;
     private char situacao;
     private boolean versaoFinal;
     private boolean versaoBanca;
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

   
    public char getSituacao() {
        return situacao;
    }

    
    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    
    public boolean isVersaoFinal() {
        return versaoFinal;
    }
    public void setVersaoFinal(boolean versaoFinal) {
        this.versaoFinal = versaoFinal;
    }

    public boolean isVersaoBanca() {
        return versaoBanca;
    }
    public void setVersaoBanca(boolean versaoBanca) {
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



    public static Tcc consultar (int id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Tcc t = new Tcc();
        
        try {       

            con = Conexao.abrirConexao();


            pstmt = con.prepareStatement("SELECT * FROM tccs WHERE id = ?");
            pstmt.setInt(1, id);
                
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                                
                t.setId(rs.getInt("id"));
                t.setTitulo(rs.getString("titulo"));
                t.setPalavrasChaves(rs.getString("palavras_chaves"));
                t.setAreaPrincipal(rs.getString("area_principal"));
                t.setAreaSecundaria(rs.getString("area_secundaria"));
                t.setResumo(rs.getString("resumo"));
                t.setSituacao(rs.getString("situacao").charAt(0));
                t.setVersaoFinal(rs.getBoolean("versao_final"));
                t.setVersaoBanca(rs.getBoolean("versao_banca"));
                
                Usuario autor = new Usuario();                
                autor = autor.pesquisar(rs.getInt("estudante")); 
                t.setAutor( new Estudante(autor) );  
                
                Usuario orientador = new Usuario();                
                orientador = orientador.pesquisar(rs.getInt("orientador")); 
                t.setOrientador( new Orientador( new Professor(orientador) ) );
                                
                
                
                
            }
            
        } catch (Exception e) {
            throw new Exception("Falha ao consultar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        return t;
    }

 
}
