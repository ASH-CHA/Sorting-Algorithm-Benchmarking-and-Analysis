# Sorting Algorithm Benchmarking and Analysis

## Description

This project benchmarks and compares the performance of **Selection Sort** and **Merge Sort** using empirical analysis. Each algorithm is evaluated based on **critical operation counts** and **execution time** across multiple input sizes and repeated trials. The results are written to output files and later analyzed and displayed in a graphical table.

The project emphasizes **algorithm analysis**, **runtime measurement**, **statistical variation**, and **software design using abstraction**.

---

## How It Works

### 1. Benchmark Execution (`BenchmarkSorts`)

* The program runs benchmarks for:

  * **Selection Sort**
  * **Merge Sort**
* For each algorithm:

  * Array sizes range from **100 to 1200**, increasing by 100.
  * Each size is tested **40 times** using randomly generated integer arrays.
* For every run:

  * The array is sorted
  * The **critical operation count** is recorded
  * The **execution time (nanoseconds)** is recorded
* Results are written to:

  * `selection.txt`
  * `merge.txt`

Each output line follows this format:

```
<size> <count1> <time1> <count2> <time2> ... <count40> <time40>
```

---

### 2. Sorting Framework (`AbstractSort`)

* Provides shared benchmarking logic:

  * Timing (start/end)
  * Critical operation counting
* Ensures consistency across all sorting implementations.
* Requires subclasses to implement the `sort()` method.

---

### 3. Sorting Implementations

* **SelectionSort**

  * Counts **comparisons** between elements.
* **MergeSort**

  * Counts **comparisons during the merge phase**.
* Both algorithms:

  * Verify correctness after sorting
  * Throw `UnsortedException` if sorting fails

---

### 4. Report Generation (`BenchmarkReport`)

* Allows the user to select a benchmark file (`merge.txt` or `selection.txt`)
* Computes:

  * Average critical operation count
  * Coefficient of variation (count)
  * Average execution time
  * Coefficient of variation (time)
* Displays results in a **Swing GUI table**

---

## Program Structure

* **`AbstractSort.java`** – Shared timing and counting logic
* **`SelectionSort.java`** – Selection sort with comparison counting
* **`MergeSort.java`** – Merge sort with merge-phase counting
* **`BenchmarkSorts.java`** – Executes benchmarks and writes output files
* **`BenchmarkReport.java`** – Reads benchmark files and displays statistics
* **`UnsortedException.java`** – Ensures sorting correctness

---

## How to Run

### Compile

```bash
javac *.java
```

### Run Benchmarks

```bash
java BenchmarkSorts
```

This generates:

* `selection.txt`
* `merge.txt`

### Generate Report

```bash
java BenchmarkReport
```

Select either output file when prompted.

---

## Screenshots

1. **Benchmark Execution**

   * Console showing `BenchmarkSorts` running successfully.
   * <img width="958" height="1032" alt="Screenshot 2025-12-29 025349" src="https://github.com/user-attachments/assets/52ea96d2-69b1-4824-ae15-c572875a473f" />

2. **Generated Output Files**

   * Screenshot of `selection.txt` and/or `merge.txt` contents.
   * **selection.txt**
   * <img width="958" height="1030" alt="Screenshot 2025-12-29 025606" src="https://github.com/user-attachments/assets/730aba58-513c-4922-a7fb-339c176e0499" />

   * **merge.txt**
   * <img width="957" height="1032" alt="Screenshot 2025-12-29 025652" src="https://github.com/user-attachments/assets/45544e64-40f7-465d-aab5-583deb8c33a9" />

3. **File Selection Dialog**

   * `JFileChooser` window when selecting a benchmark file.
   * <img width="498" height="352" alt="Screenshot 2025-12-29 025757" src="https://github.com/user-attachments/assets/3d801538-0d66-41f1-b7e1-7aafec9d5231" />

4. **Benchmark Report Table**

   * Swing GUI table displaying:

     * Size
     * Average count
     * Coefficient of variation (count)
     * Average time
     * Coefficient of variation (time)
    
     Benchmark Report for **selection.txt**
     * <img width="584" height="391" alt="Screenshot 2025-12-29 030032" src="https://github.com/user-attachments/assets/be3aac86-d397-4f7e-bdcc-d8d61e72e2ab" />

5. **Side-by-Side Comparison**

   * Two report windows open (Merge vs. Selection) for visual comparison.
   
   * **selection.txt**
   <img width="584" height="391" alt="Screenshot 2025-12-29 030032" src="https://github.com/user-attachments/assets/e25b2458-371f-4cff-8c0c-f1dcfdf08f25" />

   * **merge.txt**
   <img width="580" height="387" alt="Screenshot 2025-12-29 030305" src="https://github.com/user-attachments/assets/90b30221-2b77-4703-a2c1-34f44f49d25c" />

---

## Concepts Demonstrated

* Algorithm analysis and benchmarking
* Abstract classes and inheritance
* Runtime measurement (`System.nanoTime`)
* Statistical analysis (mean, standard deviation, coefficient of variation)
* File I/O
* GUI development with Swing
* Defensive programming and correctness verification

---

## Notes

* Merge Sort implementation is adapted from **GeeksforGeeks**, with modifications for benchmarking.
* Random input ensures unbiased performance measurement.
* JVM warm-up effects are mitigated through repeated runs.
  
