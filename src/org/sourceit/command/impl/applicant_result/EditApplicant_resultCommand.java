package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by artem on 14.09.15.
 */
public class EditApplicant_resultCommand implements ICommand{

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long applicant_resultId = Long.parseLong(request.getParameter("id"));
            ApplicantResult applicant_result = provider.getApplicant_result(applicant_resultId);
            request.setAttribute("applicant_result", applicant_result);

        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        List<Subject> subjects = null;

        try {
            subjects = provider.getSubjects();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("subjects", subjects);


        List<Applicant> applicants = null;

        try {
            applicants = provider.getApplicants();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("applicants", applicants);

        return "pages/edit_applicant_result.jsp";
    }
}
