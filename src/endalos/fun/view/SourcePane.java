package endalos.fun.view;

import endalos.fun.controller.LoopEngine;
import endalos.fun.generator.RuleSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SourcePane extends JPanel {
    private JTextField sourceText;
    private JButton sourceButton;
    private JTextField stepsText;
    private int counter = 0;

    public SourcePane(){
        this.sourceText = new JTextField(20);
        this.sourceButton = new JButton();
        this.stepsText = new JTextField(20);

        sourceButton.setText("Use this rule");
        sourceButton.setPreferredSize(new Dimension(200,20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.weightx = 0.33;
        gbc.fill = GridBagConstraints.BOTH;

        add(sourceText, gbc);
        gbc.gridx++;
        add(sourceButton, gbc);
        gbc.gridx++;
        add(stepsText, gbc);

        sourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text;
                if(!(text = sourceText.getText()).equals("")){
                    counter = 0;
                    RuleSingleton.getInstance().setRules(text);
                    LoopEngine.getInstance().start();
                }
            }
        });
    }
    public void incrementSourceText(){
        counter++;
        stepsText.setText("Steps: " + counter);
    }


}
