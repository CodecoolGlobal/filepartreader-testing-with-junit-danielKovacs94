import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;
    private List<String> allWords;

    public FileWordAnalyzer(FilePartReader filePartReader) throws IOException {
        this.filePartReader = filePartReader;
        allWords = Arrays.asList(filePartReader.read().split("\\s+"));
    }

    public List getWordsInAlphabeticalOrder() {
        List<String> alphabetical = new ArrayList<>(allWords);

        Collections.sort(alphabetical);
        return alphabetical;
    }

    public List getWordsContainingSubstring(String substring) {
        List<String> results = new ArrayList<>();

        for (String word : allWords) {
            if (word.contains(substring)) results.add(word);
        }

        return results;
    }

    public List getPalindromes() {
        List<String> results = new ArrayList<>();

        for (String word : allWords) {
            if (isPalindrome(word)) results.add(word);
        }

        return results;
    }

    private boolean isPalindrome(String word) {
        if (word.length() == 1) return false;

        StringBuilder reverser = new StringBuilder(word);
        String reversedWord = reverser.reverse().toString();

        return word.equals(reversedWord);
    }
}
