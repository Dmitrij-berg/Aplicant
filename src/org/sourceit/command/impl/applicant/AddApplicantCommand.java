package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by artem on 08.09.15.
 */
public class AddApplicantCommand implements ICommand{

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {



        List<Profession> professions = null;

        try {
            professions = provider.getProfessions();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("professions", professions);

        return "pages/edit_applicant.jsp";
    }

}
