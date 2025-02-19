## Problema Encontrado
O alto acoplamento entre a classe Carro e Motor deixa o código muito difícil de ser modular, uma vez que não haverá abstração caso outros tipos de motores sejam criados, resultando em uma classe com muitos construtores e cheia de sobrecargas.
## Sugestão para o Problema
Para abstrair melhor a classe Motor é desejável que ela se torne uma interface com métodos comuns para todo motor e com a criação de classes para cada tipo de motor implementando essa interface, com isso o alto acoplamento diminui uma vez que cada motor se comporta de maneira diferente e é fácil para manutenção.
## Código Problema
```java
public class TightCouplingViolation {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);
        car.start();
    }
}

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
        System.out.println("Car is running");
    }
}
```
## Código Solução
```java
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
```
