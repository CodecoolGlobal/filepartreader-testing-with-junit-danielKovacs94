import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/fileToRead.txt", 3, 8);

        String allContent = filePartReader.read();
        System.out.println(allContent);

        System.out.println("");

        String limitedContent = filePartReader.readLines();
        System.out.println(limitedContent);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List alphabetical = fileWordAnalyzer.getWordsInAlphabeticalOrder();
        List wordsWithSubstrings = fileWordAnalyzer.getWordsContainingSubstring("in");
        List palindromes = fileWordAnalyzer.getPalindromes();

        System.out.println(alphabetical);
        System.out.println(wordsWithSubstrings);
        System.out.println(palindromes);

    }
}