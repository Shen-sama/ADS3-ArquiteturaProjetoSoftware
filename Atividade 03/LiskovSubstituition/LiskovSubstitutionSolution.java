public class LiskovSubstitutionSolution
{
    public static void main(String[] args)
    {
        Bird bird = new Ostrich();
        bird.description();

        FlyingBird flyingBird = new Eagle();
        flyingBird.description();
        flyingBird.fly();
    }
}

interface Bird
{
    public void description();
}

interface FlyingBird extends Bird
{
    public void fly();
}

class Eagle implements FlyingBird
{
    @Override
    public void fly()
    {
        System.out.println("A Águia está voando.");
    }

    @Override
    public void description()
    {
        System.out.println("A Águia é o nome comum dado algumas aves de rapina da família Accipitridae, geralmente de grande porte, carnívoras, de grande acuidade visual.");
    }
}

class Ostrich implements Bird
{
    @Override
    public void description()
    {
        System.out.println("O Avestruz é uma espécie de ave não voadora, originária da África.");
    }
}