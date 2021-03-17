import java.util.*;
import java.lang.Math;
interface Shape
{
    public double perimeterCalculation(); 
    public double areaCalculation();
}
class Circle implements Shape
{
    double radius;
    public Circle(double r){
        radius = r;
    }
    public double areaCalculation(){
        return 3.14 * radius * radius;
    }
    public double perimeterCalculation()
    {
        return 3.14*2*radius;
    }
}
class Ellipse implements Shape{
    double majorRadius;
    double minorRadius;
    public Ellipse(double l, double r){
    	majorRadius= l;
        minorRadius = r;
    }
    public double areaCalculation(){
        return 3.14*majorRadius*minorRadius;
    }
    public double perimeterCalculation(){
        return (double)2*3.14* Math.sqrt((majorRadius*majorRadius+minorRadius*minorRadius)/(2*1.0));
    }
}
class Main{
    public static void main(String args[])
    {   
    	Scanner sc =new Scanner(System.in);
	    Shape s;
	    double x,y;
	    System.out.println("Enter x,y values of the shape");
	    String input=sc.nextLine();
	    x=Double.parseDouble(input.split(",")[0]);
	    y=Double.parseDouble(input.split(",")[1]);
	    if(x==0)
	    { 
	    	s= new Circle(x);
	    	System.out.println("Area of Circle "+  s.areaCalculation());
	    	System.out.println("Perimeter of Circle "+ s.perimeterCalculation());
	    }
	    else 
	    {
	        s= new Ellipse(x,y);
	        System.out.println("Area of Ellipse "+ s.areaCalculation());
	        System.out.println("perimeter of Ellipse " +s.perimeterCalculation());
	        
	    }
    }
}