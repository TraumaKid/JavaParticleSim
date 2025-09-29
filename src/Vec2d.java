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


    // Operations between vectors
    public Vec2d add(Vec2d other) {
        Vec2d result = new Vec2d(this.x + other.x, this.y + other.y);
        return result;
    }

    public Vec2d subtract(Vec2d other) {
        Vec2d result = new Vec2d(this.x - other.x, this.y - other.y);
        return result;
    }

    public Vec2d multiply(Vec2d other) {
        Vec2d result = new Vec2d(this.x * other.x, this.y * other.y);
        return result;
    }

    public Vec2d divide(Vec2d other) {
        Vec2d result = new Vec2d(this.x / other.x, this.y / other.y);
        return result;
    }

    // Operations between vector and scalar
    public Vec2d multiply(double value) {
        Vec2d result = new Vec2d(this.x * value, this.y * value);
        return result;
    }



    // Length of the vector
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

}
