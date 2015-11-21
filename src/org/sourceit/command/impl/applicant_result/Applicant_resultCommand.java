package org.sourceit.command.impl.applicant_result;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by artem on 14.09.15.
 */
public class Applicant_resultCommand implements ICommand {
    ApplicantDBProvider applicantDBProvider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        List<ApplicantResult> applicant_results = null;

        try {
            applicant_results = applicantDBProvider.getApplicantResults();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("applicant_results", applicant_results);

        return "pages/applicant_results.jsp";

    }
}
