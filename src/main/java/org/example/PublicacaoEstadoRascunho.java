package org.example;

public class PublicacaoEstadoRascunho extends PublicacaoEstado {

    private PublicacaoEstadoRascunho() {};
    private static PublicacaoEstadoRascunho instance = new PublicacaoEstadoRascunho();
    public static PublicacaoEstadoRascunho getInstance() {
        return instance;
    }

    @Override
    public boolean revisar(Publicacao publicacao) {
        publicacao.setEstado(PublicacaoEstadoRevisao.getInstance());
        return true;
    }

    @Override
    public boolean arquivar(Publicacao publicacao) {
        publicacao.setEstado(PublicacaoEstadoArquivado.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Publicacao em rascunho";
    }
}
