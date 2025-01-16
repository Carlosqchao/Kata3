package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Pokedex;

public interface PokedexDeserializer {
    Pokedex deserialize(String line);
}
