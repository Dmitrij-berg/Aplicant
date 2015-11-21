package org.sourceit.command.impl.subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by artem on 12.09.15.
 */
public class SubjectCommand implements ICommand {


    ApplicantDBProvider applicantDBProvider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<Subject> subjects = null;

        try {
            subjects = applicantDBProvider.getSubjects();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("subjects", subjects);

        return "pages/subjects.jsp";
    }

}
