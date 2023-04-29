package dat.backend.model.persistence;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Exercise;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseMapper
{

    protected static List<Exercise> getExercisesByMuscleGroupID(int id) throws DatabaseException
    {
        ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

        String sql = "SELECT * FROM exerciseByMuscleGroup WHERE MuscleGroupID = ?;";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                List<Exercise> exerciseList = new ArrayList<>();

                while (rs.next())
                {
                    int exerciseID = rs.getInt("ExerciseID");
                    String exerciseName = rs.getString("ExerciseName");
                    String exerciseDesc = rs.getString("ExerciseDescription");
                    int exerciseInt = rs.getInt("ExerciseIntensity");
                    String exerciseType = rs.getString("ExerciseType");
                    boolean exerciseCali = rs.getBoolean("ExerciseCalisthenic");

                    exerciseList.add(new Exercise(exerciseID, exerciseName, exerciseDesc, exerciseInt,
                            exerciseType, exerciseCali));
                }

                return exerciseList;
            }
        }

        catch (SQLException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }
}
