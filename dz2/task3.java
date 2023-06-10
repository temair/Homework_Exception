import java.util.Scanner;

public class EmptyStringExceptionExample {
    public static void main(String[] args) {
        try {
            String userInput = getStringInput();
            System.out.println("Введенная строка: " + userInput);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String getStringInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new Exception("Пустые строки вводить нельзя");
        }

        return input;
    }
}
