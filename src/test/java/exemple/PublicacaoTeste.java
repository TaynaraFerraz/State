package exemple;

import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PublicacaoTeste {

    private Publicacao publicacao;

    @BeforeEach
    public void setUp() {
        publicacao = new Publicacao();
    }

    // 1. ESTADO: RASCUNHO

    @Test
    public void deveRevisarPublicacaoRascunho() {
        publicacao.setEstado(PublicacaoEstadoRascunho.getInstance());
        assertTrue(publicacao.revisar());
        Assertions.assertEquals(PublicacaoEstadoRevisao.getInstance(), publicacao.getEstado());
    }

    @Test
    public void deveArquivarPublicacaoRascunho() {
        publicacao.setEstado(PublicacaoEstadoRascunho.getInstance());
        assertTrue(publicacao.arquivar());
        Assertions.assertEquals(PublicacaoEstadoArquivado.getInstance(), publicacao.getEstado());
    }

    @Test
    public void naoDevePublicarPublicacaoRascunho() {
        publicacao.setEstado(PublicacaoEstadoRascunho.getInstance());
        assertFalse(publicacao.publicar());
    }

    @Test
    public void naoDeveVoltarRascunhoPublicacaoRascunho() {
        publicacao.setEstado(PublicacaoEstadoRascunho.getInstance());
        assertFalse(publicacao.emRascunho());
    }


    // =========================================================================
    // 2. ESTADO: REVISÃO
    // =========================================================================

    @Test
    public void devePublicarPublicacaoRevisao() {
        publicacao.setEstado(PublicacaoEstadoRevisao.getInstance());
        assertTrue(publicacao.publicar());
        Assertions.assertEquals(PublicacaoEstadoPublicado.getInstance(), publicacao.getEstado());
    }

    @Test
    public void deveVoltarRascunhoPublicacaoRevisao() {
        publicacao.setEstado(PublicacaoEstadoRevisao.getInstance());
        assertTrue(publicacao.emRascunho());
        assertEquals(PublicacaoEstadoRascunho.getInstance(), publicacao.getEstado());
    }

    @Test
    public void deveArquivarPublicacaoRevisao() {
        publicacao.setEstado(PublicacaoEstadoRevisao.getInstance());
        assertTrue(publicacao.arquivar());
        assertEquals(PublicacaoEstadoArquivado.getInstance(), publicacao.getEstado());
    }

    @Test
    public void naoDeveRevisarPublicacaoRevisao() {
        publicacao.setEstado(PublicacaoEstadoRevisao.getInstance());
        assertFalse(publicacao.revisar());
    }

    // 3. ESTADO: PUBLICADO

    @Test
    public void deveVoltarRascunhoPublicacaoPublicado() {
        publicacao.setEstado(PublicacaoEstadoPublicado.getInstance());
        assertTrue(publicacao.emRascunho());
        assertEquals(PublicacaoEstadoRascunho.getInstance(), publicacao.getEstado());
    }

    @Test
    public void deveArquivarPublicacaoPublicado() {
        publicacao.setEstado(PublicacaoEstadoPublicado.getInstance());
        assertTrue(publicacao.arquivar());
        assertEquals(PublicacaoEstadoArquivado.getInstance(), publicacao.getEstado());
    }

    @Test
    public void naoDeveRevisarPublicacaoPublicado() {
        publicacao.setEstado(PublicacaoEstadoPublicado.getInstance());
        assertFalse(publicacao.revisar());
    }

    @Test
    public void naoDevePublicarPublicacaoPublicado() {
        publicacao.setEstado(PublicacaoEstadoPublicado.getInstance());
        assertFalse(publicacao.publicar());
    }

    // 4. ESTADO: ARQUIVADO (Estado Final)

    @Test
    public void naoDeveRevisarPublicacaoArquivada() {
        publicacao.setEstado(PublicacaoEstadoArquivado.getInstance());
        assertFalse(publicacao.revisar());
    }

    @Test
    public void naoDevePublicarPublicacaoArquivada() {
        publicacao.setEstado(PublicacaoEstadoArquivado.getInstance());
        assertFalse(publicacao.publicar());
    }

    @Test
    public void naoDeveVoltarRascunhoPublicacaoArquivada() {
        publicacao.setEstado(PublicacaoEstadoArquivado.getInstance());
        assertFalse(publicacao.emRascunho());
    }

    @Test
    public void naoDeveArquivarPublicacaoJaArquivada() {
        publicacao.setEstado(PublicacaoEstadoArquivado.getInstance());
        assertFalse(publicacao.arquivar());
    }
}