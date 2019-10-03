import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {

    @Test
    public void Should_ThrowException_IfCannotFindFile() {
        FilePartReader filePartReader = new FilePartReader();

        assertThrows(NoSuchFileException.class, () -> {
            filePartReader.setup("hue", 1, 5);
            filePartReader.read();
        });
    }

    @Test
    public void Should_ThrowException_IfFromLineIsNotOver0() {
        FilePartReader filePartReader = new FilePartReader();

        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("hue", 0, 5);
        });
    }

    @Test
    public void Should_ThrowException_IfToLineIsSmallerThanFromLine() {
        FilePartReader filePartReader = new FilePartReader();

        assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("hue", 4, 2);
        });

    }
}