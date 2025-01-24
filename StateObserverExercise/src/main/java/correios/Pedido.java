package correios;

public class Pedido {
    private PedidoEstado estado;
    private Correios correios;

    public Pedido(PedidoEstado estadoInicial, Correios correios) {
        this.estado = estadoInicial;
        this.correios = correios;
        this.notificarEstado();
    }

    public void setEstado(PedidoEstado novoEstado) {
        this.estado = novoEstado;
        this.notificarEstado();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void avancar() {
        estado.avancar(this);
    }

    public String cancelar() {
        return estado.cancelar(this);
    }

    private void notificarEstado() {
        correios.setEstado(estado.descrever());
    }
}
