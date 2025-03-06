public class Pedido {

    private static int contadorId = 1;
    private int id;
    private double valorConta;
    private Cliente cliente;
    private StatusPedido statusPedido;

    public Pedido (Cliente cliente, double valorConta) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.valorConta = valorConta;
        this.statusPedido = StatusPedido.PENDENTE;
    }

    public int getId() {
        return id;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String toString() {
        return String.format("ID pedido: P%d | Cliente: %s | Valor Total R$%.2f | Status: %s", id, cliente.getNome(), valorConta, statusPedido);
    }

}
