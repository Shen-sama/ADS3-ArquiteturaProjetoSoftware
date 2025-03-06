public class SMSNotificador implements Notificador {

    @Override
    public void mandarNotificacao(String mensagem) {
        System.out.println("Enviando sms: \n" + mensagem);
    }

}
