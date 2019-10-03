import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private FilePartReader filePartReader = new FilePartReader();
    private List<String> alphabetical = Arrays.asList(
            "1", "10", "11", "12", "13", "14", "15", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "above", "all", "and", "and", "and", "apácalenynelacápa", "are", "below",
            "but", "empty", "file", "going", "helps", "hope", "i", "indulagörögaludni", "is", "it", "just", "lines",
            "me", "numbering", "on", "placeholder", "random", "read", "retinaszsaniter", "see", "sentences", "test",
            "them", "these", "this", "to", "try", "what's", "which", "will", "words", "works");

    private List<String> substringsE = Arrays.asList(
            "test", "file", "read", "hope", "these", "are", "placeholder", "sentences",
            "numbering", "them", "helps", "me", "see", "empty", "lines", "above", "below",
            "apácalenynelacápa", "retinaszsaniter");

    private List<String> substringsIn = Arrays.asList(
            "numbering", "going", "lines", "indulagörögaludni", "retinaszsaniter"
    );

    private List<String> palindromes = Arrays.asList(
            "11", "apácalenynelacápa", "indulagörögaludni", "retinaszsaniter"
    );

    @Test
    public void Should_Return_InAlphabeticalOrder() throws IOException {
        filePartReader.setup("src/fileToRead.txt", 1, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        assertEquals(alphabetical, fileWordAnalyzer.getWordsInAlphabeticalOrder());
    }

    @Test
    public void Should_Return_SubstringsE() throws IOException {
        filePartReader.setup("src/fileToRead.txt", 1, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        assertEquals(substringsE, fileWordAnalyzer.getWordsContainingSubstring("e"));
    }

    @Test
    public void Should_Return_SubstringsIn() throws IOException {
        filePartReader.setup("src/fileToRead.txt", 1, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        assertEquals(substringsIn, fileWordAnalyzer.getWordsContainingSubstring("in"));
    }

    @Test
    public void Should_Return_Palindromes() throws IOException {
        filePartReader.setup("src/fileToRead.txt", 1, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        assertEquals(palindromes, fileWordAnalyzer.getPalindromes());
    }

}