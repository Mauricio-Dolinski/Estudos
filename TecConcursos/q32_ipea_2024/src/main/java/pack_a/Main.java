package pack_a;
import pack_b.*;

public class Main extends CIsY {

    public static void main(String[] args) {
        IntfX a = new Main();
        CIsY b = new Main();
        Main c = new Main();

        //b.p="***";
        //op_c();
        c.op_a(0.5, 0.8);
        //op_k(5.2);
        //a.op_a(0.0, 0.1);
    }

    public Main() {
        super(0.0, "");
    }

    public void op_a(Double e, Double f){
        v = e + f;
    }

    public void op_b(Double e, Double f) {
        v = e + f;
    }

    public void op_K(Double d) {
        v = d;
    }
}