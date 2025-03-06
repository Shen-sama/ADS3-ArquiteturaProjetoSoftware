public class CalculadoraDesconto {

    private DescontoStrategy descontoStrategy;

    public CalculadoraDesconto(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public double aplicarDesconto(double valor) {
        return descontoStrategy.descontoCliente(valor);
    }
}
