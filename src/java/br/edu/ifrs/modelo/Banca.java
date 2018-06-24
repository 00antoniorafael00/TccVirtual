
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class Banca {
      private int id;
      private Calendar dataBanca;  
      private Calendar horarioBanca; 
      private String modalidadeBanca;
      private int numeroSala;
      private char situacao;
      private Tcc tcc;
      private List<Professor> professoresBanca;
      

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }


    public Calendar getDataBanca() {
        return dataBanca;
    }

    public void setDataBanca(Calendar dataBanca) {
        this.dataBanca = dataBanca;
    }

    
    public Calendar getHorarioBanca() {
        return horarioBanca;
    }

    
    public void setHorarioBanca(Calendar horarioBanca) {
        this.horarioBanca = horarioBanca;
    }

    
    public String getModalidadeBanca() {
        return modalidadeBanca;
    }

    
    public void setModalidadeBanca(String modalidadeBanca) {
        this.modalidadeBanca = modalidadeBanca;
    }

   
    public int getNumeroSala() {
        return numeroSala;
    }

    
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public char getSituacao() {
        return situacao;
    }
    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

   
    public Tcc getTcc() {
        return tcc;
    }

    
    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }

    
    public List<Professor> getProfessoresBanca() {
        return professoresBanca;
    }

    
    public void setProfessoresBanca(List<Professor> professoresBanca) {
        this.professoresBanca = professoresBanca;
    }
      
      
    
    
    public static Banca[] consultar (Usuario usuario) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        List<Banca> lista = new ArrayList();
        List<Professor> avaliadores = new ArrayList();
        
        try {       

            con = Conexao.abrirConexao();


            pstmt = con.prepareStatement("SELECT * FROM bancas");

                
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Banca b = new Banca();

                b.setId(rs.getInt("id"));
                b.setSituacao(rs.getString("situacao").charAt(0));
                b.setProfessoresBanca(consultarAvaliadores (b.getId()));
                              

                lista.add(b);
                
            }
            
        } catch (Exception e) {
            throw new Exception("Falha ao consultar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        return lista.toArray(new Banca[0]);
    }

    
    
    public static List<Professor> consultarAvaliadores (int id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        List<Professor> lista = new ArrayList();
   
        
        try {       

            con = Conexao.abrirConexao();


            pstmt = con.prepareStatement("SELECT * FROM avaliadores_banca WHERE banca = ?");
            pstmt.setInt(1, id);
                
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setMatricula(rs.getInt("professor"));
           
                Professor p = new Professor(u);
        
                lista.add(p);
                
            }
            
        } catch (Exception e) {
            throw new Exception("Falha ao consultar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        return lista;
    }




}
