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
