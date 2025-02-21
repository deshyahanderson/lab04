package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;
    JLabel titleLbl;
    ImageIcon icon;
    JTextArea displayTA;
    JScrollPane scroller;
    JButton readFortuneBtn;
    JButton quitBtn;

    Random rnd = new Random();

    Font titleFont = new Font("Serif", Font.PLAIN, 48);
    Font buttonFont = new Font("Arial", Font.BOLD, 20);
    Font fortuneFont = new Font("Serif", Font.ITALIC, 24);

    String[] fortunes = {
            "You will find a pot of gold where the rainbow ends... but you forgot your shovel.",
            "An alien abduction may be in your future. Remember to smile for the cameras!",
            "Your attempt to make coffee today will result in an unexpected science experiment.",
            "Avoid anything triangular on Tuesday.",
            "The stars predict that you will spill something on yourself in the near future.",
            "A thrilling opportunity awaits you, but it involves wearing a silly hat.",
            "Your pet is planning world domination. Give extra treats to delay the plan.",
            "You will soon receive a fortune cookie that contains no fortune.",
            "A flock of seagulls will judge your parking skills.",
            "Be prepared to explain a strange charge on your credit card.",
            "The next time you lose something, it will turn up in the most obvious place.",
            "Your shoes will fail you at the worst possible moment."
    };
    private int lastFortuneIndex = -1; // To keep track of the last fortune

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void createTopPanel() {
        topPnl = new JPanel();
        icon = new ImageIcon("src/fortuneTeller.jpg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setFont(titleFont);
        topPnl.add(titleLbl);
    }

    private void createMiddlePanel() {
        middlePnl = new JPanel();
        displayTA = new JTextArea(10, 25);
        displayTA.setEditable(false);
        displayTA.setFont(fortuneFont);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);
    }

    private void createBottomPanel() {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));
        readFortuneBtn = new JButton("Read My Fortune!");
        readFortuneBtn.setFont(buttonFont);
        readFortuneBtn.addActionListener((ActionEvent ae) -> {
            String fortune = generateFortune();
            displayTA.append(fortune + "\n");
        });

        quitBtn = new JButton("Quit");
        quitBtn.setFont(buttonFont);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(readFortuneBtn);
        bottomPnl.add(quitBtn);
    }

    private String generateFortune() {
        int index;
        do {
            index = rnd.nextInt(fortunes.length);
        } while (index == lastFortuneIndex); // Ensure different from the last one
        lastFortuneIndex = index; // Remember this index for the next call
        return fortunes[index];
    }

    public static void main(String[] args) {
        FortuneTellerFrame frame = new FortuneTellerFrame();
    }
}