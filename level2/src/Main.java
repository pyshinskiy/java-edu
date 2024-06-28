import java.util.Random;
import java.util.Scanner;

/*
    Вариант программы для уровня, на котором ученик знаком со следующими темами:
    1 - переменные и типы данных
    2 - массивы
    3 - работа с консолью
    4 - if-else
    5 - switch
    6 - циклы
    7 - конкатенация строк
    8 - сравнение строк через equals
    9 - методы (объявление и вызов, тип возвращаемого значения, сигнатура метода)
 */
public class Main {

    public static void main(String[] args) {
        String fighter1 = "первого";
        String fighter2 = "второго";

        Scanner scanner = new Scanner(System.in);

        String firstFighterName = getName(scanner, fighter1);
        int firstFighterHealth = getHealth(scanner, fighter1);
        int[] firstFighterDamages = getDamages(scanner, fighter1);

        String secondFighterName = getName(scanner, fighter2);
        int secondFighterHealth = getHealth(scanner, fighter2);
        int[] secondFighterDamages = getDamages(scanner, fighter2);

        System.out.println("Начать бой? (введите \"да\" или \"нет\")");
        if ("да".equals(scanner.nextLine())) {

            String currentFighterName = firstFighterName;

            while(firstFighterHealth > 0 && secondFighterHealth > 0) {
                int hit = new Random().nextInt(3);
                String hitName = "";
                switch (hit) {
                    case 0 -> hitName = "слабый";
                    case 1 -> hitName = "обычный";
                    case 2 -> hitName = "сильный";
                }
                if (currentFighterName.equals(firstFighterName)) {
                    secondFighterHealth = makeFightRound(
                            firstFighterName,
                            firstFighterDamages,
                            hit,
                            hitName,
                            secondFighterName,
                            secondFighterHealth
                    );
                    currentFighterName = secondFighterName;
                }
                else {
                    firstFighterHealth = makeFightRound(
                            secondFighterName,
                            secondFighterDamages,
                            hit,
                            hitName,
                            firstFighterName,
                            firstFighterHealth
                    );
                    currentFighterName = firstFighterName;
                }
            }

            String winner = currentFighterName.equals(secondFighterName) ? firstFighterName : secondFighterName;
            System.out.println("Победил " + winner + "!");
        }
        else {
            System.out.println("Вы решили не начинать бой, программа завершена");
        }
    }

    public static String getName(Scanner scanner, String fighter) {
        System.out.println("Введите имя " +  fighter + " бойца");
        return scanner.nextLine();
    }

    public static int getHealth(Scanner scanner, String fighter) {
        System.out.println("Введите здоровье " +  fighter + " бойца");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] getDamages(Scanner scanner, String fighter) {
        int[] fighterDamages = new int[3];
        System.out.println("Введите урон слабого удара " +  fighter + " бойца");
        fighterDamages[0] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон обычного удара " +  fighter + " бойца");
        fighterDamages[1] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон сильного удара " +  fighter + " бойца");
        fighterDamages[2] = Integer.parseInt(scanner.nextLine());
        return fighterDamages;
    }

    public static int makeFightRound(
            String fighterName,
            int[] fighterDamages,
            int hit,
            String hitName,
            String victimName,
            int victimHealth
    ) {
        int damage = fighterDamages[hit];
        System.out.println(fighterName + " наносит " + hitName + " удар с уроном = " + damage);
        victimHealth = victimHealth - damage;
        System.out.println("Здоровье " + victimName + " = " + victimHealth);
        return victimHealth;
    }
}
