package correios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoEstadoTest {
    private Pedido pedido;
    private Correios correios;

    @BeforeEach
    void setup() {
        correios = new Correios();
        pedido = new Pedido(new ObjetoPostado(), correios);
    }
    
    @AfterEach
    void teardown() {
    	correios = null;
    	pedido = null;
    }

    @Test
    void testAvancarEstado() {
        assertEquals("Objeto Postado", pedido.getEstado().descrever());
        pedido.avancar();
        assertEquals("Objeto em Transferência", pedido.getEstado().descrever());
        pedido.avancar();
        assertEquals("Saiu para Entrega", pedido.getEstado().descrever());
        pedido.avancar();
        assertEquals("Entregue", pedido.getEstado().descrever());
    }

    @Test
    void testCancelarObjetoPostado() {
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstado().descrever());
    }

    @Test
    void testNaoCancelarObjetoEmTransferencia() {
        pedido.avancar();
        assertEquals("Não é possível cancelar no estado 'Objeto em Transferência'.", pedido.cancelar());
        assertEquals("Objeto em Transferência", pedido.getEstado().descrever());
    }
}

