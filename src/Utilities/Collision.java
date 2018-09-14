package Utilities;

import Primitives.*;

import java.awt.*;
import java.lang.Object;

public class Collision {

    public Primitives.Object collideObject;
    public ObjectList list;
    public cVector normal;
    public cVector collisionpoint;

    public cRay ray;

    public Primitives.Object getCollideObject() {
        return collideObject;
    }

    public void setCollideObject(Primitives.Object collideObject) {
        this.collideObject = collideObject;
    }

    public ObjectList getList() {
        return list;
    }

    public void setList(ObjectList list) {
        this.list = list;
    }

    public cVector getNormal() {
        return normal;
    }

    public void setNormal(cVector normal) {
        this.normal = normal;
    }

    public cVector getCollisionpoint() {
        return collisionpoint;
    }

    public void setCollisionpoint(cVector collisionpoint) {
        this.collisionpoint = collisionpoint;
    }

    public cRay getRay() {
        return ray;
    }

    public void setRay(cRay ray) {
        this.ray = ray;
    }
}
