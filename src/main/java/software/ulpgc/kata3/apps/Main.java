package software.ulpgc.kata3.apps;

import software.ulpgc.kata3.architecture.control.SelectStatisticCommand;
import software.ulpgc.kata3.architecture.control.ToggleStatisticsCommand;
import software.ulpgc.kata3.architecture.io.PokedexBarchartLoader;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        PokedexBarchartLoader loader = new PokedexBarchartLoader();
        mainFrame.put("toggle",new ToggleStatisticsCommand(mainFrame.barchartDisplay(), loader));
        mainFrame.put("select",new SelectStatisticCommand(mainFrame.selectStatisticDialog(),loader, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
        mainFrame.setIconImage(new ImageIcon("pokemon-1536849_1280.png").getImage());
    }
}
