package Memory;

import SnakeGame.GamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class GameView extends JFrame {

    private static final long serialVersionUID = 1L;

    private GamePanel model;
    private JPanel contentPane;

    //=====Welcome Attributen==================
    private JPanel panelWelcome;
    private JLabel lblWelcome;
    private JButton btnGameEasy;
    private JButton btnGameNorm;
    private JButton btnGameHard;
    private JButton btnThemes;
    private JButton btnRangList;

    //=====GameEasy Attributen=================
    private JPanel panelGameEasy;
    private JPanel panelGameEasyField;
    private JButton[][] buttonsGameEasy;
    private JButton btnGameEasyNewStart;
    private JButton btnGameEasyEnd;
    final int ROW_SIZE = 4;
    final int COLUMN_SIZE = 5;

    //=====GameNorm Attributen=================
    private JPanel panelGameNorm;
    private JPanel panelGameNormField;
    private JButton[][] buttonsGameNorm;
    private JButton btnGameNormNewStart;
    private JButton btnGameNormEnd;
    final int NORM_SIZE = 6;


    private JPanel panelGameHard;
    private JPanel panelGameHardField;
    private JButton[][] buttonsGameHard;
    private JButton btnGameHardNewStart;
    private JButton btnGameHardEnd;
    final int HARD_SIZE = 8;


    public GameView(GameModel model) {

        /*

        add(panelWelcome);
        contentPane.setVisability();
        */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        welcome();
    }

    private void welcome() {
        panelWelcome = new JPanel();
        panelWelcome.setBounds(0, 0, 734, 561);
        panelWelcome.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelWelcome.setLayout(null);

        lblWelcome = new JLabel("Willkommen zur Memory");
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 26));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(115, 75, 400, 60);
        panelWelcome.add(lblWelcome);

        btnGameEasy = new JButton("4 x 5");
        btnGameEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startEasy();
            }
        });
        btnGameEasy.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasy.setBounds(50, 220, 95, 45);
        panelWelcome.add(btnGameEasy);

        btnGameNorm = new JButton("6 x 6");
        btnGameNorm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startNorm();
            }
        });
        btnGameNorm.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNorm.setBounds(50, 276, 95, 45);
        panelWelcome.add(btnGameNorm);

        btnGameHard = new JButton("8 x 8");
        btnGameHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startHard();
            }
        });
        btnGameHard.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameHard.setBounds(50, 332, 95, 45);
        panelWelcome.add(btnGameHard);

        btnThemes = new JButton("Themen");
        btnThemes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnThemes.setHorizontalAlignment(SwingConstants.LEADING);
        btnThemes.setFont(new Font("Arial", Font.PLAIN, 15));
        btnThemes.setBounds(243, 276, 95, 45);
        panelWelcome.add(btnThemes);

        btnRangList = new JButton("Ranglist");
        btnRangList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRangList.setFont(new Font("Arial", Font.PLAIN, 15));
        btnRangList.setBounds(243, 332, 95, 45);
        panelWelcome.add(btnRangList);

        getContentPane().removeAll();
        getContentPane().add(panelWelcome);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void startEasy() {
        panelGameEasy = new JPanel();
        panelGameEasyField = new JPanel();
        panelGameEasy.setBounds(0, 0, 734, 561);
        panelGameEasyField.setBounds(0, 1, 734, 503);
        panelGameEasy.setLayout(null);
        panelGameEasyField.setLayout(new GridLayout(ROW_SIZE, COLUMN_SIZE));
        panelGameEasy.add(panelGameEasyField);
        buttonsGameEasy = new JButton[ROW_SIZE][COLUMN_SIZE];
        int index = 0;
        GameModel model = new GameModel();
        model.setDiff(1);
        model.createIcons();
        model.iconsShuffle();
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                buttonsGameEasy[i][j] = new JButton();
                buttonsGameEasy[i][j].setIcon(model.getIcon(index));
                panelGameEasyField.add(buttonsGameEasy[i][j]);
                index++;
            }
        }

        btnGameEasyEnd = new JButton("Beenden");
        btnGameEasyEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcome();
            }
        });
        btnGameEasyEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasyEnd.setBounds(607, 515, 105, 35);
        panelGameEasy.add(btnGameEasyEnd);

        btnGameEasyNewStart = new JButton("Neustarten");
        btnGameEasyNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startEasy();
            }
        });
        btnGameEasyNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameEasyNewStart.setBounds(479, 515, 105, 35);
        panelGameEasy.add(btnGameEasyNewStart);

        getContentPane().removeAll();
        getContentPane().add(panelGameEasy);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void startNorm() {
        panelGameNorm = new JPanel();
        panelGameNormField = new JPanel();
        panelGameNorm.setBounds(0, 0, 734, 561);
        panelGameNormField.setBounds(0, 1, 734, 503);
        panelGameNorm.setLayout(null);
        panelGameNormField.setLayout(new GridLayout(NORM_SIZE, NORM_SIZE));
        panelGameNorm.add(panelGameNormField);
        buttonsGameNorm = new JButton[NORM_SIZE][NORM_SIZE];
        int index = 0;
        GameModel model = new GameModel();
        model.setDiff(2);
        model.createIcons();
        model.iconsShuffle();

        for (int i = 0; i < NORM_SIZE; i++) {
            for (int j = 0; j < NORM_SIZE; j++) {
                buttonsGameNorm[i][j] = new JButton();
                buttonsGameNorm[i][j].setIcon(model.getIcon(index));
                panelGameNormField.add(buttonsGameNorm[i][j]);
                index++;
            }
        }

        btnGameNormEnd = new JButton("Beenden");
        btnGameNormEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcome();
            }
        });
        btnGameNormEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNormEnd.setBounds(607, 515, 105, 35);
        panelGameNorm.add(btnGameNormEnd);

        btnGameNormNewStart = new JButton("Neustarten");
        btnGameNormNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startNorm();
            }
        });
        btnGameNormNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameNormNewStart.setBounds(479, 515, 105, 35);
        panelGameNorm.add(btnGameNormNewStart);

        getContentPane().removeAll();
        getContentPane().add(panelGameNorm);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void startHard() {
        panelGameHard = new JPanel();
        panelGameHardField = new JPanel();
        panelGameHard.setBounds(0, 0, 734, 561);
        panelGameHardField.setBounds(0, 1, 734, 503);
        panelGameHard.setLayout(null);
        panelGameHardField.setLayout(new GridLayout(HARD_SIZE, HARD_SIZE));
        panelGameHard.add(panelGameHardField);
        buttonsGameHard = new JButton[HARD_SIZE][HARD_SIZE];
        int index = 0;
        GameModel model = new GameModel();
        model.setDiff(3);
        model.createIcons();
        model.iconsShuffle();
        for (int i = 0; i < HARD_SIZE; i++) {
            for (int j = 0; j < HARD_SIZE; j++) {
                buttonsGameHard[i][j] = new JButton();
                buttonsGameHard[i][j].setIcon(model.getIcon(index));
                panelGameHardField.add(buttonsGameHard[i][j]);
                index++;
            }
        }

        btnGameHardEnd = new JButton("Beenden");
        btnGameHardEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                welcome();
            }
        });
        btnGameHardEnd.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameHardEnd.setBounds(607, 515, 105, 35);
        panelGameHard.add(btnGameHardEnd);

        btnGameHardNewStart = new JButton("Neustarten");
        btnGameHardNewStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startHard();
            }
        });
        btnGameHardNewStart.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGameHardNewStart.setBounds(479, 515, 105, 35);
        panelGameHard.add(btnGameHardNewStart);

        getContentPane().removeAll();
        getContentPane().add(panelGameHard);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

}
