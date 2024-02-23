/ Using run-time polymorphism.

class Figure {

double diml;

double dim2;

Figure (double a, double b) {

diml a;

dim2 = b;

}

double area () {

System.out.println("Area for Figure is undefined.");

return 0;

}

}

class Rectangle extends Figure {

Rectangle (double a, double b) {

super(a, b);

}

// override area for rectangle

double area () {

System.out.println("Inside Area for Rectangle.");

return diml * dim2;

}

}

class Triangle extends Figure {

Triangle (double a, double b) {

super (a, b);

}

// override area for right triangle

double area () {

System.out.println("Inside Area for Triangle."); return dim1 dim2 / 2;

}

}

class FindAreas {

public static void main(String args[]) { Figure f new Figure (10, 10);

Rectangle r = new Rectangle (9, 5);

Triangle t = new Triangle (10, 8);

Figure figref;