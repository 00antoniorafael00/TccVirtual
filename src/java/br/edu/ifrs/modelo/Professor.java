
package br.edu.ifrs.modelo;


public class Professor extends Usuario{

    public Professor(Usuario u) {
        super(u.getMatricula(), u.getNome(),u.getSexo(), u.getEnderecoResidencial(), u.getEmail(), u.getTelefoneResidencial(),
                 u.getTelefoneProfissional(), u.getTelefoneCelular(), u.getSenha(), u.getSituacao(), u.getObservacoes(), u.getCurso()
        );
    }
    
    
    
}
