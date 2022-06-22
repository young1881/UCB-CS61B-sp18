public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        return mass * p.mass * G / (calcDistance(p) * calcDistance(p));
    }
    
    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double totalForce = 0;
        for (Planet pi : p) {
            if (this.equals(pi)) {
                continue;
            }
            totalForce += calcForceExertedByX(pi);
        }
        return totalForce;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double totalForce = 0;
        for (Planet pi : p) {
            if (this.equals(pi)) {
                continue;
            }
            totalForce += calcForceExertedByY(pi);
        }
        return totalForce;
    }

    public void update(double t, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += ax * t;
        yyVel += ay * t;
        xxPos += xxVel * t;
        yyPos += yyVel * t;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
