public class Particle {
    private Vec2d pos;
    private Vec2d vel;
    private final int radius;
    private final int mass;


    // Constructors
    public Particle(Vec2d initialPos, Vec2d initialVel, int radius) {
        this.pos = initialPos;
        this.vel = initialVel;
        this.radius = radius;
        this.mass = 10;
    }

    public Particle(Vec2d initialPos, Vec2d initialVel, int radius, int mass) {
        this.pos = initialPos;
        this.vel = initialVel;
        this.radius = radius;
        this.mass = mass;
    }

    //
    public static double distance(Particle first, Particle second) {
        Vec2d directionalVec = second.getPos().sub(first.getPos());
        return directionalVec.magnitude();
    }


    // Update the position by adding the velocity and enforcing bounds. Bounds shouldn't be managed by this class but
    public void update(long deltaTime) {
        Vec2d changeInVel = vel.multiply(deltaTime / 1_000_000D);
        pos = pos.add(changeInVel);

    }

    // Overload of update to not use deltaTime
    public void update() {
        pos = pos.add(vel);
    }


    // Gravity system between two particles
    public void gravity(Particle otherParticle) {
        // F_g = G*((M1 * M2) / R^2)

        Vec2d directionalVec = otherParticle.getPos().sub(this.pos);
        double distance = directionalVec.magnitude();
        double gravityPull = (Constants.GRAVITATIONAL_CONSTANT * otherParticle.getMass() * this.getMass()) / (distance * distance);

        Vec2d normalizedDirectionalVec = directionalVec.normalize();

        // New velocity is the initial velocity plus the new vector times a constant to make the number bigger
        this.vel = this.vel.add(normalizedDirectionalVec.multiply(gravityPull));
    }

    // Getters
    // Get xy Pos
    public Vec2d getPos() {
        return this.pos;
    }

    public Vec2d getVel() {
        return this.vel;
    }
    
    public double getPosX() {
        return this.pos.x;
    }

    public double getPosY() {
        return this.pos.y;
    }

    public double getVelX() {
        return this.vel.x;
    }

    public double getVelY() {
        return this.vel.y;
    }

    // Get radius and mass
    public int getRadius() {
        return this.radius;
    }

    public int getMass() {
        return this.mass;
    }


    // Setters
    public void setPosX(double xPos) {
        this.pos.x = xPos;
    }



}
