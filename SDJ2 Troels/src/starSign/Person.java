package starSign;

public class Person
{
private String name;
private StarSign starSign;
public Person(String name, StarSign starSign)
{
this.name = name;
this.starSign = starSign;
}
public String getName()
{
return name;
}
public StarSign getStarSign()
{
return starSign;
}
public String toString()
{
return name + ", " + starSign;
}
}