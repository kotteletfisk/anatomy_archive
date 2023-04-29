package dat.backend.model.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return exerciseID == exercise.exerciseID && exerciseIntensity == exercise.exerciseIntensity && exerciseCalisthenic == exercise.exerciseCalisthenic && Objects.equals(exerciseName, exercise.exerciseName) && Objects.equals(exerciseDescription, exercise.exerciseDescription) && Objects.equals(exerciseType, exercise.exerciseType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(exerciseID, exerciseName, exerciseDescription, exerciseIntensity, exerciseType, exerciseCalisthenic);
    }
}

