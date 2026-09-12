import javax.swing.*;
import java.awt.*;

public class StudentTracker extends JFrame {
    private int[] scores = {45, 72, 91, 38, 64, 50, 83, 27, 76, 88};
    private JTextArea reportArea;

    public StudentTracker() {
        setTitle("Exam Score Summary Report");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Exam Performance Summary", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(titleLabel, BorderLayout.NORTH);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        reportArea.setLineWrap(true);
        reportArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(reportArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton generateButton = new JButton("Generate Summary Report");
        generateButton.setFont(new Font("Arial", Font.BOLD, 16));
        generateButton.addActionListener(e -> reportArea.setText(createSummaryReport()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        reportArea.setText(createSummaryReport());
    }

    private String createSummaryReport() {
        int total = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int passed = 0;

        StringBuilder fullReport = new StringBuilder();
        fullReport.append("Exam Score Summary Report\n");
        fullReport.append("=========================\n\n");

        for (int score : scores) {
            fullReport.append("Score: ").append(score).append("\n");
            total += score;

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }

            if (score >= 50) {
                passed++;
            }
        }

        double average = (double) total / scores.length;

        fullReport.append("\nTotal Score: ").append(total).append("\n");
        fullReport.append("Average Score: ").append(String.format("%.2f", average)).append("\n");
        fullReport.append("Highest Score: ").append(highest).append("\n");
        fullReport.append("Lowest Score: ").append(lowest).append("\n");
        fullReport.append("Number of Students Passed: ").append(passed).append("\n");

        return fullReport.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentTracker app = new StudentTracker();
            app.setVisible(true);
        });
    }
}
