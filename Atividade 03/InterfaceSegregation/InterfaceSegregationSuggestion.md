## Problema Encontrado
O código problema tem uma interface chamada Machine que faz muitas funções distintas, o que dificulta a reutilização e modulação do código, tendo assim um design ruim.
## Sugestão para o Problema
Para melhorar o design do código, é desejável aplicar o princípio de segregação de interface, para que cada interface possa ser reutilizada e aplicada sem a necessidade de modificação ou provocar excesso. Para isso, basta separar a interface Machine em Printer, Scanner e Faxer, cada uma tendo suas respectivas funções e implementá-las na classe da Impressora de Multi-função de acordo com o que ela consegue fazer.
## Código Problema
```java
public class InterfaceSegregationViolation {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print();
        printer.scan();
        printer.fax();
    }
}

interface Machine {
    void print();
    void scan();
    void fax();
}

class MultiFunctionPrinter implements Machine {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }

    public void fax() {
        System.out.println("Faxing...");
    }
}
```
## Código Solução
```java
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
```
