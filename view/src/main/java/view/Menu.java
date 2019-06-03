/*
 *
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    private JPanel contentPane;
    private int MapID = 0;
    private Clip clip;

    /**
     * Create the frame.
     */
    public Menu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 302, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);

        this.setTitle("BoulderDash menu");

        JPanel panel = new JPanel();
        this.contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Map 1");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.setMapID(1);
                Menu.this.stopMusic();
            }
        });

        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(255, 250, 240));
        btnNewButton.setBounds(30, 144, 89, 23);
        panel.add(btnNewButton);

        JButton btnMap = new JButton("Map 2");
        btnMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.setMapID(2);
                Menu.this.stopMusic();
            }
        });
        btnMap.setBackground(new Color(255, 255, 255));
        btnMap.setBounds(148, 144, 89, 23);
        panel.add(btnMap);

        JButton btnMap_1 = new JButton("Map 3");
        btnMap_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.setMapID(3);
                Menu.this.stopMusic();
            }
        });
        btnMap_1.setBackground(new Color(255, 255, 255));
        btnMap_1.setBounds(30, 178, 89, 23);
        panel.add(btnMap_1);

        JButton btnMap_2 = new JButton("Map 4");
        btnMap_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.setMapID(4);
                Menu.this.stopMusic();
            }
        });
        btnMap_2.setBackground(new Color(255, 255, 255));
        btnMap_2.setBounds(148, 178, 89, 23);
        panel.add(btnMap_2);

        JButton btnMap_3 = new JButton("Map 5");
        btnMap_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.setMapID(5);
                Menu.this.stopMusic();
            }
        });
        btnMap_3.setBackground(new Color(255, 255, 255));
        btnMap_3.setBounds(86, 212, 89, 23);
        panel.add(btnMap_3);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("sprites\\menu.jpg"));
        label.setBounds(0, 0, 276, 251);
        panel.add(label);

        this.playMusic();
    }

    public int getMapID() {
        return this.MapID;
    }

    public void setMapID(int mapID) {
        this.MapID = mapID;
    }

    public void playMusic() {
        String filePath = "sounds\\Boulder Dash (NES) - Map Music.wav";
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) this.clip.getControl(FloatControl.Type.MASTER_GAIN);
            double gain = 0.2;
            float dB = (float) ((Math.log(gain) / Math.log(10.0)) * 20.0);
            gainControl.setValue(dB);
            this.clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void stopMusic() {
        this.clip.close();
    }

}
