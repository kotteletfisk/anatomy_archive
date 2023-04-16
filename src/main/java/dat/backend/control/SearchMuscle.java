package dat.backend.control;

import dat.backend.model.entities.Exercise;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.IO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchMuscle", value = "/searchmuscle")
public class SearchMuscle extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String text = request.getParameter("text");

        try
        {
            List<Exercise> exerciseList = IO.getExercisesByMuscle(text);

            request.setAttribute("exerciseList", exerciseList);
            request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);

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
