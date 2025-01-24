package correios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ObserverTest {
    private Correios correios;
    private Comprador comprador1;
    private Comprador comprador2;

    @BeforeEach
    void setup() {
        correios = new Correios();
        comprador1 = new Comprador("João");
        comprador2 = new Comprador("Maria");

        comprador1.acompanharPedido(correios);
        comprador2.acompanharPedido(correios);
    }

    @Test
    void testNotificarApenasCompradoresMatriculados() {
        Comprador comprador3 = new Comprador("Carlos");
        correios.setEstado("Objeto Postado");

        assertEquals(null, comprador3.getUltimaNotificacao());
    }
    
    @Test
    void testNotificarCompradoresTodosEstados() {
        // Criar um pedido associado ao Correios
        Pedido pedido = new Pedido(new ObjetoPostado(), correios);

        // Avançar os estados do pedido
        pedido.avancar(); // Para "Objeto em Transferência"
        assertEquals("João, O pedido agora está no estado: Objeto em Transferência", comprador1.getUltimaNotificacao());
        assertEquals("Maria, O pedido agora está no estado: Objeto em Transferência", comprador2.getUltimaNotificacao());

        pedido.avancar(); // Para "Saiu para Entrega"
        assertEquals("João, O pedido agora está no estado: Saiu para Entrega", comprador1.getUltimaNotificacao());
        assertEquals("Maria, O pedido agora está no estado: Saiu para Entrega", comprador2.getUltimaNotificacao());

        pedido.avancar(); // Para "Entregue"
        assertEquals("João, O pedido agora está no estado: Entregue", comprador1.getUltimaNotificacao());
        assertEquals("Maria, O pedido agora está no estado: Entregue", comprador2.getUltimaNotificacao());
    }
}
