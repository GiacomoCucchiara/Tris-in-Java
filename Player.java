package tris;

public class Player {
    private int ID;
    private String Name;
    private String Sign;
    private Integer Score;

    public Player(int iD, String name, String sign, Integer score) {
        ID = iD;
        Name = name;
        Sign = sign;
        Score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {

        String sing1 = sign.toUpperCase();
        this.Sign = sing1;

    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Name player: " + getName() + " " + "Sign player: " + getSign() + " " + "Score: " + getScore();
    }
}
