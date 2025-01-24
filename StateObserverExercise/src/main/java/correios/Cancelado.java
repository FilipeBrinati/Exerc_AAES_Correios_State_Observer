package correios;

class Cancelado extends PedidoEstado {
    @Override
    public void avancar(Pedido pedido) {
        System.out.println("O pedido foi cancelado e não pode avançar.");
    }
    
    @Override
    public String descrever() {
        return "Cancelado";
    }
}