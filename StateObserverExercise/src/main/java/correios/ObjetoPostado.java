package correios;

class ObjetoPostado extends PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        pedido.setEstado(new ObjetoEmTransferencia());
    }

    @Override
    public String cancelar(Pedido pedido) {
        pedido.setEstado(new Cancelado());
        return pedido.getEstado().descrever();
    }

    @Override
    public String descrever() {
        return "Objeto Postado";
    }
}