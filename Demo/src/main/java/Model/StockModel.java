package Model;

public class StockModel {
    private String code;
    private String name;
    private float lastDone;
    private float change;
    private float vol;

    public StockModel(String code, String name, float lastDone, float change, float vol) {
        this.code = code;
        this.name = name;
        this.lastDone = lastDone;
        this.change = change;
        this.vol = vol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLastDone() {
        return lastDone;
    }

    public void setLastDone(float lastDone) {
        this.lastDone = lastDone;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public float getVol() {
        return vol;
    }

    public void setVol(float vol) {
        this.vol = vol;
    }

    @Override
    public String toString() {
        String printChange = String.valueOf(getChange());
        if (printChange.equalsIgnoreCase("0.0")){
            printChange = "-";
        } if(printChange.contains("-")){

        } else {
            printChange = "+" + printChange;
        }
        return code +" | " + name + " | " + lastDone + " | " + printChange + " | " + vol + " | ";
    }
}
