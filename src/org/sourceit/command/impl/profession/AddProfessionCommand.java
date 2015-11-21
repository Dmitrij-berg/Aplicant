package org.sourceit.command.impl.profession;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProfessionCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/edit_profession.jsp";
    }
}
