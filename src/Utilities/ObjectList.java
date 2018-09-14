package Utilities;

import Light.*;
import Primitives.*;
import Primitives.Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectList {
    private final LightIntensity backgroundcolor;
    List<Object> objects = new ArrayList<Object>();
    List<Light> lights= new ArrayList<Light>();

    public ObjectList(LightIntensity background) {
        this.objects = new ArrayList<Object>();;
        this.backgroundcolor=background;
        this.lights=new ArrayList<Light>();
    }
    public void addObject(Object a)
    {
     objects.add(a);
    }
    public void addLight(Light light){lights.add(light);}

    public Collision Tracing(cRay ray)
    {
        Collision col= new Collision();
        cVector normal=new cVector(0,0,0);
        float minCollision= ray.Max;

        float CollisionDistance=0;
        for (Object object : objects)
        {
            if(object.Intersect(ray,CollisionDistance,normal)&&CollisionDistance<minCollision)
            {
                minCollision=CollisionDistance;
                col.collideObject=object;
                col.normal=normal;
            }
            if(col.collideObject!=null)
            {

                col.collisionpoint=ray.getOrigin().add(ray.getDirection().multiuplayby(minCollision));
                col.ray=ray;
                col.list=this;
            }
        }
        return col;

    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public LightIntensity getBackgroundcolor() {
        return backgroundcolor;
    }
}
