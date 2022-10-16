import java.util.Scanner;

public class Resume {
    private static int[] stack1;
    private static int[] stack2;

    public static void main(String[] args) {
        int maxSalary = inputData();
        int[] amountOfSalaries = new int[stack1.length];
        amountOfSalaries[0] = stack1[0];
        for (int i = 1; i < stack1.length; i++) {
            amountOfSalaries[i] = amountOfSalaries[i - 1] + stack1[i];
        }
        int totalPaper = 0;
        if (stack1[0] <= maxSalary) {
            for (int i = stack1.length - 1; i >= 0; i--) {
                if (amountOfSalaries[i] < maxSalary) {
                    int maxSalaryTemp = amountOfSalaries[i];
                    for (int j = 0; j < stack2.length; j++) {
                        if (maxSalaryTemp + stack2[j] <= maxSalary)
                            maxSalaryTemp += stack2[j];
                        else {
                            if (totalPaper < i + j + 1)
                                totalPaper = i + j + 1;
                            break;
                        }
                        if (j == stack2.length - 1 && totalPaper < i + j + 2) totalPaper = i + j + 2;
                    }
                } else if (amountOfSalaries[i] == maxSalary && totalPaper < i + 1) {
                    totalPaper = i + 1;
                }
            }
        }
        if (stack2[0] <= maxSalary) {
            int maxSalaryTemp = stack2[0];
            for (int j = 1; j < stack2.length; j++) {
                if (maxSalaryTemp + stack2[j] < maxSalary)
                    maxSalaryTemp += stack2[j];
                else {
                    if (totalPaper < j) {
                        totalPaper = j;

                    }
                    break;
                }


                if (j == stack2.length - 1 && totalPaper < j + 1) totalPaper = j + 1;
            }
        }

        System.out.println(totalPaper);

    }

    private static int inputData() {
        Scanner scanner = new Scanner(System.in);
        int n, m, maxSalary;
        n = scanner.nextInt();
        m = scanner.nextInt();
        maxSalary = scanner.nextInt();
        stack1 = new int[n];
        stack2 = new int[m];
        int maxLeight = stack1.length > stack2.length ? stack1.length : stack2.length;
        for (int i = 0; i < maxLeight; i++) {
            if (scanner.hasNextInt()) stack1[i] = scanner.nextInt();
            else {
                char x = scanner.next().charAt(0);
            }
            if (scanner.hasNextInt()) stack2[i] = scanner.nextInt();
            else {
                char x = scanner.next().charAt(0);
            }
        }
        return maxSalary;
    }
}



