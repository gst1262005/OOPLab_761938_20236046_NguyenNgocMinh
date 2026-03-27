import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Equation Solver Menu ===");
            System.out.println("1. Solve linear equation (ax + b = 0)");
            System.out.println("2. Solve system of linear equations");
            System.out.println("3. Solve quadratic equation (ax^2 + bx + c = 0)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    solveLinear(scanner);
                    break;
                case 2:
                    solveSystem(scanner);
                    break;
                case 3:
                    solveQuadratic(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // --- Linear equation ax + b = 0 ---
    static void solveLinear(Scanner scanner) {
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

    // --- System of linear equations ---
    static void solveSystem(Scanner scanner) {
        System.out.println("Equation 1: a1*x + a2*y = b1");
        System.out.println("Equation 2: a3*x + a4*y = b2");

        System.out.print("Enter a1: "); double a1 = scanner.nextDouble();
        System.out.print("Enter a2: "); double a2 = scanner.nextDouble();
        System.out.print("Enter b1: "); double b1 = scanner.nextDouble();
        System.out.print("Enter a3: "); double a3 = scanner.nextDouble();
        System.out.print("Enter a4: "); double a4 = scanner.nextDouble();
        System.out.print("Enter b2: "); double b2 = scanner.nextDouble();

        double D  = a1 * a4 - a2 * a3;
        double Dx = b1 * a4 - b2 * a2;
        double Dy = a1 * b2 - a3 * b1;

        if (D != 0) {
            double x = Dx / D;
            double y = Dy / D;
            System.out.println("Unique solution: x = " + x + ", y = " + y);
        } else {
            if (Dx == 0 && Dy == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        }
    }

    // --- Quadratic equation ax^2 + bx + c = 0 ---
    static void solveQuadratic(Scanner scanner) {
        System.out.print("Enter a: "); double a = scanner.nextDouble();
        System.out.print("Enter b: "); double b = scanner.nextDouble();
        System.out.print("Enter c: "); double c = scanner.nextDouble();

        if (a == 0) {
            // Degenerates to linear equation
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions.");
                } else {
                    System.out.println("No solution.");
                }
            } else {
                double x = -c / b;
                System.out.println("Linear solution: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Two distinct roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Double root: x = " + x);
            } else {
                System.out.println("No real roots.");
            }
        }
    }
}