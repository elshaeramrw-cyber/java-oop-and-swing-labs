abstract class Shape {
    private String color;
    public Shape(String color){
        this.color=color;
    }
    public abstract double calculateArea();
    public abstract void displayInfo();
    public String getColor() {
        return color;
    }    
}
class Circle extends Shape {
    private double radius;
     public Circle(String color, double radius) { 
        super(color);
        this.radius = radius;
     }
     public double calculateArea() {
        return Math.PI * radius * radius;

     }
     public void displayInfo() {
        System.out.println("Circle color=" + getColor()+ ", radius=" + radius);
     }
}
class Rectangle extends Shape {
    private double length, width;
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    public double calculateArea() {
        return length * width;
    }
    public void displayInfo() {
        System.out.println("Rectangle color=" + getColor()+ ", length=" + length + ", width=" + width);
    }
}
void main() {
 Circle    c = new Circle("Red", 5.0);
 Rectangle r = new Rectangle("Blue", 4.0, 6.0);
 Shape[] shapes = new Shape[2];
 shapes[0] = c;
 shapes[1] = r;
 for(int i=0;i<shapes.length;i++)
 {
    shapes[i].displayInfo();
    System.out.println("Area= "+ shapes[i].calculateArea());   
 }

}