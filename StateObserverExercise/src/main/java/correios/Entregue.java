package correios;

class Entregue extends PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        System.out.println("O pedido já foi entregue.");
    }

    @Override
    public String descrever() {
        return "Entregue";
    }
}