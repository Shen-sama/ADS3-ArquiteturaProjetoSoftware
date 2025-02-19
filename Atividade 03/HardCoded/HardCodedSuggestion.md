## Problema Encontrado
Por mais que o código funcione, do jeito que o relatório está sendo gerado faz com que caso existam outros tipos de saída além de PDF o código deveria ser totalmente alterado para ter uma maior modularidade.
## Sugestão para o Problema
Para deixar o código mais reutilizável e modular, é desejável que se aplique o Princípio da Responsabilidade Única, uma vez que a classe Report que deveria apenas abrigar informações sobre o relatório está gerando ele, tendo mais de uma função, e também o Princípio da Inversão de Dependência, já que a classe de relatório está dependendo diretamente de um tipo de saída de relatório (PDF), que deveria ser menor que a classe Report.

Para aplicar esses princípios, deve-se criar uma interface para a geração do relatório, e a partir dessa interface a criação de classes que a implementar, cada uma sendo um tipo de saídade de relatório, como PDF. A classe relatório teria um atributo de geração de relatório que seria atribuído em seu construtor para que um método seja chamado a partir desse atributo para gerar o relatório.
## Código Problema
```java
public class HardCodedDependencies {
    public static void main(String[] args) {
        Report report = new Report();
        report.generatePDFReport();
    }
}

class Report {
    public void generatePDFReport() {
        System.out.println("Generating PDF Report...");
    }
}
```
## Código Solução
```java
public class HardCodedSolution
{
    public static void main(String[] args)
    {
        ReportGenerator reportGenerator = new PDFReportGenerator();
        Report report = new Report(reportGenerator);

        report.generate();
    }
}

interface ReportGenerator
{
    public void generate();
}

class PDFReportGenerator implements ReportGenerator
{
    @Override
    public void generate()
    {
        System.out.println("Generating PDF Report...");
    }
}

class Report
{
    private ReportGenerator reportGenerator;

    public Report(ReportGenerator reportGenerator)
    {
        this.reportGenerator = reportGenerator;
    }

    public void generate()
    {
        reportGenerator.generate();
    }
}
```
