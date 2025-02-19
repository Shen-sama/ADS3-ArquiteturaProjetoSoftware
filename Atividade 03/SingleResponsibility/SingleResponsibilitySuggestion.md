## Problema Encontrado
A classe Invoice viola o princípio de responsabilidade única quando ela faz várias funções distintas, aumentando assim suas razões para mudar, o que dificulta o isolamento de problemas quando os requisitos do projeto acabam mudando, e a modificação demora mais para acontecer.
## Sugestão para o Problema
Para resolver esse problema é necessário que a classe Invoice seja dividida para que cada uma tenha apenas uma função. Assim a classe Invoice ficaria encarregada de carregar a sua quantia, uma nova classe InvoicePrinter para carregar a função de imprimir e uma última classe InvoiceDatabase para carregar a função de salvar no banco de dados. Aplicando assim o conceito de responsabilidade única.
## Código Problema
```java
public class SingleResponsibilityViolation {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000);
        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}

class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public void printInvoice() {
        System.out.println("Invoice amount: " + amount);
    }

    public void saveToDatabase() {
        System.out.println("Saving invoice to database...");
    }
}
```
## Código Solução
```java
public class SingleResponsibilitySolution
{
    public static void main(String[] args)
    {
        Invoice invoice = new Invoice(1000);
        InvoicePrinter invoicePrinter = new InvoicePrinter();
        InvoiceDatabase invoiceDatabase = new InvoiceDatabase();

        invoicePrinter.printInvoice(invoice);
        invoiceDatabase.saveToDatabase(invoice);
    }

}

class Invoice
{
    private double amount;

    public Invoice(double amount)
    {
        this.amount = amount;
    }

    public double getAmount()
    {
        return amount;
    }
}

class InvoicePrinter
{
    public void printInvoice(Invoice invoice)
    {
        System.out.println("Invoice amount: " + invoice.getAmount());
    }
}

class InvoiceDatabase
{
    public void saveToDatabase(Invoice invoice)
    {
        System.out.println("Saving invoice to database...");
    }
}
```
