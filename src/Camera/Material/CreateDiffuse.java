package Camera.Material;

import Light.Light;
import Light.LightIntensity;
import Primitives.*;
import Utilities.Collision;

public class CreateDiffuse extends Material {
    public LightIntensity matColor;

    public CreateDiffuse(LightIntensity matColor) {
        this.matColor = matColor;
    }

    @Override
    public LightIntensity Radiance(Light light, Collision collision) {
        cVector inDirection =(light.getPosition().subtract(collision.collisionpoint)).normalized();
        //System.out.println("Normal "+collision.normal.toString());


        float diffusevalue= inDirection.dot(collision.normal);
        //System.out.println("diffuse "+diffusevalue);
        if (diffusevalue < 0)
        {//System.out.println("Mniejsze od 0 "+diffusevalue);
            return LightIntensity.White; }
       // System.out.println("wieksza od 0? "+light.getIntesity().multiply(matColor).multiply(diffusevalue).toString());
        return light.getIntesity().multiply(matColor).multiply(diffusevalue);
    }
}
