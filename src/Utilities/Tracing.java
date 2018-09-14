package Utilities;

import Camera.Camera;
import Camera.Material.Material;
import Light.Light;
import Light.LightIntensity;
import Primitives.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Tracing extends JPanel {
private ObjectList objects;
private Camera camera;
private cVector2 windowsize;


    public Tracing(ObjectList objects, Camera camera, cVector2 windowsize) {
        super.setDoubleBuffered(true);
        this.objects = objects;
        this.camera = camera;
        this.windowsize = windowsize;
    }
    @Override
    public void paintComponent(Graphics g)
{
    Graphics2D g2d = (Graphics2D) g;
    for(int i=0;i<windowsize.x;i++)
    {
        for(int j=0;j<windowsize.y;j++)
        {
            cVector2 middlepixel= new cVector2((float)((i+0.5)/windowsize.x)*2-1,(float)((j+0.5)/windowsize.y)*2-1);
                    //new cVector2((float) (windowsize.x + (i + 0.5)),(float) (windowsize.y + (j + 0.5)));
                    //

            cRay ray = camera.CameraRay(middlepixel);


            g2d.setColor(MakeColor(ShadowRay(objects,ray)));
            g2d.fillRect(i, j, 1, 1);
        }
    }
}
public LightIntensity ShadowRay(ObjectList list, cRay ray)
{
    Collision collision = list.Tracing(ray);
    if(collision.collideObject==null){return list.getBackgroundcolor();}
    LightIntensity endcolor = LightIntensity.Black;
    Material material = collision.collideObject.mat;
    for(Light light : list.lights )
    { //System.out.println(material.Radiance(light,collision).toString());
        endcolor= endcolor.add(material.Radiance(light,collision));
        //endcolor=endcolor.add(material.Radiance(light,collision));
    }
    return endcolor;
}
public Color MakeColor(LightIntensity color)
{
    float r,g,b;
    color.setR( color.getR() < 0 ? 0 : color.getR() > 1 ? 1 : color.getR());
    color.setG(color.getG() < 0 ? 0 : color.getG() > 1 ? 1 : color.getG());
    color.setB(color.getB() < 0 ? 0 : color.getB() > 1 ? 1 : color.getB());
    return new Color((int)(color.getR() * 255),(int)(color.getG() * 255),(int)(color.getB() * 255));
}

}
