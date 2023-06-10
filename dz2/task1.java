import java.util.Scanner;

public class FloatInput {
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float input;

        while (true) {
            System.out.print("Введите дробное число: ");

            try {
                input = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }

        return input;
    }

    public static void main(String[] args) {
        float floatValue = getFloatInput();
        System.out.println("Введенное число: " + floatValue);
    }
}
