package DataCleansing;

public class MachineCleansingDetail extends Machine{

    private final String comment;
    private final String employeeName;
    private final String lastUpdated;
    private final boolean cleansed;

    public MachineCleansingDetail(String serialNum, String model, String employeeName, String comment, String serialHDD, String lastUpdated, boolean cleansed) {
        super(serialNum, model, serialHDD,cleansed);
        this.comment = comment;
        this.employeeName = employeeName;
        this.lastUpdated = lastUpdated;
        this.cleansed = cleansed;
    }


    public String getComment() {
        return comment;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public boolean getCleansed(){
        return cleansed;
    }

    @Override
    public String toString() {
        return  getSerialNum() + ";" +
                getModel() + ";" +
                getEmployeeName() + ";" +
                getComment() + ";" +
                getSerialHDD() + ";" +
                getLastUpdated() + ";" +
                getCleansed();
    }
}


