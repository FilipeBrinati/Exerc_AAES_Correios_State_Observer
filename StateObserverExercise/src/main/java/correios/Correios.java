package correios;

import java.util.Observable;

public class Correios extends Observable {
    private String estadoAtual;

    public void setEstado(String novoEstado) {
        this.estadoAtual = novoEstado;
        setChanged();
        notifyObservers("O pedido agora está no estado: " + novoEstado);
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }
}
