
package br.edu.ifrs.modelo;

import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Usuario {
      private int matricula;
      private String nome;
      private char sexo;
      private String enderecoResidencial;
      private String email;
      private String telefoneResidencial;
      private String telefoneProfissional;
      private String telefoneCelular;
      private String senha;
      private char situacao;      
      private String observacoes;
      private Curso curso;

    public Usuario() {
    }

      
    public Usuario(int matricula, String nome, char sexo, String enderecoResidencial, String email, String telefoneResidencial, String telefoneProfissional, String telefoneCelular, String senha, char situacao, String observacoes, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
        this.enderecoResidencial = enderecoResidencial;
        this.email = email;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneProfissional = telefoneProfissional;
        this.telefoneCelular = telefoneCelular;
        this.senha = senha;
        this.situacao = situacao;        
        this.observacoes = observacoes;
        this.curso = curso;
    }

  
 
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEnderecoResidencial() {
        return enderecoResidencial;
    }
    public void setEnderecoResidencial(String enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }
    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneProfissional() {
        return telefoneProfissional;
    }
    public void setTelefoneProfissional(String telefoneProfissional) {
        this.telefoneProfissional = telefoneProfissional;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getSituacao() {
        return situacao;
    }
    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    public static Usuario autenticar(int matricula, String senha) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario u = null;
        String perfil = "";
        Curso c = null;
        try {
           
                con = Conexao.abrirConexao();

          
                pstmt = con.prepareStatement("SELECT * FROM usuarios WHERE matricula = ? AND senha = ?");
                pstmt.setInt(1, matricula);
                pstmt.setString(2, senha);
                
               
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    u = new Usuario();

                    u.setMatricula(rs.getInt("matricula"));
                    u.setNome(rs.getString("nome"));
                    u.setSexo(rs.getString("sexo").charAt(0));
                    u.setEnderecoResidencial(rs.getString("endereco_residencial"));
                    u.setEmail(rs.getString("email"));
                    u.setTelefoneResidencial(rs.getString("telefone_residencial"));
                    u.setTelefoneProfissional(rs.getString("telefone_profissional"));
                    u.setTelefoneCelular(rs.getString("telefone_celular"));
                    u.setSenha(rs.getString("senha"));
                    u.setSituacao(rs.getString("situacao").charAt(0));
                    u.setObservacoes(rs.getString("observacoes"));

                    c = new Curso();
                    c = c.consultar(rs.getInt("id_curso"));                    
                    u.setCurso(c);
                    
                    perfil = rs.getString("perfil");
                    
                   
            
                }
            } catch (Exception e) {
                throw new Exception("Falha ao autenticar o usuário no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        
            if(perfil.equalsIgnoreCase("ADMINISTRADOR"))
                return new Administrador(u);
            else if (perfil.equalsIgnoreCase("PROFESSOR"))
                return new Professor(u);
            else if (perfil.equalsIgnoreCase("ESTUDANTE"))
                return new Estudante(u);
            else if (perfil.equalsIgnoreCase("COORDENADOR"))
                return new Coordenador(new Professor(u));
            else
                throw new Exception("Perfil de usuário não encontrado");


    }

}