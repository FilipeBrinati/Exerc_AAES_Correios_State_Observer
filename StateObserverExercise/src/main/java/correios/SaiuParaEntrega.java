package correios;

class SaiuParaEntrega extends PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        pedido.setEstado(new Entregue());
    }

    @Override
    public String descrever() {
        return "Saiu para Entrega";
    }
}