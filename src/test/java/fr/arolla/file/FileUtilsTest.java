package fr.arolla.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class FileUtilsTest {

    private URL originalFileURL = FileUtilsTest.class.getResource("/original_european_anthem.txt");
    private File originalEuropeanAnthem = new File(originalFileURL.getFile());
    private URL copiedFileURLWithError = FileUtilsTest.class.getResource("/copied_european_anthem_with_error.txt");
    private File copiedEuropeanAnthemWithError = new File(copiedFileURLWithError.getFile());
    private URL copiedFileURLWithoutError = FileUtilsTest.class.getResource("/copied_european_anthem_without_error.txt");
    private File copiedEuropeanAnthemWithoutError = new File(copiedFileURLWithoutError.getFile());
    private URL oneCharacterFileURL = FileUtilsTest.class.getResource("/one_character_file.txt");
    private File oneCharacterFile = new File(oneCharacterFileURL.getFile());

    @Test
    public void should_find_the_byte_where_files_are_different() throws IOException {
        // For this test, if you are using Windows, think of changing the end of line of these both files
        // and use Unix end if line (LF). Or put 51 instead of 50 :)
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, copiedEuropeanAnthemWithError);

        assertThat(result).isEqualTo(50);
    }

    @Test
    public void should_return_minus_one_for_identical_files() throws IOException {
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, copiedEuropeanAnthemWithoutError);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void should_return_minus_one_for_same_file() throws IOException {
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, originalEuropeanAnthem);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void should_return_one_for_second_file_with_only_one_character() throws IOException {
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, oneCharacterFile);

        assertThat(result).isEqualTo(0);
    }
}