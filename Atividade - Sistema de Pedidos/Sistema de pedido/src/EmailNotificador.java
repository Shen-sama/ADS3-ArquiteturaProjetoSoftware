public class EmailNotificador implements Notificador {

    @Override
    public void mandarNotificacao(String mensagem) {
        System.out.println("Enviando e-mail: \n" + mensagem);
    }

}
