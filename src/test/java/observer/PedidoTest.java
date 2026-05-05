package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveNotificarClienteQuandoStatusMudar() {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente("João");

        pedido.adicionarObservador(cliente);
        pedido.setStatus("Hambúrguer em preparo");

        assertEquals(
                "João recebeu: Status do pedido: Hambúrguer em preparo",
                cliente.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarMaisDeUmCliente() {
        Pedido pedido = new Pedido();
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        pedido.adicionarObservador(cliente1);
        pedido.adicionarObservador(cliente2);

        pedido.setStatus("Pedido saiu para entrega");

        assertEquals("João recebeu: Status do pedido: Pedido saiu para entrega", cliente1.getUltimaNotificacao());
        assertEquals("Maria recebeu: Status do pedido: Pedido saiu para entrega", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteRemovido() {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente("João");

        pedido.adicionarObservador(cliente);
        pedido.removerObservador(cliente);

        pedido.setStatus("Pedido pronto");

        assertNull(cliente.getUltimaNotificacao());
    }
}
