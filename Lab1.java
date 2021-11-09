import static java.lang.Math.*;
public class Lab1 {
    public static void main(String[] args) {
        // task1. Создать одномерный массив a типа short.
        // Заполнить его нечётными числами от 3 до 21 включительно в порядке убывания.
        final int SIZE_A = (21 - 3) / 2 + 1;
        short[] a = new short[SIZE_A];
        for (short i = 0, a_val = 21; i < SIZE_A; ++i) {
            a[i] = a_val;
            a_val -= 2;
        }
        // task2. Создать одномерный массив x типа float.
        // Заполнить его 15-ю случайными числами в диапазоне от -6.0 до 6.0.
        final int SIZE_X = 15;
        float[] x = new float[SIZE_X];
        for (int i = 0; i < SIZE_X; i++) {
            float r = (float)random();
            x[i] = r * 12.0F - (float)6.0;
        }
        // task3. Создать двумерный массив c размером 10x15.
        // Вычислить его элементы по данным формуле (где x = x[j]).
        final int S1 = 10, S2 = SIZE_X;
        double[][] c = new double[S1][S2];
        for (int i = 0; i < S1; i++) {
            // task 3.1; уходит в NaN
            if (a[i] == 3) {
                for (int j = 0; j < S2; j++) {
                    c[i][j] = pow((1 - pow(x[j], x[j] / 3) / 2) / 3, 2);
                    // тут NaN подпадает под случаи, описанные в документации о pow(a1, a2):
                    // If the first argument is finite and less than zero
                    // and if the second argument is finite and not an integer,
                    // then the result is NaN.
                }
            }
            // task 3.2
            else if (a[i] == 7 || a[i] == 11 || a[i] == 13
                    || a[i] == 17 || a[i] == 21) {
                for (int j = 0; j < S2; j++) {
                    c[i][j] = tan(pow(exp(x[j]), 1D / 3));
                }
            }
            // task 3.3; уходит в NaN
            else {
                for (int j = 0; j < S2; ++j) {
                    c[i][j] = sin(pow(sin(pow(x[j], x[j])) * (exp(x[j] * (x[j] + 3F)) - 1.0 / 3D), 2));
                    // тут NaN подпадает под случаи, описанные в документации о sin(a1, a2):
                    // If the argument is NaN or an infinity, then the result is NaN.
                    // А случаи с pow(a1, a2) объяснены выше.
                }
            }
        }
        // task4
        for (int i = 0; i < S1; i++) {
            for (int j = 0; j < S2; j++) {
                System.out.printf("\t%.3f", c[i][j]);
            }
            System.out.println();
        }
    }
}