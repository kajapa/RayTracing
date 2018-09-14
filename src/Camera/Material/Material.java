package Camera.Material;

import Light.Light;
import Light.LightIntensity;
import Utilities.Collision;

public abstract class Material {
   public abstract LightIntensity Radiance(Light light, Collision collision);
}
