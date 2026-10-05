package org.example;

public class Publicacao {

    private String nome;
    private PublicacaoEstado estado;

    public Publicacao() {
        this.estado = PublicacaoEstadoRascunho.getInstance();
    }

    public void setEstado(PublicacaoEstado estado) {
        this.estado = estado;
    }

    public boolean revisar() {
        return estado.revisar(this);
    }

    public boolean publicar() {
        return estado.publicar(this);
    }

    public boolean arquivar() {
        return estado.arquivar(this);
    }

    public boolean emRascunho() {
        return estado.rascunho(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PublicacaoEstado getEstado() {
        return estado;
    }
}
