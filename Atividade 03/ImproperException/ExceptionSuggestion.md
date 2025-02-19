## Problema Encontrado
O código mostra o uso de identificar exceções de uma forma muito genérica, o que dificulta a correção de erros posteriores pelo erro não informar o que deu errado, levando a demora para a identificação correta do erro.
## Sugestão para o Problema
No caso do código, que o erro se dá por causa de uma divisão por zero, pode-se usar a exceção aritimética da própria biblioteca e usar um throw para criar a mensagem desejada quando a condição do divisor ser igual a 0. Após isso, é apenas usar try-catch quando a função de divisão for chamada.
## Código Problema
```java
public class ImproperExceptionHandling {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }
}

class Calculator {
    public void divide(int a, int b) {
        try {
            System.out.println("Result: " + (a / b));
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
```
## Código Solução
```java
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
```
