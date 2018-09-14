package Camera;

import Primitives.*;

public class OrthoBase {
    public cVector u;
    public cVector v;
    public  cVector w;

    public OrthoBase(cVector eye, cVector lookat, cVector up) {
        w = eye.subtract(lookat);
        w.normalized();
        u = up.getVectorProduct(w);
        u.normalized();
        v=w.getVectorProduct(u);

    }

}
