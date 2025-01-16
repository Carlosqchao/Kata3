package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Pokedex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePokedexLoader implements PokedexLoader {
    private final File file;
    private final PokedexDeserializer deserializer;

    public FilePokedexLoader(File file, PokedexDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Pokedex> load() throws IOException {
        List<Pokedex> titles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                titles.add(deserializer.deserialize(line));
            }
            return titles;
        }
    }

}
