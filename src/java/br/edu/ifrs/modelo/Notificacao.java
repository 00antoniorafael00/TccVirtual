
package br.edu.ifrs.modelo;


public class Notificacao {
      private int id;
      private int usuarioOrigem;
      private int usuarioDestino;
      private String mensagem;
      private Usuario origem;
      private Usuario destino;
      private Tcc tcc;

   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public int getUsuarioOrigem() {
        return usuarioOrigem;
    }

   
    public void setUsuarioOrigem(int usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

   
    public int getUsuarioDestino() {
        return usuarioDestino;
    }

    
    public void setUsuarioDestino(int usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }


   
    public String getMensagem() {
        return mensagem;
    }

   
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

   
    public Usuario getOrigem() {
        return origem;
    }

   
    public void setOrigem(Usuario origem) {
        this.origem = origem;
    }


    public Usuario getDestino() {
        return destino;
    }

    
    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

   
    public Tcc getTcc() {
        return tcc;
    }

    
    public void setTcc(Tcc tcc) {
        this.tcc = tcc;
    }
      
      
}
