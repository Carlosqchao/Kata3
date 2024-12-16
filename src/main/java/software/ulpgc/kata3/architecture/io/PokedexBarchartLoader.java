package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.model.CsvPokedexDeserializer;
import software.ulpgc.kata3.architecture.model.FilePokedexLoader;
import software.ulpgc.kata3.architecture.model.Pokedex;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokedexBarchartLoader implements BarchartLoader {
    @Override
    public Barchart load(int id) throws IOException{
        return switch (id){
            case 0 -> barchart0();
            case 1 -> barchart1();
            default -> null;
        };
    }

    private Barchart barchart0() throws IOException {
        Barchart barchart = new Barchart("Pokemon Generations", "Generation","Number");
        File file = new File("pokedex_(Update.04.20).csv");
        List<Pokedex> titles = new FilePokedexLoader(file, new CsvPokedexDeserializer()).load();
        Map<Integer,Integer> stats = new HashMap<>();
        for (Pokedex title : titles){
            stats.put(title.getGeneration(), stats.getOrDefault(title.getGeneration(),0)+1);
        }
        for (int i = 1; i < stats.size(); i++) {
            barchart.put("Generation "+i,stats.get(i));
        }
        return barchart;
    }

    private Barchart barchart1() throws IOException {
        Barchart barchart = new Barchart("Pokemon Generations", "Generation","Number");
        File file = new File("pokedex_(Update.04.20).csv");
        List<Pokedex> titles = new FilePokedexLoader(file, new CsvPokedexDeserializer()).load();
        Map<Integer,Integer> stats = new HashMap<>();
        for (Pokedex title : titles){
            stats.put(title.getNumAbilities(), stats.getOrDefault(title.getNumAbilities(),0)+1);
        }
        for (int i = 0; i < stats.size(); i++) {
            barchart.put(i+ " Ability/ies",stats.get(i));
        }
        return barchart;
    }
}
