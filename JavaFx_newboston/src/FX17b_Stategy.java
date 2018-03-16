public class FX17b_Stategy {

    private String name;
    private double hozam;
    private int dbTrade;

    public FX17b_Stategy(){
        this.name= "";
        this.hozam = 0;
        this.dbTrade = 0;
    }

    public FX17b_Stategy(String name, double hozam, int dbTrade){
        this.name = name;
        this.hozam = hozam;
        this.dbTrade = dbTrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHozam() {
        return hozam;
    }

    public void setHozam(double hozam) {
        this.hozam = hozam;
    }

    public int getDbTrade() {
        return dbTrade;
    }

    public void setDbTrade(int dbTrade) {
        this.dbTrade = dbTrade;
    }
}
