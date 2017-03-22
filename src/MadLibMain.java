import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    ArrayList<JButton> button = new ArrayList<>();
    ArrayList<JTextField> textInput = new ArrayList<>();
    ArrayList<JTextField> textOutput = new ArrayList<>();

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
            // textInput.add(new JTextField(20));
            textInput2[b] = new JTextField(20);
            Font font1 = new Font("ComicSans", Font.BOLD, 12);
            //textInput.get(b).setFont(font1);
            textInput2[b].setFont(font1);
            //mainPanel.add(textInput.get(b)
            mainPanel.add(textInput2[b]);

            button2[b] = new JButton("Lock In!");
            mainPanel.add(button2[b]);
            button2[b].addActionListener(this);

            //textOutput.add(new JTextField(20));
            textOutput2[b] = new JTextField(20);
            mainPanel.add(new JLabel("      "));
            //textOutput.get(b).setEditable(false);
            textOutput2[b].setEditable(false);
            //mainPanel.add(textOutput.get(b));
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
        for (int b = 0; b <= POS; b++) {
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
                textFieldA = new JTextArea("When we look up into the sky on a/an " + textInput2[0] + " summer" +
                        "\nnight, we see millions of tiny spots of light.  Each one represents a/an " +
                        "\n" + textInput2[1] + " which is the center of a/an " + textInput2[2] + "" +
                        "\n solar system with dozens of " + textInput2[3] + " revolving" +
                        "\n" + textInput2[4] + " around a distant sun.  Sometimes these suns expand and" +
                        "\n begin " + textInput2[5] + " their neighbors.  Soon they will become so" +
                        "\nbig, they will turn into " + textInput2[6] + ".  Eventually they subside" +
                        "\nand become " + textInput2[7] + " giants or perhaps black " + textInput2[8] + "." +
                        "\nOur own planet, which we call " + textInput2[9] + ", circles around" +
                        "\nour " + textInput2[10] + " sun " + textInput2[11] + " times every year. There are eight other" +
                        "\nplanets in our solar system.  They are named " + textInput2[12] + ", " + textInput2[13] + "," +
                        "\n" + textInput2[14] + "," + textInput2[15] + "," + textInput2[16] + "," +
                        "\n" + textInput2[17] + ", Jupiter, and Mars.  Scientists who study these" +
                        "\nplanets are called " + textInput2[18] + ".");
            }
            textFieldA.setEditable(false);
            mainPanel.add(textFieldA);
        }
    }
}
