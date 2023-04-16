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
import java.util.List;

import static java.awt.SystemColor.text;

@WebServlet(name = "Choosemusclegroup", value = "/choosemusclegroup")
public class Choosemusclegroup extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("mschoice"));

        try
        {
            List<Muscle> muscleList = IO.getMusclesByMuscleGroupID(id);

            List<MuscleGroup> muscleGroupList = IO.getAllMusclegroups();

            request.setAttribute("muscleGroupList", muscleGroupList);
            request.setAttribute("muscleList", muscleList);
            request.getRequestDispatcher("WEB-INF/bodymap.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
