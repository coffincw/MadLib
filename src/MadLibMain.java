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

    String[] partsOfSpeech = {"noun:", "verb:", "adverb:", "adjective:", "pronoun", "preposition:", "conjunction:", "interjection:", "name:"};
    int[] piratesCovePOS = {0, 8, 2, 0, 3, 2, 4, 1};

    ArrayList<JButton> button=new ArrayList<>();
    ArrayList<JTextField> textInput = new ArrayList<>();
    ArrayList<JTextField> textOutput = new ArrayList<>();

    public MadLibMain() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 600);
        mainFrame.setVisible(true);

        mainPanel = new MLibPanel();
        mainFrame.setContentPane(mainPanel);

        mainPanel.setBackground(Color.orange);
        count = 0;

        for (int b = 0 ; b < 7 ; b++) {
            count++;
            poS(piratesCovePOS);
            textInput.add(new JTextField(20));
            Font font1 = new Font("ComicSans", Font.BOLD, 12);
            textInput.get(b).setFont(font1);
            mainPanel.add(textInput.get(b));

            button.add(new JButton("Lock In!"));
            mainPanel.add(button.get(b));
            button.get(b).addActionListener(this);

            textOutput.add(new JTextField(20));
            mainPanel.add(new JLabel("      "));
            textOutput.get(b).setEditable(false);
            mainPanel.add(textOutput.get(b));
        }





        buttonC = new JButton("Generate Mad Lib");
        mainPanel.add(buttonC);
        buttonC.addActionListener(this);





        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MadLibMain mainWindow = new MadLibMain();
    }

    public void poS (int[] sheet) {
        for (int l = 0 ; l <= 7 ; l++) {
            if (l == count) {
                mainPanel.add(new JLabel(partsOfSpeech[sheet[l]]));
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int b = 0 ; b <= 7 ; b++) {
            if (e.getSource() == button.get(b)) {
                System.out.println(textInput.get(b).getText());
                textOutput.get(b).setText(textInput.get(b).getText());
            }
        }
        if (e.getSource() == buttonC) {
            textFieldA = new JTextArea("There once was a pirate named " + textInput.get(0) + " who loved to sail the seven seas" +
                    "\nWhile " + textInput.get(0) + " was known for " + textInput.get(3) + " completing the " + textInput.get(2) + "." +
                    "\nKnow one knew of " + textInput.get(0) + "'s passion to " + textInput.get(2) + "." +
                    "\n");
            textFieldA.setColumns(10);
            textFieldA.setEditable(false);
            mainPanel.add(textFieldA);
        }
    }
}
