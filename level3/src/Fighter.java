import java.util.Random;

public class Fighter {

    private final String name;

    private int health;

    private final int[] damages;

    private String lastHitName;

    private int lastMadeDamage;

    public Fighter(String name, int health, int[] damages) {
        this.name = name;
        this.health = health;
        this.damages = damages;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damage) {
        this.health = health - damage;
    }

    public void fight(Fighter anotherFighter) {
        anotherFighter.receiveDamage(this.getRandomDamage());
    }

    public String getLastHitName() {
        return lastHitName;
    }

    public int getLastMadeDamage() {
        return lastMadeDamage;
    }

    private int getRandomDamage() {
        int hitIndex = new Random().nextInt(3);
        this.lastHitName = switch (hitIndex) {
            case 0 -> "слабый";
            case 1 -> "обычный";
            case 2 -> "сильный";
            default -> throw new IllegalStateException("Unexpected value: " + hitIndex);
        };
        int damage = damages[hitIndex];
        this.lastMadeDamage = damage;
        return damage;
    }
}
