package correios;

class ObjetoEmTransferencia extends PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        pedido.setEstado(new SaiuParaEntrega());
    }
    
    @Override
    public String descrever() {
        return "Objeto em Transferência";
    }
}
