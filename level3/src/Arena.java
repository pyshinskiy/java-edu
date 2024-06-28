import java.util.Scanner;

public class Arena {

    private final Fighter[] fighters;

    private final Scanner scanner = new Scanner(System.in);

    public Arena(Fighter fighter1, Fighter fighter2) {
        this.fighters = new Fighter[] {fighter1, fighter2};
    }

    public void startFight() {
        System.out.println("Начать бой? (введите \"да\" или \"нет\")");
        if ("да".equals(scanner.nextLine())) {

            while(fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0) {
                Fighter fighter = fighters[0];
                Fighter victim = fighters[1];
                fighter.fight(victim);
                System.out.println(
                        fighter.getName() + " наносит " + fighter.getLastHitName() +
                        " удар с уроном = " + fighter.getLastMadeDamage()
                );
                System.out.println("Здоровье " + victim.getName() + " = " + victim.getHealth());
                fighters[0] = victim;
                fighters[1] = fighter;
            }
            System.out.println("Победил " + fighters[1].getName() + "!");
        }
        else {
            System.out.println("Вы решили не начинать бой, программа завершена");
        }
    }
}
