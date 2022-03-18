public class MortalCombat {

    public static void main(String[] args) {
        BattleHero fighterOne = new BattleHero(130, 40, 64, 90);
        BattleHero fighterTwo = new BattleHero(170, 32, 71, 81);
        fighterOne.name = "Sub-Zero";
        fighterTwo.name = "Noob-Saibot";
        GameEngine myGame = new GameEngine(fighterOne, fighterTwo);
        myGame.fight();
    }
}
class BattleHero {
    public String name;
    private int hp;
    private int def;
    private int attack;
    private int initiative;

    public BattleHero (int hp, int def, int attack, int initiative) {
        this.hp = hp;
        this.def = def;
        this.attack = attack;
        this.initiative = initiative;
    }
    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
        }
        else this.hp = 0;
    }
    public int getDef() {
        return this.def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public int getAttack() {
        return this.attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getInitiative() {
        return this.initiative;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}

class GameEngine {
    BattleHero player1;
    BattleHero player2;
    int stepGame;

    public GameEngine(BattleHero Player1, BattleHero Player2) {
        this.player1 = Player1;
        this.player2 = Player2;
        this.stepGame = 0;
    }

    public void fight() {
        BattleHero attackPlayer;
        BattleHero defenderPlayer;
        BattleHero boofer;
        if (this.player2.getInitiative() > this.player1.getInitiative()) {
            attackPlayer = player2;
            defenderPlayer = player1;
        }
        else {
            defenderPlayer = player2;
            attackPlayer = player1;
        }
        showGame(attackPlayer, defenderPlayer);
        while(isTheEnd() == false){
            defenderPlayer.setHp(defenderPlayer.getHp() + defenderPlayer.getDef() - attackPlayer.getAttack());
            boofer = attackPlayer;
            attackPlayer = defenderPlayer;
            defenderPlayer = boofer;
            this.stepGame++;
            showGame(attackPlayer, defenderPlayer);
        }
    }
    private void showGame(BattleHero Attacker, BattleHero Defender) {
        System.out.println(this.stepGame + ": " + Attacker.name + " " + Attacker.getHp() + " "
                + Defender.name + " " + Defender.getHp());
    }
    private boolean isTheEnd() {
        if (this.player1.getHp() == 0 || this.player2.getHp() == 0) {
            return true;
        }
        else return false;
    }
}
