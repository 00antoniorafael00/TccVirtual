
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
      
      
    
    
     public static Banca[] consultar (Usuario usuario, String titulo, String curso) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        List<Banca> lista = new ArrayList();
        List<Professor> avaliadores = new ArrayList();
        
        try {       

            con = Conexao.abrirConexao();
            
            if (titulo != null){
                pstmt = con.prepareStatement("SELECT * FROM bancas b JOIN tccs t ON (b.tcc = t.id) WHERE t.titulo = ?");
                pstmt.setString(1, titulo);
            
            } else {
                pstmt = con.prepareStatement("SELECT * FROM bancas b JOIN tccs t ON (b.tcc = t.id) "
                        + "JOIN usuarios u ON (u.matricula = t.estudante) "
                        + "JOIN cursos c ON (u.id_curso = c.id) "
                        + "WHERE c.nome = ?");
                pstmt.setString(1, curso);
                
            }
            
                
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Banca b = new Banca();
                
                
                b.setId(rs.getInt("id"));
                
                Tcc tcc = new Tcc();
                
                b.setTcc(tcc.consultar(rs.getInt("tcc")));
                
                Calendar data = Calendar.getInstance();
                java.sql.Date dataDate = rs.getDate("data_banca");
                data.setTime(new java.util.Date(dataDate.getTime()));
                b.setDataBanca(data);
                
                
                Calendar hora = Calendar.getInstance();
                java.sql.Time horaTime = rs.getTime("horario_banca");
                hora.setTime(new java.util.Date(horaTime.getTime()));
                b.setHorarioBanca(hora);
               
                b.setModalidadeBanca(rs.getString("modalidade_banca"));
                
                b.setNumeroSala(rs.getInt("numero_sala"));               
                
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

    
    public static Banca consultar (int id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Banca b = new Banca();
        List<Professor> avaliadores = new ArrayList();
        
        try {       

            con = Conexao.abrirConexao();


            pstmt = con.prepareStatement("SELECT * FROM bancas  WHERE id = ?");
            pstmt.setInt(1, id);
                
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                
                b.setId(rs.getInt("id"));
                
                Tcc tcc = new Tcc();
                
                b.setTcc(tcc.consultar(rs.getInt("tcc")));
                
                Calendar data = Calendar.getInstance();
                java.sql.Date dataDate = rs.getDate("data_banca");
                data.setTime(new java.util.Date(dataDate.getTime()));
                b.setDataBanca(data);
                
                
                Calendar hora = Calendar.getInstance();
                java.sql.Time horaTime = rs.getTime("horario_banca");
                hora.setTime(new java.util.Date(horaTime.getTime()));
                b.setHorarioBanca(hora);
               
                b.setModalidadeBanca(rs.getString("modalidade_banca"));
                
                b.setNumeroSala(rs.getInt("numero_sala"));               
                
                b.setSituacao(rs.getString("situacao").charAt(0));
                
                b.setProfessoresBanca(consultarAvaliadores (b.getId()));
                             
                
            }
            
        } catch (Exception e) {
            throw new Exception("Falha ao consultar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        return b;
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
    
    
    public static Banca aprovarParticipacaoBanca (int id, Usuario avaliador, boolean aprova) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        Banca b = new Banca();
        
        
        try {       
            b = b.consultar (id);
            
            con = Conexao.abrirConexao();
            
            if (aprova == true){
                pstmt = con.prepareStatement("UPDATE avaliadores_banca SET participacao = true WHERE banca = ? AND professor = ?"); 
            } else {
                pstmt = con.prepareStatement("UPDATE avaliadores_banca SET participacao = false WHERE banca = ? AND professor = ?");
            }
            
            pstmt.setInt(1, id);
            pstmt.setInt(2, avaliador.getMatricula());  
            
            
            pstmt.execute();                            
                

            
        } catch (Exception e) {
            throw new Exception("Falha ao editar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        situacaoBanca(b);

        
        return b;
    }
    
    
    
    public static void situacaoBanca (Banca b) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ArrayList<Boolean> participacoes = new ArrayList();
        ResultSet rs;
        
        try {       
            
            con = Conexao.abrirConexao();
            
            pstmt = con.prepareStatement("SELECT participacao FROM avaliadores_banca WHERE banca = ?");
            pstmt.setInt(1, b.getId());
                
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Boolean participacao = rs.getBoolean("participacao");
                participacoes.add(participacao);         
                
            }                           
                
            
            
        } catch (Exception e) {
            throw new Exception("Falha ao consultar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        
        if (!participacoes.contains(false)){            // Se todos avaliadores aprovaram sua participação
           atualizaSituacao (b); 
        }

       
    }
    
    
    public static void atualizaSituacao (Banca b) throws Exception {        //atualizar o campo Situacao para Confirmada.
        Connection con = null;
        PreparedStatement pstmt = null;
                
        try {       
            
            con = Conexao.abrirConexao();
            
            pstmt = con.prepareStatement("UPDATE bancas SET situacao = 'C' WHERE id = ?"); 

            pstmt.setInt(1, b.getId());  
            
            
            pstmt.execute();                            
                
            
            
        } catch (Exception e) {
            throw new Exception("Falha ao editar o Banco de Dados.<br><!--" + e.getMessage() + "-->");
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        
        
        
    }

}