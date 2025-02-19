public class GodClassSolution
{
    public static void main(String[] args)
    {
        Application app = new Application();
        app.run();
    }
}

class UserAuthenticator
{
    public void authenticateUser()
    {
        System.out.println("Authenticating user...");
    }
}

class DashboardLoader
{
    public void loadDashboard()
    {
        System.out.println("Loading dashboard...");
    }
}

class PaymentProcessor
{
    public void processPayments()
    {
        System.out.println("Processing payments...");
    }
}

class ReportGenerator
{
    public void generateReports()
    {
        System.out.println("Generating reports...");
    }
}

class Application
{
    private UserAuthenticator userAuthenticator;
    private DashboardLoader dashboardLoader;
    private PaymentProcessor paymentProcessor;
    private ReportGenerator reportGenerator;

    public Application()
    {
        userAuthenticator = new UserAuthenticator();
        dashboardLoader = new DashboardLoader();
        paymentProcessor = new PaymentProcessor();
        reportGenerator = new ReportGenerator();
    }
    public void run()
    {
        System.out.println("Running application...");
        userAuthenticator.authenticateUser();
        dashboardLoader.loadDashboard();
        paymentProcessor.processPayments();
        reportGenerator.generateReports();
    }
}