public class InterfaceSegregationSolution
{
    public static void main(String[] args)
    {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();

        printer.print();
        printer.scan();
        printer.fax();
    }
}

interface Printer
{
    public void print();
}

interface Scanner
{
    public void scan();
}

interface Faxer
{
    public void fax();
}

class MultiFunctionPrinter implements Printer, Scanner, Faxer
{
    @Override
    public void fax()
    {
        System.out.println("Faxing...");
    }

    @Override
    public void print()
    {
        System.out.println("Printing...");
    }

    @Override
    public void scan()
    {
        System.out.println("Scanning...");
    }
}
