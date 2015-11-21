package org.sourceit.command.impl.SpecialitySubject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by artem on 15.09.15.
 */
public class DeleteSpecialitySubjectCommand implements ICommand{

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long specialitySubjectId = Long.parseLong(request.getParameter("id"));
            provider.deleteSpecialitySubjectCommand(specialitySubjectId);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=specialitySubjects";
    }

}
