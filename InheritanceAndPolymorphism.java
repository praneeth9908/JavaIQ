// 15. Inheritance and Polymorphism:
// Implement a class hierarchy with inheritance and demonstrate polymorphism.

class Shape{
    double area(){
        return 0;
    }
}

class Circle extends Shape{
    private double radius;
    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double area(){
        return Math.PI * Math.pow(this.radius, 2);
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;
    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @Override
    double area(){
        return length * width;
    }
}

/**
 * InheritanceAndPolymorphism
 */
public class InheritanceAndPolymorphism {

    static void printArea(Shape shape){
        System.out.println("Area :- "+shape.area());
    }
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5, 10);

        System.out.println("Circle:-");
        printArea(circle);

        System.out.println("Rectangle:-");
        printArea(rectangle);
    }
     
}