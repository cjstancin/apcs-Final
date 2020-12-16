import java.util.Random;

public class Character {
    private String type;
    private int strength;
    private int toughness;
    private int intelligence;
    private int magic;
    private int influence;
    String[] types = {"knight", "peasant", "cleric", "mage", "courtier"};
    Random random = new Random();

    public Character() {
        this.type = types[random.nextInt(4)];
        if (this.type.equals("knight")){
            this.type = "knight";
            this.strength = random.nextInt(4) + 7;
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(7);
        } else if (this.type.equals("peasant")){
            this.type = "peasant";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(4) + 7;
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(7);
        } else if (this.type.equals("mage")){
            this.type = "mage";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(4) + 7;
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(7);
        } else if (this.type.equals("cleric")){
            this.type = "cleric";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(4) + 7;
            this.influence = random.nextInt(7);
        } else if (this.type.equals("courtier")){
            this.type = "courtier";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(4) + 7;
        }
    }

    public Character(String type){
        if (type.equals("knight")){
            this.type = "knight";
            this.strength = random.nextInt(4) + 7;
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(7);
        } else if (type.equals("peasant")){
            this.type = "peasant";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(4) + 7;
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(7);
        } else if (type.equals("mage")){
            this.type = "mage";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(4) + 7;
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(7);
        } else if (type.equals("cleric")){
            this.type = "cleric";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(4) + 7;
            this.influence = random.nextInt(7);
        } else if (type.equals("courtier")){
            this.type = "courtier";
            this.strength = random.nextInt(7);
            this.toughness = random.nextInt(7);
            this.magic = random.nextInt(7);
            this.intelligence = random.nextInt(7);
            this.influence = random.nextInt(4) + 7;
        }
    }


    public int getStrength(){return this.strength;}
    public int getToughness(){return this.toughness;}
    public int getIntelligence(){return this.intelligence;}
    public int getMagic(){return this.magic;}
    public int getInfluence(){return this.influence;}

    public String toString() {
        return this.type + "," + String.valueOf(this.strength) + "," + String.valueOf(this.toughness) + "," + String.valueOf(this.intelligence) + "," + String.valueOf(this.magic) + "," + String.valueOf(this.influence);
    }
}