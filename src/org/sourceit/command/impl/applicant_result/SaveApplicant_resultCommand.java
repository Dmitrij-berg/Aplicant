package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by artem on 14.09.15.
 */
public class SaveApplicant_resultCommand implements ICommand{

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        ApplicantResult applicant_result = new ApplicantResult();

        applicant_result.setApplicantId(Long.parseLong(request.getParameter("applicant_id")));
        applicant_result.setSubjectId(Long.parseLong(request.getParameter("subject_id")));
        applicant_result.setMark(Integer.parseInt(request.getParameter("mark")));

        if (request.getParameter("applicant_result_id") != null) {
            applicant_result.setId(Long.parseLong(request.getParameter("applicant_result_id")));
        }

        try {
            provider.saveApplicant_result(applicant_result);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=applicant_results";
    }

}
