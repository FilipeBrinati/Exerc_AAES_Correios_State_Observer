package correios;

import java.util.Observable;
import java.util.Observer;

public class Comprador implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Comprador(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void acompanharPedido(Correios correios) {
        correios.addObserver(this);
    }

    @Override
    public void update(Observable correios, Object arg) {
        if (arg instanceof String) {
            ultimaNotificacao = nome + ", " + arg;
        } else {
            ultimaNotificacao = nome + ", o status do pedido foi atualizado.";
        }
        System.out.println(ultimaNotificacao);
    }
}
