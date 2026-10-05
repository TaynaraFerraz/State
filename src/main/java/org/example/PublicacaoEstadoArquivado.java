package org.example;

public class PublicacaoEstadoArquivado extends  PublicacaoEstado {

    private PublicacaoEstadoArquivado() {};
    private static PublicacaoEstadoArquivado instance = new PublicacaoEstadoArquivado();
    public static PublicacaoEstadoArquivado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Publicacao arquivada";
    }
}
