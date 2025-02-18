public class TightCouplingSolution
{
    public static void main(String[] args)
    {
        Engine engine = new FuelEngine();
        Car car = new Car(engine);
        car.start();
    }
}

interface Engine
{
    public void start();
}

class FuelEngine implements Engine
{
    @Override
    public void start()
    {
        System.out.println("O motor à combustível está ligando.");
    }
}

class Car
{
    private Engine engine;

    public Car(Engine engine)
    {
        this.engine = engine;
    }

    public void start()
    {
        engine.start();
        System.out.println("O carro ligou.");
    }
}

