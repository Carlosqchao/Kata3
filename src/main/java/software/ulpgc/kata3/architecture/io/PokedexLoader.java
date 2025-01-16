package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Pokedex;

import java.io.IOException;
import java.util.List;

public interface PokedexLoader {
    List<Pokedex> load() throws IOException;
}
