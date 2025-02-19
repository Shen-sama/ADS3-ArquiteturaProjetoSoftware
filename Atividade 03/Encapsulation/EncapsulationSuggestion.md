## Problema Encontrado
O encapsulamento é importante para que os atributos de uma classe só sejam acessados diretamente por classes que tenham uma relação forte com a mesma, aumentando a segurança do código e que cada objeto só enxergue o que ele deve enxergar em outro. A classe pessoa mantendo os atributos de nome e idade públicos faz com que qualquer parte desses atributos sejam alteradas em qualquer ponto do código de forma direta.
## Sugestão para o Problema
Para resolucionar esse problema, alterar os atributos nome e idade para privados é o caminho correto, criando métodos públicos get e set para pegar e atribuir o valor de cada uma delas, deixando-as sendo acessáveis apenas por meio desses métodos, ajudando assim na manutenção do código e na reutilização de objetos em diferentes partes do programa, uma vez que a chamada desses métodos é simples.
## Código Problema
```java
public class ViolationOfEncapsulation {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John Doe";
        person.age = 30;
        System.out.println(person.name + " is " + person.age + " years old.");
    }
}

class Person {
    public String name;
    public int age;
}
```
## Código Solução
```java
public class SolutionOfEncapsulation
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        System.out.println(person.getName() + " tem " + person.getAge() + " anos de idade.");
    }
}

class Person
{
    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
```
