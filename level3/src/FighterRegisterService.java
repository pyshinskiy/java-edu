import java.util.Scanner;

public class FighterRegisterService {

    private String fighterNumber = "первого";

    public Fighter registerFighter() {
        if ("Второй".equals(fighterNumber)) {
            throw new RuntimeException(
                    "Два бойца уже зарегистрированы, арена не поддерживает большее количество бойцов"
            );
        }
        Scanner scanner = new Scanner(System.in);
        String fighterName = getName(scanner);
        int fighterHealth = getHealth(scanner);
        int[] fighterDamages = getDamages(scanner);
        Fighter fighter = new Fighter(fighterName, fighterHealth, fighterDamages);
        fighterNumber = "второго";
        return fighter;
    }

    public String getName(Scanner scanner) {
        System.out.println("Введите имя " +  fighterNumber + " бойца");
        return scanner.nextLine();
    }

    public int getHealth(Scanner scanner) {
        System.out.println("Введите здоровье " +  fighterNumber + " бойца");
        return Integer.parseInt(scanner.nextLine());
    }

    public int[] getDamages(Scanner scanner) {
        int[] fighterDamages = new int[3];
        System.out.println("Введите урон слабого удара " +  fighterNumber + " бойца");
        fighterDamages[0] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон обычного удара " +  fighterNumber + " бойца");
        fighterDamages[1] = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите урон сильного удара " +  fighterNumber + " бойца");
        fighterDamages[2] = Integer.parseInt(scanner.nextLine());
        return fighterDamages;
    }
}
