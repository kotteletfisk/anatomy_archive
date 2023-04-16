package dat.backend.model.persistence;


import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Exercise;
import dat.backend.model.entities.Muscle;
import dat.backend.model.entities.MuscleGroup;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuscleMapper
{


    public static List<Exercise> getExercisesByMuscle(String text) throws DatabaseException
    {
        ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

       String sql = "SELECT ExerciseID, ExerciseName, ExerciseDescription, ExerciseIntensity, ExerciseType, ExerciseCalisthenic" +
                " FROM exerciseByMuscle WHERE MuscleName LIKE ?;";

        try (Connection connection = connectionPool.getConnection())
        {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, text);

           ResultSet rs = ps.executeQuery();
           List<Exercise> exercises = new ArrayList<>();

           while (rs.next())
           {
               int exerciseID = rs.getInt("ExerciseID");
               String exerciseName = rs.getString("ExerciseName");
               String exerciseDesc = rs.getString("ExerciseDescription");
               int exerciseIntensity = rs.getInt("ExerciseIntensity");
               String exerciseType = rs.getString("ExerciseType");
               boolean exerciseCalisthenic = rs.getBoolean("ExerciseCalisthenic");

               exercises.add(new Exercise(exerciseID, exerciseName, exerciseDesc, exerciseIntensity, exerciseType, exerciseCalisthenic));
           }

           return exercises;
        }
        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    /*public static List<Muscle> getMusclesByMuscleGroup(String text)
    {

    }*/

    public static List<MuscleGroup> getAllMuscleGroups() throws DatabaseException
    {
        ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

        String sql = "SELECT * FROM MuscleGroups;";

        try (Connection connection = connectionPool.getConnection())
        {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<MuscleGroup> muscleGroupList = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("MuscleGroupID");
                String name = rs.getString("MuscleGroupName");
                muscleGroupList.add(new MuscleGroup(id, name));
            }

            return muscleGroupList;
        }

        catch (SQLException e)
        {
            throw new DatabaseException("Unable to get Musclegroups");
        }
    }
}
