package pack_b;

public class CIsY implements IntfX {

    protected Double v = 0.0;
    String p = null;

    protected CIsY(Double x, String b) {
        v = x;
        p = b;
    }

    public void op_a(Double a) {
        v += a;    
    }

    public void op_b(Double b) {
        v -= b;
    }

    void op_c() {
        v = 0.0;
        p = null;
    }
}
