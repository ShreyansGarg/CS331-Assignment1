## README for Simpson Integration Program

### Description
This Java program approximates the integral of the function \( \frac{1}{\sqrt{2\pi}} e^{-x^2/2} \) over the interval \([-1, 1]\) using the **composite Simpson's 1/3 rule**. The program is multithreaded and allows the user to specify the number of threads to use for computation.

### Requirements
- Java Development Kit (JDK) installed on your system.
- A terminal or command prompt to compile and run the program.

### How to Compile and Run
1. **Save the Program**:
   - Save the program in a file named `SimpsonIntegration.java`.

2. **Compile the Program**:
   - Open a terminal or command prompt and navigate to the directory where the program is saved.
   - Compile the program using the following command:
     ```sh
     javac SimpsonIntegration.java
     ```

3. **Run the Program**:
   - Run the program by specifying the number of threads as a command-line argument. For example, to use 8 threads:
     ```sh
     java SimpsonIntegration 8
     ```

### Command-Line Arguments
- The program requires one command-line argument:
  - `<number_of_threads>`: The number of threads to use for computation (e.g., 4, 8, 16).

### Output
- The program will output the approximate value of the integral computed using the specified number of threads and the time taken to do so.

### Example
```sh
javac SimpsonIntegration.java
java SimpsonIntegration 8
```

Output:
```
Integral value: 0.6826894921370761
Execution time: 50.3498 milliseconds
```

### Notes
- The program uses the composite Simpson's 1/3 rule for numerical integration.
- The number of points used for integration is fixed at \( 10^6 \).
- The program demonstrates how multithreading can be used to parallelize numerical computations.

---

## README for Matrix Multiplication Program

### Description
This Java program performs matrix multiplication \( C = A \times B \) for two square matrices \( A \) and \( B \) of size \( 1000 \times 1000 \). The matrices are initialized with random values between 0 and 10. The program is multithreaded and allows the user to specify the number of threads to use for computation.

### Requirements
- Java Development Kit (JDK) installed on your system.
- A terminal or command prompt to compile and run the program.

### How to Compile and Run
1. **Save the Program**:
   - Save the program in a file named `MatrixMultiplication.java`.

2. **Compile the Program**:
   - Open a terminal or command prompt and navigate to the directory where the program is saved.
   - Compile the program using the following command:
     ```sh
     javac MatrixMultiplication.java
     ```

3. **Run the Program**:
   - Run the program by specifying the number of threads as a command-line argument. For example, to use 8 threads:
     ```sh
     java MatrixMultiplication 8
     ```

### Command-Line Arguments
- The program requires one command-line argument:
  - `<number_of_threads>`: The number of threads to use for computation (e.g., 8, 10, 50, 100, 500).

### Output
- The program will print the time of execution of code.

### Example
```sh
javac MatrixMultiplication.java
java MatrixMultiplication 8
```

Output:
```
Matrix multiplication completed.
Execution time: 844.9204 milliseconds
```

### Notes
- The program demonstrates how multithreading can be used to parallelize matrix multiplication.
- The matrices are initialized with random values between 0 and 10.
- Only the first \( 10 \times 10 \) portion of the matrices is printed to avoid overwhelming the console with output.

---
