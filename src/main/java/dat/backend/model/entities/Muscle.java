package dat.backend.model.entities;

public class Muscle
{
    private int muscleID;
    private String muscleName;
    private int muscleGroupID;

    public Muscle(int muscleID, String muscleName, int muscleGroupID)
    {
        this.muscleID = muscleID;
        this.muscleName = muscleName;
        this.muscleGroupID = muscleGroupID;
    }

    public int getMuscleID()
    {
        return muscleID;
    }

    public String getMuscleName()
    {
        return muscleName;
    }

    public int getMuscleGroupID()
    {
        return muscleGroupID;
    }
}
