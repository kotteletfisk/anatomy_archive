package dat.backend.model.entities;

public class Exercise
{
    private int exerciseID;
    private String exerciseName;
    private String exerciseDescription;
    private int exerciseIntensity;
    private String exerciseType;
    private boolean exerciseCalisthenic;

    public Exercise(int exerciseID, String exerciseName, String exerciseDescription, int exerciseIntensity, String exerciseType, boolean exerciseCalisthenic)
    {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseIntensity = exerciseIntensity;
        this.exerciseType = exerciseType;
        this.exerciseCalisthenic = exerciseCalisthenic;
    }

    public int getExerciseID()
    {
        return exerciseID;
    }

    public String getExerciseName()
    {
        return exerciseName;
    }

    public String getExerciseDescription()
    {
        return exerciseDescription;
    }

    public int getExerciseIntensity()
    {
        return exerciseIntensity;
    }

    public String getExerciseType()
    {
        return exerciseType;
    }

    public boolean isExerciseCalisthenic()
    {
        return exerciseCalisthenic;
    }
}

