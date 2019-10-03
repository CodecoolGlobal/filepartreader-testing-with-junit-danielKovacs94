import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(){
        this.filePath = "some invalid path";
        this.fromLine = -24;
        this.toLine = 42;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine){
        if (toLine < fromLine || fromLine < 1){
            throw new IllegalArgumentException("Argument exception");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
    }

    public String readLines() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String createdString = "";

        for (int i = fromLine; i <= toLine; i++) {
            createdString += lines.get(i);
        }
        return createdString;
    }
}
