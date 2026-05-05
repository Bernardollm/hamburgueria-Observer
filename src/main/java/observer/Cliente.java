package observer;

public class Cliente implements ClienteObserver {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        this.ultimaNotificacao = nome + " recebeu: " + mensagem;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}
