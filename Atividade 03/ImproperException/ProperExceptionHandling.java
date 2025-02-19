public class ProperExceptionHandling 
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        try 
        {  
            calculator.divide(10, 0);
        } 
        catch (ArithmeticException error) 
        {
            System.out.println("Erro: " + error.getMessage());
        }
    }
}

class Calculator 
{
    public void divide(int a, int b) 
    {
        if (b == 0) throw new ArithmeticException("Não é possível dividir por zero.");

        System.out.println("Resultado: " + (a / b));
    }
}
