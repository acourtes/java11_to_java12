package fr.arolla.file;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, copiedEuropeanAnthemWithError);

        Assertions.assertThat(result).isEqualTo(50);
    }

    @Test
    public void should_return_minus_one_for_identical_files() throws IOException {
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, copiedEuropeanAnthemWithoutError);

        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void should_return_minus_one_for_same_file() throws IOException {
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, originalEuropeanAnthem);

        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void should_return_one_for_second_file_with_only_one_character() throws IOException {
        final long result = FileUtils.checkFiles(originalEuropeanAnthem, oneCharacterFile);

        Assertions.assertThat(result).isEqualTo(0);
    }
}