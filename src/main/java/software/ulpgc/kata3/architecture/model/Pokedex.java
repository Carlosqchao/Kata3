package software.ulpgc.kata3.architecture.model;

public class Pokedex {
    private final int id;
    private final String name;
    private final int generation;

    private final int numAbilities;


    public Pokedex(int id, String name, int generation, int numAbilities) {
        this.id = id;
        this.name = name;
        this.generation = generation;
        this.numAbilities = numAbilities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGeneration() {
        return generation;
    }

    public int getNumAbilities() {
        return numAbilities;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", generation=" + generation +
                ", numAbilities=" + numAbilities +
                '}';
    }
}
