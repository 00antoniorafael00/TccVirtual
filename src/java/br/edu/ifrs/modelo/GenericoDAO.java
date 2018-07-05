/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author ubunto
 */
public class GenericoDAO extends Conexao {


    public GenericoDAO() throws Exception {
    }

    public ArrayList<Tcc> selecionarTccs() throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Curso c = null;
        ArrayList<Tcc> listaTcc = new ArrayList<>();
        try {
            pstmt = abrirConexao().prepareStatement("SELECT * FROM tccs");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Tcc tcc = new Tcc();
                tcc.setId(rs.getInt("id"));
                tcc.setTitulo(rs.getString("titulo"));
                listaTcc.add(tcc);
            }

        } catch (Exception ex) {
            throw new Exception("Falha ao autenticar o usuário no Banco de Dados.<br><!--" + ex.getMessage() + "-->");
        }
        return listaTcc;
    }

    public String salvar(String[] professores,String id,String titulo,String autor,String orientador,String dataBanca,String horarioBanca, String modalidade,String sala) throws Exception {
        int idGerado = 0;
        try {
            PreparedStatement st = abrirConexao().prepareStatement("insert into bancas "                 
                    + "(id,tcc, data_banca, horario_banca, modalidade_banca, numero_sala, situacao) "                    
                    + "values (null,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date data = new java.sql.Date(fmt.parse(dataBanca).getTime());
            st.setInt(1, Integer.parseInt(id));
            st.setDate(2, data);
            st.setString(3,horarioBanca);
            st.setString(4,modalidade);
            st.setInt(5, Integer.parseInt(sala));
            st.setString(6, "A");
            st.executeUpdate();
            
            ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
            
            for (String matriculaProfessor:  professores){
                tornaAvaliador(Integer.parseInt(matriculaProfessor), idGerado);
            }
            

        } catch (Exception ex) {            
        }
        
        return professores[0];
    }
    
    public void tornaAvaliador(int matriculaProfessor, int idBanca) throws Exception {  
        try {
            PreparedStatement st = abrirConexao().prepareStatement("insert into avaliadores_banca (banca, professor, participacao) values (?,?,?)");
            
            st.setInt(1, idBanca);
            st.setInt(2, matriculaProfessor);      
            st.setBoolean(3, false);
            st.executeUpdate();
                      
        } catch (Exception ex) {            
        }

    }
    
        

    public ArrayList<String> selecionaOrientadoreEstudante(int id) throws Exception {
        ArrayList<String> listaTcc = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Curso c = null;
        try {
            pstmt = abrirConexao().prepareStatement("select u.nome From usuarios as u inner join tccs as c on u.matricula=c.orientador Where id=? \n"
                    + "union \n"
                    + "select u.nome From usuarios as u inner join tccs as c on u.matricula=c.estudante Where id=?;");
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                listaTcc.add(rs.getString("nome"));
            }
            listaTcc.add(retornaTitulo(id));
        } catch (Exception ex) {
            throw new Exception("Falha ao autenticar o usuário no Banco de Dados.<br><!--" + ex.getMessage() + "-->");
        }
        return listaTcc;
    }

    private String retornaTitulo(int id) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Curso c = null;
        String resposta = "";
        try {

            pstmt = abrirConexao().prepareStatement("SELECT titulo FROM tccs Where id=?;");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Tcc tcc = new Tcc();
                resposta = rs.getString("titulo");
            }

        } catch (Exception ex) {
            throw new Exception("Falha ao autenticar o usuário no Banco de Dados.<br><!--" + ex.getMessage() + "-->");
        }
        return resposta;
    }

    public ArrayList<Professor> selecionaProfessores() throws Exception {
        ArrayList<Professor> professores = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Curso c = null;
        try {
            pstmt = abrirConexao().prepareStatement("SELECT * FROM tcc_virtual.usuarios Where perfil='PROFESSOR' OR perfil='COORDENADOR';");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setMatricula(rs.getInt("matricula"));
                u.setNome(rs.getString("nome"));    
                
                Professor prof = new Professor(u);              
                
                professores.add(prof);
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao autenticar o usuário no Banco de Dados.<br><!--" + ex.getMessage() + "-->");
        }
        return professores;
    }
    
    
     private String retornaProfessor(int id) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Curso c = null;
        String resposta = "";
        try {

            pstmt = abrirConexao().prepareStatement("SELECT * FROM tcc_virtual.usuarios Where perfil='PROFESSOR';");;
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Tcc tcc = new Tcc();
                resposta = rs.getString("PROFESSOR");
            }

        } catch (Exception ex) {
            throw new Exception("Falha ao autenticar o usuário no Banco de Dados.<br><!--" + ex.getMessage() + "-->");
        }
        return resposta;
    }
    
    

    
}
