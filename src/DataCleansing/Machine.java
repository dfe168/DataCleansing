package DataCleansing;

public class Machine {
    private final String serialNum;
    private final String model;
    private final String serialHDD;

    public Machine(String serialNum, String model, String serialHDD, boolean cleansed) {
        this.serialNum = serialNum;
        this.model = model;
        this.serialHDD = serialHDD;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public String getModel() {
        return model;
    }

    public String getSerialHDD() {
        return serialHDD;
    }




}
