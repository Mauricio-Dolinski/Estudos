package persistencia;

import java.io.IOException;

public class Exportadora {
    private Exportavel exportavel;

    public Exportadora() throws IOException {
        this.exportavel = new XML();

        if ( !exportavel.open()){
            this.exportavel = new JSON();
            if (!exportavel.open()){
                this.exportavel = new PlainText();
                if (!exportavel.open())
                    throw new IOException();
            }
        }
    } 

    public void exportar(String dados){
        exportavel.read();
        exportavel.write(dados);
        exportavel.close();
    }
}
