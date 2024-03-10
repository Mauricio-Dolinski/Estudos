package persistencia;

import java.io.IOException;

public interface Exportavel{
    boolean open() throws IOException;
    boolean close();
    boolean write(String dados);
    boolean read();
}
