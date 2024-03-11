package persistencia;

import java.io.IOException;

public class Exportadora {
    private Exportavel exportavel;

    public Exportadora() throws IOException {
        ExportavelFactory exportavelFactory = new ExportavelFactory();
        String[] formats = exportavelFactory.getFormats();
        for (String format : formats) {
            exportavel = exportavelFactory.criarExportavel(format);
            if (format.equals(formats[formats.length-1])){
                if (exportavel.open()){
                    break;
                }
                else {
                    throw new IOException();
                }
            }
            if (exportavel.open())
                break;
        }
        
        if (exportavel == null){
            throw new IOException();
        }
    } 

    public void exportar(String dados){
        exportavel.read();
        exportavel.write(dados);
        exportavel.close();
    }
}
