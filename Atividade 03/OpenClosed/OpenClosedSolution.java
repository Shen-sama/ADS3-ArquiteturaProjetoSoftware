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
