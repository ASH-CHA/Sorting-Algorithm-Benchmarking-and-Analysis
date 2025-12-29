/*
 * Ashton Chavez
 * CMSC-451
 * April 8, 2025
 * 
 * First Program that executes benchmarks for both sorting algorithms and 
 * writes results to output files selection.txt and merge.txt.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkSorts {
    private static final int RUNS = 40;
    private static final int[] SIZES = new int[12];

    static {
        for (int i = 0; i < 12; i++) {
            SIZES[i] = (i + 1) * 100;
        }
    }

    public static void main(String[] args) throws IOException {
        benchmarkSort(new SelectionSort(), "selection.txt");
        benchmarkSort(new MergeSort(), "merge.txt");
    }

    private static void benchmarkSort(AbstractSort sorter, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        Random rand = new Random();

        for (int size : SIZES) {
            writer.write(size + " ");

            int[][] dataSets = new int[RUNS][size];
            for (int i = 0; i < RUNS; i++) {
                for (int j = 0; j < size; j++) {
                    dataSets[i][j] = rand.nextInt();
                }
            }

            for (int i = 0; i < RUNS; i++) {
                int[] data = Arrays.copyOf(dataSets[i], size);
                try {
                    sorter.sort(data);
                    writer.write(sorter.getCount() + " " + sorter.getTime() + " ");
                } catch (UnsortedException e) {
                    writer.write("ERROR ERROR ");
                }
            }

            writer.write("\n");
        }

        writer.close();
    }
}