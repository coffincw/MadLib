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

    String[] partsOfSpeech = {"Give a noun:", "Give a verb:", "Give an adverb", "Give an adjective", "pronoun"};

    ArrayList<JButton> button=new ArrayList<>();
    ArrayList<JTextField> textInput = new ArrayList<>();
    ArrayList<JTextField> textOutput = new ArrayList<>();

    public MadLibMain() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);

        mainPanel = new MLibPanel();
        mainFrame.setContentPane(mainPanel);

        mainPanel.setBackground(Color.PINK);
        mainPanel.add(new JLabel("Enter a noun:"));






        for (int b = 0 ; b <= 10 ; b++) {
            textInput.add(new JTextField(20));
            Font font1 = new Font("SansSerif", Font.BOLD, 12);
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



        textFieldA = new JTextArea();
        textFieldA.setColumns(10);
        textFieldA.setEditable(false);
        mainPanel.add(textFieldA);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MadLibMain mainWindow = new MadLibMain();
    }

    public void actionPerformed(ActionEvent e) {
        for (int b = 0 ; b <= 10 ; b++) {
            if (e.getSource() == button.get(b)) {
                System.out.println(textInput.get(b).getText());
                textOutput.get(b).setText(textInput.get(b).getText());
            }
        }
        if (e.getSource() == buttonC) {

        }
    }
}
