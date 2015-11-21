package org.sourceit.command.impl.subject;

import org.sourceit.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by artem on 12.09.15.
 */
public class AddSubjectCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/edit_subject.jsp";
    }

}
