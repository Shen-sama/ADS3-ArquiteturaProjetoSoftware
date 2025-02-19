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