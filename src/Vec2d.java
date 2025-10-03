public class Vec2d {
    // Attributes
    public double x;
    public double y;

    // Constructors and overload
    public Vec2d(double xPos, double yPos) {
        x = xPos;
        y = yPos;
    }

    public Vec2d(int xPos, int yPos) {
        x = (double) xPos;
        y = (double) yPos;
    }

    public Vec2d(double[] pos) {
        x = pos[0];
        y = pos[1];
    }

    public Vec2d() {
        x = 0;
        y = 0;
    }

    // To String so it can be printed using System.out.print
    @Override
    public String toString() {
        return ("x: " + this.x + ", y: " + this.y);
    }


    // Operations between vectors. Will return a new vector? Or can use the functional paradigm
    public Vec2d add(Vec2d other) {
        Vec2d result = new Vec2d(this.x + other.x, this.y + other.y);
        return result;
    }

    public Vec2d sub(Vec2d other) {
        Vec2d result = new Vec2d(this.x - other.x, this.y - other.y);
        return result;
    }

    public Vec2d multiply(Vec2d other) {
        Vec2d result = new Vec2d(this.x * other.x, this.y * other.y);
        return result;
    }

    public Vec2d div(Vec2d other) {
        Vec2d result = new Vec2d(this.x / other.x, this.y / other.y);
        return result;
    }

    // Operations between vector and scalar
    public Vec2d multiply(double scalar) {
        Vec2d result = new Vec2d(this.x * scalar, this.y * scalar);
        return result;
    }



    // Vector operations

    // Length of the vector
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Normalize a vector(set the length to 1)
    public Vec2d normalize() {
        double length = this.magnitude();
        return new Vec2d(this.x / length, this.y / length);
    }


    // Dot product
    public double dot(Vec2d other) {
        return this.x * other.x + this.y * other.y;
    }

    // Find the angle between two vectors
    public double angleBetween(Vec2d other) {
        // arccos((v1 . v2) /(|v1| * |v2|)) = Equation being used

        return Math.acos(this.dot(other) / (this.magnitude() * other.magnitude())) ;

    }

}
