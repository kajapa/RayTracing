package Main;

import Camera.*;
import Camera.Material.CreateDiffuse;
import Camera.Material.Material;
import Light.Light;
import Light.LightIntensity;
import Primitives.*;
import Utilities.ObjectList;
import Utilities.Tracing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {
    int width = 1000;
    int height = 1000;
    ObjectList objects= new ObjectList(new LightIntensity(1,1,0.1f));
    Camera camera= new Ortho(new cVector(0f,0f,-200f),0,new cVector2(5,5));
    Camera camera2 = new Perspectiv(new cVector(0f, 1f, -8f),new cVector(0f, 1f, -7f),new cVector(0f, -1f, 0f),1f);
    public Main()throws IOException
    {
        super.setSize(width, height);
        Material graymat= new CreateDiffuse(new LightIntensity(0.5f,0.5f,0.5f));
        Material greenmat = new CreateDiffuse(new LightIntensity(0,1,0));
        Material redmat= new CreateDiffuse(new LightIntensity(1,0,0));
        Material bluemat= new CreateDiffuse(new LightIntensity(0,0,1));

        objects.addObject(new Sphere(new cVector(-4, 0, 0), 2f, redmat));
        objects.addObject(new Sphere(new cVector(4, 0, 0), 2, greenmat));
        objects.addObject(new Sphere(new cVector(0, 0, 3), 2, bluemat));
        objects.addObject(new Plane(new cVector(0f, -2f, 0f),new cVector(0f, 1f, 0f),graymat));
        objects.addLight(new Light(new cVector(0f, 5f, -5f),new LightIntensity(1,1,1)));
        Tracing  trace= new Tracing(objects,camera2,new cVector2(width,height));


        super.setLayout(new BorderLayout());

        super.setTitle("Fotoreal");

        super.setLocation(0, 0);
        super.setResizable(false);

       super.add(trace);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        new Main();


    }
}
