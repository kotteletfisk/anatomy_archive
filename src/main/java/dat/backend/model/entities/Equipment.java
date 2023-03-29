package dat.backend.model.entities;

public class Equipment
{
    private int equipmentID;
    private String equipmentName;
    private String getEquipmentDescription;

    public Equipment(int equipmentID, String equipmentName, String getEquipmentDescription)
    {
        this.equipmentID = equipmentID;
        this.equipmentName = equipmentName;
        this.getEquipmentDescription = getEquipmentDescription;
    }

    public int getEquipmentID()
    {
        return equipmentID;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }

    public String getGetEquipmentDescription()
    {
        return getEquipmentDescription;
    }
}
