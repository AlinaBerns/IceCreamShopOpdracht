package sellers;

import eatables.Cone;
import eatables.IceRocket;
import eatables.Magnum;

public interface IceCreamSeller extends Profitable{

    Cone orderCone (Cone.Flavor[] flavors);
    IceRocket orderIceRocket ();
    Magnum orderMagnum(Magnum.MagnumType magnumType);
}
