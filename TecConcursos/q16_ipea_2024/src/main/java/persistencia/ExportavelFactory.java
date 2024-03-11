package persistencia;

public class ExportavelFactory {
    public Exportavel criarExportavel(String format) {
        switch (format.toLowerCase()) {
            case "xml":
                return new XML();
            case "json":
                return new JSON();
            case "plaintext":
                return new PlainText();
            default:
                throw new IllegalArgumentException("Formato não implementado: " + format);
        }
    }

    public String[] getFormats() {
        String[] formats = {"xml", "json", "plaintext"};
        return formats;
    }
}
