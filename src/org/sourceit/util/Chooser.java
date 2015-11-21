package org.sourceit.util;

import org.sourceit.command.ICommand;
import org.sourceit.command.impl.SpecialitySubject.*;
import org.sourceit.command.impl.applicant.*;
import org.sourceit.command.impl.applicant_result.*;
import org.sourceit.command.impl.profession.*;
import org.sourceit.command.impl.subject.*;

import java.util.HashMap;
import java.util.Map;

/**
 * You must finish implementation of this class.
 * Add following commands:
 * -- ApplicantCommand(finish implementation)
 * -- AddApplicantCommand
 * -- SaveApplicantCommand
 * -- DeleteApplicantCommand
 * -- EditApplicantCommand
 * <p>
 * TODO: And your task is add similar classes for Subject, SpecialitySubject, ApplicantResult
 */
public enum Chooser {

    INSTANCE;

    private Map<String, ICommand> commandMap = new HashMap<>();

    private Chooser() {

        // commands for profession
        commandMap.put("professions", new ProfessionCommand());
        commandMap.put("addProfession", new AddProfessionCommand());
        commandMap.put("editProfession", new EditProfessionCommand());
        commandMap.put("saveProfession", new SaveProfessionCommand());
        commandMap.put("deleteProfession", new DeleteProfessionCommand());


        // commands for applicants
        commandMap.put("applicants", new ApplicantCommand());
        commandMap.put("addApplicant", new AddApplicantCommand());
        commandMap.put("editApplicant", new EditApplicantCommand());
        commandMap.put("saveApplicant", new SaveApplicantCommand());
        commandMap.put("deleteApplicant", new DeleteApplicantCommand());

        // commands for subject
        commandMap.put("subjects", new SubjectCommand());
        commandMap.put("addSubject", new AddSubjectCommand());
        commandMap.put("editSubject", new EditSubjectCommand());
        commandMap.put("saveSubject", new SaveSubjectCommand());
        commandMap.put("deleteSubject", new DeleteSubjectCommand());

        // commands for applicant_result
        commandMap.put("applicant_results", new Applicant_resultCommand());
        commandMap.put("editApplicant_result", new EditApplicant_resultCommand());
        commandMap.put("deleteApplicant_result", new DeleteApplicant_resultCommand());
        commandMap.put("saveApplicant_result", new SaveApplicant_resultCommand());
        commandMap.put("addApplicant_result", new AddApplicant_resultCommand());

        // commands for speciality_subject
        commandMap.put("specialitySubjects", new SpecialitySubjectCommand());
        commandMap.put("editSpecialitySubject", new EditSpecialitySubjectCommand());
        commandMap.put("deleteSpecialitySubject", new DeleteSpecialitySubjectCommand());
        commandMap.put("saveSpecialitySubject", new SaveSpecialitySubjectCommand());
        commandMap.put("addSpecialitySubject", new AddSpecialitySubjectCommand());

    }

    public ICommand chooseCommand(String command) {
        return commandMap.get(command);
    }

}
