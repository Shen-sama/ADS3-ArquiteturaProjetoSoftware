## Problema Encontrado
O problema se encontra na dependência direta que a classe Switch tem com a LightBulb em vez de uma abstração, diminuindo a flexibilidade do código.
## Sugestão para o Problema
Uma sugestão para o problema seria primeiramente inverter os papéis, por fazer mais sentido a lâmpada conter um interruptor. Após isso é desejável realizar uma abstração na classe interruptor para uma interface, para que vários tipos de interruptores possam ser criados a partir dela e serem implementados dentro da classe lâmpada.
## Código Problema
```java
public class DependencyInversionViolation {
    public static void main(String[] args) {
        LightBulb bulb = new LightBulb();
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.turnOn();
    }
}

class LightBulb {
    public void turnOn() {
        System.out.println("LightBulb is ON");
    }

    public void turnOff() {
        System.out.println("LightBulb is OFF");
    }
}

class Switch {
    private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void turnOn() {
        bulb.turnOn();
    }

    public void turnOff() {
        bulb.turnOff();
    }
}
```
## Código Solução
```java
public class DependencyInversionSolution
{
    public static void main(String[] args)
    {
        Switch lightSwitch = new LightBulbSwitch();
        LightBulb lightBulb = new LightBulb(lightSwitch);
        lightBulb.turnOn();
    }
}

interface Switch
{
    public void turnOn();
    public void turnOff();
}

class LightBulbSwitch implements Switch
{
    @Override
    public void turnOn()
    {
        System.out.println("LightBulb is ON");
    }

    @Override
    public void turnOff()
    {
        System.out.println("LightBulb is OFF");
    }
}

class LightBulb
{
    private Switch lightSwitch;

    public LightBulb(Switch lightSwitch)
    {
        this.lightSwitch = lightSwitch;
    }

    public void turnOn()
    {
        lightSwitch.turnOn();
    }

    public void turnOff()
    {
        lightSwitch.turnOff();
    }
}
```
