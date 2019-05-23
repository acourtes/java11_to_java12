package fr.arolla.file;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class FileUtils {

    private static final int IDENTICAL_FILE_RETURN_CODE = -1;

    // TODO by using a new method in the Files class in Java 12
    static long checkFiles(File originalFile, File otherFile) throws IOException {
        if (Files.isSameFile(originalFile.toPath(), otherFile.toPath())) {
            return IDENTICAL_FILE_RETURN_CODE;
        }

        final byte[] originalFileBytes = Files.readAllBytes(originalFile.toPath());
        final byte[] otherFileBytes = Files.readAllBytes(otherFile.toPath());

        int index = 0;
        final var originalFileSize = originalFileBytes.length;
        final var otherFileSize = otherFileBytes.length;
        final var minimalLength = originalFileSize <= otherFileSize ? originalFileSize : otherFileSize;

        while (index < minimalLength) {
            if (originalFileBytes[index] != otherFileBytes[index]) {
                return Long.valueOf(String.valueOf(index));
            }

            index++;
        }

        return originalFileSize == otherFileSize ? IDENTICAL_FILE_RETURN_CODE : Long.valueOf(String.valueOf(index));
    }

}
