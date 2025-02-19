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

