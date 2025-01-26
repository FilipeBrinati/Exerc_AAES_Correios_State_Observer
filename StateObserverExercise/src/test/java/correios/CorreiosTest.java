package correios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CorreiosTest {

    private Correios correios;
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        correios = new Correios();
    }

    @Test
    void testSetEstado() {
        correios.setEstado("Objeto Postado");
        assertEquals("Objeto Postado", correios.getEstadoAtual());
    }

    @Test
    void testNotificacaoParaComprador() {
        Comprador comprador = new Comprador("João");
        comprador.acompanharPedido(correios);

        correios.setEstado("Saiu para Entrega");
        assertEquals("João, O pedido agora está no estado: Saiu para Entrega", comprador.getUltimaNotificacao());
    }
    @Test
    void testObjetoPostadoAvancar() {
        PedidoEstado estadoInicial = new ObjetoPostado();
        pedido = new Pedido(estadoInicial, correios);

        pedido.avancar();
        assertTrue(pedido.getEstado() instanceof ObjetoEmTransferencia);
        assertEquals("Objeto em Transferência", correios.getEstadoAtual());
    }

    @Test
    void testObjetoPostadoCancelar() {
        PedidoEstado estadoInicial = new ObjetoPostado();
        pedido = new Pedido(estadoInicial, correios);

        String resultado = pedido.cancelar();
        assertEquals("Cancelado", resultado);
        assertTrue(pedido.getEstado() instanceof Cancelado);
    }

    @Test
    void testObjetoEmTransferenciaAvancar() {
        PedidoEstado estadoInicial = new ObjetoEmTransferencia();
        pedido = new Pedido(estadoInicial, correios);

        pedido.avancar();
        assertTrue(pedido.getEstado() instanceof SaiuParaEntrega);
        assertEquals("Saiu para Entrega", correios.getEstadoAtual());
    }

    @Test
    void testSaiuParaEntregaAvancar() {
        PedidoEstado estadoInicial = new SaiuParaEntrega();
        pedido = new Pedido(estadoInicial, correios);

        pedido.avancar();
        assertTrue(pedido.getEstado() instanceof Entregue);
        assertEquals("Entregue", correios.getEstadoAtual());
    }

    @Test
    void testEntregueAvancar() {
        PedidoEstado estadoInicial = new Entregue();
        pedido = new Pedido(estadoInicial, correios);

        pedido.avancar();
        assertTrue(pedido.getEstado() instanceof Entregue); // Estado permanece o mesmo
        assertEquals("Entregue", correios.getEstadoAtual());
    }

    @Test
    void testCancelarNaoPermitido() {
        PedidoEstado estadoInicial = new Entregue();
        pedido = new Pedido(estadoInicial, correios);

        String resultado = pedido.cancelar();
        assertEquals("Não é possível cancelar no estado 'Entregue'.", resultado);
    }

    @Test
    void testCanceladoAvancar() {
        PedidoEstado estadoInicial = new Cancelado();
        pedido = new Pedido(estadoInicial, correios);

        pedido.avancar();
        assertTrue(pedido.getEstado() instanceof Cancelado); // Estado permanece o mesmo
        assertEquals("Cancelado", correios.getEstadoAtual());
    }

}
