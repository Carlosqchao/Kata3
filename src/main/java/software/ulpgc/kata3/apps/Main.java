package software.ulpgc.kata3.apps;

import software.ulpgc.kata3.architecture.control.SelectStatisticCommand;
import software.ulpgc.kata3.architecture.control.ToggleStatisticsCommand;
import software.ulpgc.kata3.architecture.io.PokedexBarchartLoader;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static software.ulpgc.kata3.architecture.io.ResourceDownloader.download;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File("");
        String Path = path.getAbsolutePath();
        String urlInput= "https://raw.githubusercontent.com/Carlosqchao/Resources/refs/heads/main/pokedex_(Update.04.20).csv";
        String urlOutputPath = Path+"\\pokedex_(Update.04.20).csv";
        download(urlInput, urlOutputPath);
        String imageUrlInput= "https://w7.pngwing.com/pngs/272/921/png-transparent-pokemon-pokeball-pokemon-go-pokemon-pokeball-thumbnail.png";
        String imageOutputPath = Path+"\\pokemon-1536849_1280.png";
        download(imageUrlInput,imageOutputPath);
        MainFrame mainFrame = new MainFrame();
        PokedexBarchartLoader loader = new PokedexBarchartLoader();
        mainFrame.put("toggle",new ToggleStatisticsCommand(mainFrame.barchartDisplay(), loader));
        mainFrame.put("select",new SelectStatisticCommand(mainFrame.selectStatisticDialog(),loader, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
        mainFrame.setIconImage(new ImageIcon("pokemon-1536849_1280.png").getImage());
    }
}
