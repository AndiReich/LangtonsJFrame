package endalos.fun.view;

import endalos.fun.generator.RuleSingleton;
import endalos.fun.misc.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    private CustomPanel customPanel;
    private SourcePane sourcePane;
    public UserInterface() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Langtons Ant");
        sourcePane = new SourcePane();

        customPanel = new CustomPanel();
        customPanel.setPreferredSize(new Dimension(Config.instance.width, Config.instance.height));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        add(sourcePane, gbc);
        gbc.gridy++;
        add(customPanel, gbc);




        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void setBoard(Color[][] board){
        this.customPanel.setBoard(board);
    }

    public void repaint(){
        customPanel.paintImmediately(customPanel.getBounds());
    }
    public void incrementStepCount(){
        sourcePane.incrementSourceText();
    }
}
