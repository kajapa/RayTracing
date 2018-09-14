package Primitives;

import Camera.Material.Material;

import java.awt.*;

public abstract class Object {
    public Material mat;


    public Object(Material mat) {
        this.mat = mat;
    }

    public abstract boolean Intersect(cRay ray, float distance, cVector newnormal);
}
