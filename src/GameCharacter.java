import java.util.Objects;
import java.util.Random;

public class GameCharacter {
    private String name;
    private int level;
    private int healthPoints;
    private int magic;
    private int gold;

    // attack - one game GameCharacter attacks another
    public void attack(GameCharacter target) {
        // Generate random # from 0-9
        Random rng = new Random();
        int number = rng.nextInt(10);
        int damage = number * this.level;

        // Deduct damage from target's health
        target.healthPoints = target.healthPoints - damage;

        // Prevent negative
        if (target.healthPoints < 0)
            target.healthPoints = 0;
    }

    // assist
    public void assist(GameCharacter other) {
        Random rng = new Random();
        switch (rng.nextInt(5)) {
            case 0:
                other.healthPoints += level * 5;
                healthPoints -= level * 5;
                break;
            case 1:
                other.magic += level * 5;
                magic -= level * 5;
                break;
            case 2:
                other.gold += level * 5;
                gold -= level * 5;
                break;
            case 3:
                other.level++;
                other.gold += 100;
                other.magic += 100;
                other.healthPoints += 100;

                level--;
                gold -= 100;
                magic -= 100;
                healthPoints -= 100;
                break;
            case 4:
                healthPoints = level * 100;
                other.healthPoints = other.level * 100;
                break;
        }
    }

    public void rest() {
        this.healthPoints = level * 100;
        this.magic = level * 100;
    }

    // 1st constructor
    public GameCharacter(String name, int level, int healthPoints, int magic, int gold) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.magic = magic;
        this.gold = gold;
    }

    // 2nd constructor (overload constructor)
    public GameCharacter(String name, int level) {
        this(name, level, level*100, level*100, level*100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMagic() {
        return magic;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public String toString() {
        return  "[Game Character] " +
                "Name: " + name +
                ", Level: " + level +
                ", HP: " + healthPoints +
                ", Magic:" + magic +
                ", Gold:" + gold +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCharacter that = (GameCharacter) o;
        return level == that.level && healthPoints == that.healthPoints && magic == that.magic && gold == that.gold && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, healthPoints, magic, gold);
    }
}
