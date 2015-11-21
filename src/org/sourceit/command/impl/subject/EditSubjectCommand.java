package org.sourceit.command.impl.subject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by artem on 12.09.15.
 */
public class EditSubjectCommand implements ICommand{

        private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

        @Override
        public String execute(HttpServletRequest request, HttpServletResponse resp) {

            try {
                Long subjectId = Long.parseLong(request.getParameter("id"));
                Subject subject = provider.getSubject(subjectId);
                request.setAttribute("subject", subject);
            } catch (Exception e) {
                request.setAttribute("error", e);
                return "pages/error.jsp";
            }

            return "pages/edit_subject.jsp";
        }

}
