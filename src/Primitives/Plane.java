package Primitives;

import Camera.Material.Material;
import Light.Light;
import Light.LightIntensity;

import java.awt.*;

public class Plane extends Object {
    cVector point;
    cVector normal;
    Material col;

    public Plane(cVector point, cVector normal, Material col) {
        super(col);
        this.point = point;
        this.normal = normal;
    }

    @Override
    public boolean Intersect(cRay ray, float distance,cVector newnormal) {
        float t = (point.subtract(ray.getOrigin()) ).dot(normal) / ray.getDirection().dot(normal);
        if (t > ray.Epsilon)
        {
            distance = t;
            newnormal=normal;


                        return true;
        }
        return false;
    }
}
