import java.io.IOException;
import java.util.Scanner;

public class Cage {
    private String answer;

    public Cage(String answer) {
        this.answer = answer;
    }

    public String getAnswerCode() { return answer; }

    public int getHintForCode() {
        System.out.print("\nНажмите *, чтобы получить подсказку\n");
        try {
            char symbol = (char) System.in.read(); // Читаем один символ

            // Очистка буфера: считываем оставшийся символ новой строки
            System.in.read();

            if (symbol == '*') return 0;
                else return 1; // Неверный ввод
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключения
            return -1; // Вернуться -1 в случае ошибки
        }
    }
    public void CodeOfCage(Level level, Game game, int number) {
        String input = ""; // Инициализируем input пустой строкой
        if (getHintForCode() == 0) {
            System.out.print("\nКод состоит из трёх символов. Чтобы найти каждый символ вам нужно:\n1) перевести число 127 в двоичную, восьмеричную и шестнадцатиричную системы счисления;\n2) каждый последний символ будет являться частью кода\nВсе буквы должны быть заглавными!\n\n");
            Scanner scanner = new Scanner(System.in);

            do {
                try {
                    System.out.print("\nВведите код:\n");
                    input = scanner.nextLine().trim().toUpperCase(); // Обрезаем пробелы и приводим к верхнему регистру

                    // Проверяем ввод на длину и символы
                    if (input.length() != 3) {
                        throw new IllegalArgumentException("Код должен состоять из 3-х символов.");
                    }

                    // Сравниваем input с кодом ответа
                    if (input.equals(getAnswerCode())) {
                        System.out.println("Ура! Вы освободили далматинца!");
                        level.DalmatinFound(game, number, 1);
                    } else {
                        game.PrintRepeatInput();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Неожиданная ошибка: " + e.getMessage());
                }
            } while (!input.equals(getAnswerCode()));

        } else {
            game.PrintRepeatInput();
        }
    }
}
