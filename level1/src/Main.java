import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String firstFighterName;
        int firstFighterHealth;
        int[] firstFighterDamages = new int[3];

        String secondFighterName;
        int secondFighterHealth;
        int[] secondFighterDamages = new int[3];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя первого бойца");
        firstFighterName = scanner.nextLine();
        System.out.println("Введите здоровье первого бойца");
        firstFighterHealth = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон слабого удара первого бойца");
        firstFighterDamages[0] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон обычного удара первого бойца");
        firstFighterDamages[1] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон сильного удара первого бойца");
        firstFighterDamages[2] = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите имя второго бойца");
        secondFighterName = scanner.nextLine();
        System.out.println("Введите здоровье второго бойца");
        secondFighterHealth = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон слабого удара второго бойца");
        secondFighterDamages[0] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон обычного удара второго бойца");
        secondFighterDamages[1] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон сильного удара второго бойца");
        secondFighterDamages[2] = Integer.parseInt(scanner.nextLine());

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
                    int damage = firstFighterDamages[hit];
                    System.out.println(firstFighterName + " наносит " + hitName + " удар с уроном = " + damage);
                    secondFighterHealth = secondFighterHealth - damage;
                    System.out.println("Здоровье " + secondFighterName + " = " + secondFighterHealth);
                    currentFighterName = secondFighterName;
                }
                else {
                    int damage = secondFighterDamages[hit];
                    System.out.println(secondFighterName + " наносит " + hitName + " удар с уроном = " + damage);
                    firstFighterHealth = firstFighterHealth - damage;
                    System.out.println("Здоровье " + firstFighterName + " = " + firstFighterHealth);
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
}
