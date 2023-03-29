package dat.backend.model.entities;

public class MuscleGroup
{
    private int muscleGroupID;
    private String muscleGroupName;

    public MuscleGroup(int muscleGroupID, String muscleGroupName)
    {
        this.muscleGroupID = muscleGroupID;
        this.muscleGroupName = muscleGroupName;
    }

    public int getMuscleGroupID()
    {
        return muscleGroupID;
    }

    public String getMuscleGroupName()
    {
        return muscleGroupName;
    }
}
