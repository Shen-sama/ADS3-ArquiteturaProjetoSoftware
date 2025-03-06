public class DescontoClienteComum implements DescontoStrategy {

    @Override
    public double descontoCliente(double valor) {
        return valor * 0.95;
    }
    
}
