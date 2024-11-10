package software.ulpgc.kata3.architecture.model;

public class CsvPokedexDeserializer implements PokedexDeserializer {
    @Override
    public Pokedex deserialize(String line) {
        return deserialize(line.split(";"));
    }

    private Pokedex deserialize(String[] fields) {
        return new Pokedex(toInt(fields[1]), fields[2], toInt(fields[5]), toInt(fields[15]));
    }

    private int toInt(String value) {
        if (value.equals("\\N")) return 0;
        return Integer.parseInt(value);
    }
}
