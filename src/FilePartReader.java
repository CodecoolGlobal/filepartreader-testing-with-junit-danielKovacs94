import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        // what's the point of this
        filePath = "some invalid path";
        fromLine = -24;
        toLine = 42;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {

        if (fromLine < 1) throw new IllegalArgumentException("fromLine parameter cannot be smaller than 1!");
        if (toLine < fromLine) throw new IllegalArgumentException("toLine parameter cannot be smaller than fromLine!");

        this.fromLine = fromLine;
        this.toLine = toLine;
        this.filePath = filePath;
    }

    public String read() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public String readLines() throws IOException {

        String[] allLines =this.read().split("\n");
        StringBuilder contents = new StringBuilder();

        for (int lineNum = fromLine; lineNum <= toLine; lineNum++) {
            if (fromLine <= lineNum) {
                contents.append(allLines[lineNum-1]).append("\n");
            }
        }

        return contents.toString();
    }

}
