import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by caleb on 3/20/17.
 */

public class MadLibMain implements ActionListener {
    static JFrame mainFrame;
    static MLibPanel mainPanel;
    static JButton buttonC;
    static JTextArea textFieldA;
    int count;
    String lib;
    int POS;

    String[] partsOfSpeech = {"noun:", "verb:", "adverb:", "adjective:", "pronoun", "preposition:", "conjunction:", "interjection:", "name:", "plural noun:", "verb(ing):", "number:"};
    int[] piratesCovePOS = {0, 8, 2, 0, 3, 2, 4, 1};
    int[] solarSystemPOS = {0, 3, 0, 3, 9, 2, 10, 9, 3, 9, 8, 3, 11, 8, 8, 8, 8, 8, 8, 9};

    JTextField[] textInput2;
    JTextField[] textOutput2;
    JButton[] button2;

    public MadLibMain() {
        lib = "Solar System";
        POS = solarSystemPOS.length - 1;
        textInput2 = new JTextField[19];
        textOutput2 = new JTextField[19];
        button2 = new JButton[19];
        mainFrame = new JFrame();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (lib.equals("Solar System")) {
            mainFrame.setSize(695, 600);
        } else if (lib.equals("Pirates Cove")) {
            mainFrame.setSize(700, 600);
        }
        mainFrame.setVisible(true);

        mainPanel = new MLibPanel();
        mainFrame.setContentPane(mainPanel);

        mainPanel.setBackground(Color.orange);
        count = 0;

        for (int b = 0; b < POS; b++) {
            count++;
            poS(solarSystemPOS);
            textInput2[b] = new JTextField(20);
            Font font1 = new Font("ComicSans", Font.BOLD, 12);
            textInput2[b].setFont(font1);
            mainPanel.add(textInput2[b]);

            button2[b] = new JButton("Lock In!");
            mainPanel.add(button2[b]);
            button2[b].addActionListener(this);

            textOutput2[b] = new JTextField(20);
            mainPanel.add(new JLabel("      "));
            textOutput2[b].setEditable(false);
            mainPanel.add(textOutput2[b]);
        }


        buttonC = new JButton("Generate Mad Lib");
        mainPanel.add(buttonC);
        buttonC.addActionListener(this);


        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MadLibMain mainWindow = new MadLibMain();
    }

    public void poS(int[] sheet) {
        for (int l = 0; l <= POS; l++) {
            if (l == count) {
                mainPanel.add(new JLabel(partsOfSpeech[sheet[l]]));
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int b = 0; b <= POS-1; b++) {
            if (e.getSource() == button2[b]) {
//                System.out.println(textInput2[b].getText());
                textOutput2[b].setText(textInput2[b].getText());
            }

        }
        if (e.getSource() == buttonC) {
            if (lib.equals("Pirates Cove")) {
//                textFieldA = new JTextArea("There once was a pirate named " + textInput.get(0) + " who loved to sail the seven seas" +
//                        "\nWhile " + textInput.get(0) + " was known for " + textInput.get(3) + " completing the " + textInput.get(2) + "." +
//                        "\nKnow one knew of " + textInput.get(0) + "'s passion to " + textInput.get(2) + "." +
//                        "\n");
//                textFieldA.setColumns(10);
            } else if (lib.equals("Solar System")) {
                String SS = "When we look up into the sky on a/an " + textOutput2[0] + " summer" +
                        "\nnight, we see millions of tiny spots of light.  Each one represents a/an " +
                        "\n" + textOutput2[1] + " which is the center of a/an " + textOutput2[2] + "" +
                        "\n solar system with dozens of " + textOutput2[3] + " revolving" +
                        "\n" + textOutput2[4] + " around a distant sun.  Sometimes these suns expand and" +
                        "\n begin " + textOutput2[5] + " their neighbors.  Soon they will become so" +
                        "\nbig, they will turn into " + textOutput2[6] + ".  Eventually they subside" +
                        "\nand become " + textOutput2[7] + " giants or perhaps black " + textOutput2[8] + "." +
                        "\nOur own planet, which we call " + textOutput2[9] + ", circles around" +
                        "\nour " + textOutput2[10] + " sun " + textOutput2[11] + " times every year. There are eight other" +
                        "\nplanets in our solar system.  They are named " + textOutput2[12] + ", " + textOutput2[13] + "," +
                        "\n" + textOutput2[14] + "," + textOutput2[15] + "," + textOutput2[16] + "," +
                        "\n" + textOutput2[17] + ", Jupiter, and Mars.  Scientists who study these" +
                        "\nplanets are called " + textOutput2[18] + ".";
                mainPanel.add(new JTextArea(SS));
            }
        }
    }
}
