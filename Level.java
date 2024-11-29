import java.util.Scanner;
import java.util.InputMismatchException;


public class Level {
    public static final int MAX_DALMATIANS = 4;
    public static final int MAX_PLACE = 5;
    private String name;
    private int countDalmatins, countPlace;

    public Dalmatin[] dalmatins = new Dalmatin[MAX_DALMATIANS];
    public Cage cage;
    public Place[][] places = new Place[2][MAX_PLACE]; // Двумерный массив мест

    Level(boolean isBedroom) {
        // Инициализация далматинцев
        dalmatins[0] = new Dalmatin("Патч");
        dalmatins[1] = new Dalmatin("Пэдди");
        dalmatins[2] = new Dalmatin("Понго");
        dalmatins[3] = new Dalmatin("Ролли");

        // Инициализация места
        if (isBedroom) {
            name = "Спальня\n";
            countDalmatins = 3;
            places[0][0] = new Place("1. Шкаф", false);
            places[0][1] = new Place("2. Тумба", false);
            places[0][2] = new Place("3. Кровать", true);
            places[0][3] = new Place("4. Коробка", true);
            places[0][4] = new Place("5. Полка", true);
        } else {
            name = "Подвал\n";
            countDalmatins = 1;
            places[1][0] = new Place("1. Бочка", false);
            places[1][1] = new Place("2. Клетка", true);
            places[1][2] = new Place("3. Шкаф", false);

        }
    }

    public int getCountPlace() {
        return countPlace;
    }

    public int getCountDalmatins() {
        return countDalmatins;
    }

    public String getName() {
        return name;
    }

    public int PrintLocationPlace(int rowIndex, int countPlace) {
        // Печатаем места
        if (rowIndex < 0 || rowIndex > 1) {
            System.out.println("Ошибка: неверный индекс строки.");
            return -1; // Возвращаем -1 для обозначения ошибки
        }

        for (int i = 0; i < countPlace; i++) {
            if (places[rowIndex][i] != null) { // Необходимо проверить, что место не равно null
                System.out.println(places[rowIndex][i].getName());
            }
        }

        int numberPlace;
        Scanner scanner = new Scanner(System.in);
        // Проверка ввода
        while (true) {
            try {
                // Запрашиваем ввод от пользователя
                System.out.print("\nВведите пункт: ");
                numberPlace = scanner.nextInt();

                // Проверяем на корректность диапазона
                if (numberPlace < 1 || numberPlace > countPlace) {
                    throw new IllegalArgumentException("Ошибка: число должно быть в пределах от 1 до " + countPlace + ".");
                }

                scanner.nextLine(); // Очищаем буфер ввода
                return numberPlace; // Возвращаем корректный номер места
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите корректное целое число.");
                scanner.nextLine(); // Очищаем некорректный ввод
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }
        }
    }

    public void ViewingFoundDalmatians(Game player) {
        System.out.printf("\nВы нашли %d/%d далматинцев:\n", player.getCountDalmatins(), MAX_DALMATIANS);
        for (int i = 0; i < player.getCountDalmatins(); i++) {
            System.out.println(dalmatins[i].getName());
        }
    }

    public void DalmatinFound(Game player, int number, int rowIndex) {
        if (places[rowIndex][number - 1].getExistDalmatian()) {
            player.PlusOne();
            places[rowIndex][number - 1].setExistDalmatian(false);
            ViewingFoundDalmatians(player);
        } else {
            System.out.println("Увы, здесь никого нет\n");
        }
    }
