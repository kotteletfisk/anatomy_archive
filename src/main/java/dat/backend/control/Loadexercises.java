package dat.backend.control;

import dat.backend.model.entities.Exercise;
import dat.backend.model.entities.Muscle;
import dat.backend.model.entities.MuscleGroup;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.IO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "Loadexercises", value = "/loadexercises")
public class Loadexercises extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String[] strList = request.getParameterValues("checkboxChoice");

        System.out.println(Arrays.toString(strList));
        if (strList.length < 1)
        {
            response.sendRedirect("bodymap");
        }

        List<Exercise> exerciseList = null;
        List<Muscle> muscleList = null;
        List<MuscleGroup> muscleGroupList = null;

        for (String s: strList)
        {
            if (s.equals("all"))
            {
                int id = Integer.parseInt(request.getParameter("muscleGroupID"));
                try
                {
                    muscleGroupList = IO.getAllMusclegroups();
                    exerciseList = IO.getExercisesByMuscleGroupID(id);
                    muscleList = IO.getMusclesByMuscleGroupID(id);

                }
                catch (DatabaseException e)
                {
                    request.setAttribute("errormessage", e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }

                Set<Exercise> exerciseSet = new HashSet<>(exerciseList);

                request.setAttribute("exerciseList", exerciseSet);
                request.setAttribute("muscleGroupList", muscleGroupList);
                request.setAttribute("muscleGroupID", id);
                request.setAttribute("muscleList",muscleList);
                request.getRequestDispatcher("WEB-INF/bodymap.jsp").forward(request, response);
            }

            else
            {
                int[] idList = new int[strList.length];
                for (int i = 0; i < strList.length; i++)
                {
                    idList[i] = Integer.parseInt(strList[i]);
                }


                HashSet<Exercise> exerciseSet = IO.getExerciseAND(idList);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
