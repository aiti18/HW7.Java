public class Main {
    public interface HavingSuperAbility {
        void applySuperAbility();
    }

    public abstract class Hero implements HavingSuperAbility {
        private int health;
        private int damage;
        private String superAbilityType;

        public Hero(int health, int damage, String superAbilityType) {
            this.health = health;
            this.damage = damage;
            this.superAbilityType = superAbilityType;
        }

        public String getSuperAbilityType() {
            return superAbilityType;
        }
    }

    public class Magic extends Hero {
        public Magic(int health, int damage, String superAbilityType) {
            super(health, damage, superAbilityType);
        }

        @Override
        public void applySuperAbility() {
            System.out.println("Magic применил супер способность " + getSuperAbilityType());
        }
    }

    public class Medic extends Hero {
        private int healPoints;

        public Medic(int health, int damage, String superAbilityType, int healPoints) {
            super(health, damage, superAbilityType);
            this.healPoints = healPoints;
        }

        @Override
        public void applySuperAbility() {
            System.out.println("Medic применил супер способность " + getSuperAbilityType());
        }

        public void increaseExperience() {
            this.healPoints += this.healPoints * 0.1;
            System.out.println("Medic увеличил опыт лечения на 10%, теперь очков лечения: " + healPoints);
        }
    }

    public class Warrior extends Hero {
        public Warrior(int health, int damage, String superAbilityType) {
            super(health, damage, superAbilityType);
        }

        @Override
        public void applySuperAbility() {
            System.out.println("Warrior применил супер способность " + getSuperAbilityType());
        }
    }

    public static void main(String[] args) {
        Hero[] heroes = {
                new Main().new Magic(100, 20, "MAGIC DAMAGE"),
                new Main().new Medic(80, 10, "HEALING", 50),
                new Main().new Warrior(120, 30, "CRITICAL DAMAGE")
        };

        for (Hero hero : heroes) {
            hero.applySuperAbility();
            if (hero instanceof Medic) {
                ((Medic) hero).increaseExperience();
            }
        }
    }
}
