package org.example;

public abstract class PublicacaoEstado {

    public abstract String getEstado();

    public boolean revisar(Publicacao publicacao) {
        return false;
    }

    public boolean publicar(Publicacao publicacao) {
        return false;
    }

    public boolean arquivar(Publicacao publicacao) {
        return false;
    }

    public boolean rascunho(Publicacao publicacao) {
        return false;
    }

}
