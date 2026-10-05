package org.example;

public class PublicacaoEstadoPublicado extends PublicacaoEstado{

    private PublicacaoEstadoPublicado() {};
    private static PublicacaoEstadoPublicado instance = new PublicacaoEstadoPublicado();
    public static PublicacaoEstadoPublicado getInstance() {
        return instance;
    }

    @Override
    public boolean arquivar(Publicacao publicacao) {
        publicacao.setEstado(PublicacaoEstadoArquivado.getInstance());
        return true;
    }

    @Override
    public boolean rascunho(Publicacao publicacao) {
        publicacao.setEstado(PublicacaoEstadoRascunho.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Publicacao publicada";
    }
}
