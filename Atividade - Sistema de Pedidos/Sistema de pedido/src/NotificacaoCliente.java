public class NotificacaoCliente {

    private Notificador notificador;

    public NotificacaoCliente(Notificador notificador) {
        this.notificador = notificador;
    }

    public void mandarNotificacao(String mensagem) {
        notificador.mandarNotificacao(mensagem);
    }
}
