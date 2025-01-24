package correios;

public abstract class PedidoEstado {
    public abstract void avancar(Pedido pedido);
    public  String cancelar(Pedido pedido) {
        return "Não é possível cancelar no estado '" + pedido.getEstado().descrever() + "'.";    
    }
    public abstract String descrever();
}