## Problema Encontrado
A classe viola o princípio de Open/Closed quando que para adicionar mais tipos de descontos teria que modificar internamente na classe, o que mostra um mal design, uma vez que por mais que a classe possa ser aberta para extensões, ela é fechada para modificações, para que a manuntenbilidade seja mais intuitiva.
## Sugestão para o Problema
Para deixar o código mais modular e evitar a modificação interna da classe de calculadora de desconto a criação de uma interface para abrigar o método de calculo de desconto e a partir dela acontece a criação de classes para os tipos de descontos implementando essa interface para que cada uma calcule da sua forma. Após isso, na classe de calculadora terá um atributo do tipo Desconto e um método para chamar o método que calcula o desconto da classe de desconto, que mudará com o tipo de desconto instanciado na criação do objeto da calculadora.
## Código Problema
```java
public class OpenClosedViolation {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount: " + calculator.calculateDiscount("VIP", 200));
    }
}

class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("VIP")) {
            return amount * 0.2;
        } else {
            return 0;
        }
    }
}
```
## Código Solução
```java
public class OpenClosedSolution
{
    public static void main(String[] args)
    {
        DiscountCalculator calculator = new DiscountCalculator(new VIPDiscount());

        System.out.println("Discount: " + calculator.calculateDiscount(200));

        calculator = new DiscountCalculator(new RegularDiscount());

        System.out.println("Discount: " + calculator.calculateDiscount(200));
    }
}

interface DiscountType
{
    public double applyDiscount(double amount);
}

class VIPDiscount implements DiscountType
{
    @Override
    public double applyDiscount(double amount)
    {
        return amount * 0.2;
    }
}

class RegularDiscount implements DiscountType
{
    @Override
    public double applyDiscount(double amount)
    {
        return amount * 0.1;
    }
}

class DiscountCalculator
{
    private DiscountType discountType;

    public DiscountCalculator(DiscountType discountType)
    {
        this.discountType = discountType;
    }

    public double calculateDiscount(double amount)
    {
        return discountType.applyDiscount(amount);
    }
}
```
