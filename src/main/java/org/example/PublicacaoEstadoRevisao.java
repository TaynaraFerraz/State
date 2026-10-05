package org.example;

public class PublicacaoEstadoRevisao extends PublicacaoEstado{

    private PublicacaoEstadoRevisao() {};
    private static PublicacaoEstadoRevisao instance = new PublicacaoEstadoRevisao();
    public static PublicacaoEstadoRevisao getInstance() {
        return instance;
    }

    @Override
    public boolean publicar(Publicacao publicacao) {
        publicacao.setEstado(PublicacaoEstadoPublicado.getInstance());
        return true;
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
        return "Publicacao em revisao";
    }
}
