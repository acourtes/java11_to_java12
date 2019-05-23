package fr.arolla.file;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class FileUtils {

    // We use here mismatch a new method in the Files class in Java 12
    static long checkFiles(File originalFile, File otherFile) throws IOException {
        return Files.mismatch(originalFile.toPath(), otherFile.toPath());
    }

}
