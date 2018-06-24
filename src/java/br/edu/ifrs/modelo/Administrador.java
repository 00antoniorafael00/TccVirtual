
package br.edu.ifrs.modelo;

public class Administrador extends Usuario{

    public Administrador(Usuario u) {
        super(u.getMatricula(), u.getNome(),u.getSexo(), u.getEnderecoResidencial(), u.getEmail(), u.getTelefoneResidencial(),
                 u.getTelefoneProfissional(), u.getTelefoneCelular(), u.getSenha(), u.getSituacao(), u.getObservacoes(), u.getCurso()
        );
                
                
    }
    

    
}
