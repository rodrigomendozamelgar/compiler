package org.ulasalle.source.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SourceFileReader {

    private File file;
    

    public void setFile(File file) throws FileNotFoundException {
        this.file = file;
    }

    public List<String> getLines() throws IOException {
        List<String> lines=new ArrayList();
        try (Stream<String> sourceFileStream = Files.lines(file.toPath())) {
            sourceFileStream.forEach(lineStream ->  lines.add(lineStream));
        }
        return lines;
    }

}
