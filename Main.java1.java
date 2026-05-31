/**
 * Лабораторна робота №1
 * Варіант: залікова книжка 5601
 *   C2=1 -> O1=-   C3=0 -> C=0
 *   C5=1 -> O2=/   C7=1 -> тип=short
 * Формула: S = sum(i=a..m) sum(j=b..n) (i / j) / (i - C)
 */
public class Main {

    public static void main(String[] args) {

        // Межі підсумовування (тип short, C7 = 1)
        short a = 1, b = 1, m = 5, n = 5;

        // Константа C = C3 = 5601 % 3 = 0
        final int C = 0;

        // Результат — єдине значення дійсного типу
        double S = 0.0;

        // short i++ не компілюється: Java розширює short до int,
        // тому оновлення записується як i = (short)(i + 1)
        for (short i = a; i <= m; i = (short)(i + 1)) {
            for (short j = b; j <= n; j = (short)(j + 1)) {
                try {

                    // Перевірка ділення на нуль: O2 = /, знаменник j
                    if (j == 0) {
                        throw new ArithmeticException("j = 0");
                    }

                    // Перевірка ділення на нуль: O1 = -, знаменник (i - C)
                    if (i - C == 0) {
                        throw new ArithmeticException("i - C = 0, i = " + i);
                    }

                    // (i O2 j) / (i O1 C) = (i / j) / (i - C)
                    S += ((double) i / j) / (i - C);

                } catch (ArithmeticException e) {
                    System.out.println("Виняткова ситуація: " + e.getMessage());
                }
            }
        }

        System.out.printf("S = %.6f%n", S);
    }
}
