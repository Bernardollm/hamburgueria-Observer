package observer;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String status;
    private List<ClienteObserver> observadores = new ArrayList<>();

    public Pedido() {
        this.status = "Pedido recebido";
    }

    public void adicionarObservador(ClienteObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(ClienteObserver observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (ClienteObserver observador : observadores) {
            observador.atualizar("Status do pedido: " + status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notificarObservadores();
    }

    public String getStatus() {
        return status;
    }
}
