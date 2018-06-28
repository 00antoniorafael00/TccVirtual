
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Curso {
      private int id;
      private String nome;
      private String descricao;
      private int periodoIntegralizacao;
      private int cargaHoraria;
      private char situacao;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPeriodoIntegralizacao() {
        return periodoIntegralizacao;
    }
    public void setPeriodoIntegralizacao(int periodoIntegralizacao) {
        this.periodoIntegralizacao = periodoIntegralizacao;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public char getSituacao() {
        return situacao;
    }
    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

      
      
    
    public static Curso consultar (int id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Curso c = new Curso();
        
        try {
            try {
                con = Conexao.abrirConexao();

                
                pstmt = con.prepareStatement("select * from cursos where id = ?");
                pstmt.setInt(1, id);
                
            
                rs = pstmt.executeQuery();
                if (rs.next() == true) {
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setDescricao(rs.getString("descricao"));
                    c.setPeriodoIntegralizacao(rs.getInt("periodo_integralizacao"));
                    c.setCargaHoraria(rs.getInt("carga_horaria"));
                    c.setSituacao(rs.getString("situacao").charAt(0));   
                                        
                }
            } catch (Exception e) {
                throw new Exception("Falha ao consultar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return c;   //retorna curso
    }
    
       
}

