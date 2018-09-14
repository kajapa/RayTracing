package Primitives;

import Camera.Material.Material;

import java.awt.*;
import java.util.Objects;

public class Sphere extends Object {
   public cVector posiotion;
 public   float size;
    public Material color;

    public Sphere(cVector posiotion, float size,Material color) {
       super(color);

        this.posiotion = posiotion;
        this.size = size;
    }

    @Override
    public boolean Intersect(cRay ray,float dist,cVector newnormal) {
        cVector v, dir;
        float t;
        cVector distance = ray.getOrigin().subtract(posiotion) ;

        float a = ray.getDirection().getLengthSquared();
        float b = (distance.multiuplayby(2)).dot(ray.getDirection());
        float c = distance.getLengthSquared() - size * size;
        float disc = b * b - 4 * a * c;
        if (disc < 0) { return false; }
        float discSq = (float) Math.sqrt(disc);
        float denom = 2 * a;
        t = (-b - discSq) / denom;
        if (t < ray.Epsilon)
        { t = (-b + discSq) / denom; }
        if (t < ray.Epsilon)
        { return false; }
        cVector collisionpoint=ray.getOrigin().add(ray.getDirection().multiuplayby(t));
        newnormal= collisionpoint.subtract(posiotion).normalized();

        //System.out.println("Normal sphera "+newnormal.toString());
        dist = t;
        return true;


        /*v = new cVector().sub(ray.getOrigin(), posiotion);
        dir = ray.getDirection();

        float b = (v.dot(ray.getDirection()));
        float det = (b * b) - dir.dot(dir) * (v.dot(v) - size * size);

        if (det < 0) {
            //logger.info("Brak przeciecia");
            return false;
        }

        det = (float) Math.sqrt(det);

        if (det == 0) {

            //Ray.getIntersectPoint(b);
            //logger.info("Punkt przeciecia"+Ray.getIntersectPoint(-b).toString());
            //return Ray.getIntersectPoint(-b);
            return false;

        }
        else {
            double t1 = -b + det;
            double t2 = -b - det;
            double dist = t1 < t2 ? t1 : t2;
            //logger.info("Punkt przeciecia"+Ray.getIntersectPoint(dist).toString());
            //return Ray.getIntersectPoint(dist);
            return true;

        }*/


    }
}
