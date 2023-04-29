package dat.backend.model.persistence;

import dat.backend.model.entities.Exercise;
import dat.backend.model.entities.Muscle;
import dat.backend.model.entities.MuscleGroup;
import dat.backend.model.exceptions.DatabaseException;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Set;

public class IO
{

    public static List<Exercise> getExercisesByMuscle(String text) throws DatabaseException
    {
      return MuscleMapper.getExercisesByMuscle(text);
    }

    public static List<Muscle> getMusclesByMuscleGroupID(int id) throws DatabaseException
    {
        return MuscleMapper.getMusclesByMuscleGroupID(id);
    }

    public static List<MuscleGroup> getAllMusclegroups() throws DatabaseException
    {
        return MuscleMapper.getAllMuscleGroups();
    }

    public static List<Exercise> getExercisesByMuscleGroupID(int id) throws DatabaseException
    {
        return ExerciseMapper.getExercisesByMuscleGroupID(id);
    }

    public static Set<Exercise> getExerciseAND(int[] idList)
    {
        return ExerciseMapper.getExerciseAND(idList);
    }
}
