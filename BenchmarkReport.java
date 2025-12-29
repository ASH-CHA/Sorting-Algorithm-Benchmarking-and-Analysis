/*
 * Ashton Chavez
 * CMSC-451
 * April 8, 2025
 * 
 * Second Program that generates the benchmark reports for merge.txt and selection.txt
 * Reads a benchmark result file and displays:
 * - Data set size
 * - Average critical count
 * - Coefficient of variation (count)
 * - Average time (ns)
 * - Coefficient of variation (time)
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class BenchmarkReport {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        // Lets user pick file
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                List<String[]> rows = new ArrayList<>();
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.trim().split(" ");
                    int size = Integer.parseInt(parts[0]);

                    List<Integer> counts = new ArrayList<>();
                    List<Long> times = new ArrayList<>();

                    for (int i = 1; i < parts.length; i += 2) {
                        if (parts[i].equals("ERROR")) continue;
                        counts.add(Integer.parseInt(parts[i]));
                        times.add(Long.parseLong(parts[i + 1]));
                    }

                    double avgCount = counts.stream().mapToInt(x -> x).average().orElse(0);
                    double stdDevCount = Math.sqrt(counts.stream().mapToDouble(x -> Math.pow(x - avgCount, 2)).sum() / counts.size());
                    double coefCount = (avgCount == 0) ? 0 : (stdDevCount / avgCount) * 100;

                    double avgTime = times.stream().mapToLong(x -> x).average().orElse(0);
                    double stdDevTime = Math.sqrt(times.stream().mapToDouble(x -> Math.pow(x - avgTime, 2)).sum() / times.size());
                    double coefTime = (avgTime == 0) ? 0 : (stdDevTime / avgTime) * 100;

                    rows.add(new String[] {
                            String.valueOf(size),
                            String.format("%.2f", avgCount),
                            String.format("%.2f%%", coefCount),
                            String.format("%.2f", avgTime),
                            String.format("%.2f%%", coefTime)
                    });
                }

                String[] columns = {"Size", "Avg Count", "Coef Count", "Avg Time", "CoefTime"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (String[] row : rows) {
                    model.addRow(row);
                }

                // Displays report in GUI
                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);

                JFrame frame = new JFrame("Benchmark Report");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(scrollPane);
                frame.setSize(600, 400);
                frame.setVisible(true);

                scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            }
        }
    }
}