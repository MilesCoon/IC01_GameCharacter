public class Main {
    public static void main(String[] args) {
        GameCharacter me = new GameCharacter("Miles", 1);

        GameCharacter villain = new GameCharacter("Monster", 10);

        System.out.println("\n~~~Game Characters Created~~~");

        System.out.println(me);
        System.out.println(villain);

        System.out.println("\n~~~Miles is attacking the Monster~~~");

        me.attack(villain);

        System.out.println(me);
        System.out.println(villain);

        System.out.println("\n~~~The Monster is resting~~~");

        villain.rest();

        System.out.println(me);
        System.out.println(villain);
    }
}