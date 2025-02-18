## Problema Encontrado

A violação do Princípio de Substituição de Liskov se dá quando a classe 'Bird' (Pássaro) se comporta de forma que todos os pássaros podem voar, e quando a classe 'Ostrich' (Avestruz) vem herdar de Pássaro, o método fly (Voar) vem junto, ou seja, a subclasse não pode ser substituída por sua superclasse sem causar erros inesperados no programa.

## Sugestão para o Problema

Para aplicar o Princípio de Substituição de Liskov podemos utilizar interfaces para conter um comportamento único do pássaro, que seria o método fly(). A classe Bird viraria uma interface com vários métodos comuns de todos os pássaros e uma nova interface seria criada (FlyingBird) para abrigar o método voar. Assim, quando uma classe de pássaro que voa for criada, é só implementar a interface onde o método voar se encontra.

## Código da Violação

```java
public class LiskovSubstitutionViolation {
    public static void main(String[] args) {
        Bird bird = new Ostrich();
        bird.fly();
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```

## Código da Solução

```java
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
```
