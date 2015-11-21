package org.sourceit.db;

import org.sourceit.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * You must finish implementation of this class.
 * Methods:
 * -- getApplicant
 * -- getApplicants
 * -- saveApplicant
 * -- deleteApplicant
 * <p>
 * TODO: And your task is add similar methods for Subject, SpecialitySubject, ApplicantResult
 */
public enum ApplicantDBProvider {

    INSTANCE;

    private Connection connection;

    private ApplicantDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    //APPLICANT  ************** ****************** ****************** ******************
    //************** ****************** ****************** ******************

    public Applicant getApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;
        Applicant applicant = null;
        try {

            preparedStatement = connection.prepareStatement
                   // ("SELECT * FROM applicant WHERE applicant_id=?");
            //ТУТ НАДО РАЗОБРАТЬСЯ
            ("SELECT * FROM applicant LEFT JOIN profession ON applicant.profession_id = profession.profession_id WHERE applicant_id=?");
            preparedStatement.setInt(1, (int) applicantId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicant = new Applicant();

                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                //и тут
                applicant.setProfession(resultSet.getString("profession_name"));
                applicant.setProfessionId(resultSet.getLong("applicant.profession_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicant;
    }

    public List<Applicant> getApplicants() throws Exception {

        Statement statement = null;

        List<Applicant> applicants = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery
                    //("SELECT * FROM applicant");
                    ("SELECT * FROM applicant LEFT JOIN profession ON applicant.profession_id = profession.profession_id ");
            Applicant applicant = null;
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                //тут
                applicant.setProfession(resultSet.getString("profession_name"));
                applicants.add(applicant);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return applicants;
    }

    public void saveApplicant(Applicant applicant) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            //System.out.println("ДОШЛО!");
            //исправил на меньше нуля
            if (applicant.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO applicant (entrance_year, last_name, first_name, profession_id) VALUES (?, ?, ?, ?) ");

                preparedStatement.setInt(1, (int) (applicant.getEntranceYear()));
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setString(3, applicant.getFirstName());
                preparedStatement.setInt(4, (int) applicant.getProfessionId());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE applicant SET entrance_year=?, last_name=?, first_name=?, profession_id=? WHERE applicant_id=?");

                preparedStatement.setInt(5, (int) applicant.getId());
                preparedStatement.setInt(4, (int) applicant.getProfessionId());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setString(3, applicant.getFirstName());
                preparedStatement.setInt(1, (int) (applicant.getEntranceYear()));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicant(long applicantId) throws Exception {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant WHERE applicant_id=?");

            preparedStatement.setInt(1, (int) applicantId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    //PROFESSION ************** ****************** ****************** ******************
    //************** ****************** ****************** ******************

    public Profession getProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;
        Profession profession = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM profession WHERE profession_id=?");
            preparedStatement.setInt(1, (int) professionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return profession;
    }

    public List<Profession> getProfessions() throws Exception {
        Statement statement = null;

        List<Profession> professions = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM profession");
            Profession profession = null;
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
                professions.add(profession);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return professions;
    }

    public void saveProfession(Profession profession) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (profession.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO profession (profession_name) VALUES (?) ");

                preparedStatement.setString(1, profession.getProfessionName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE profession SET profession_name=? WHERE profession_id=?");

                preparedStatement.setString(1, profession.getProfessionName());
                preparedStatement.setInt(2, (int) profession.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM profession WHERE profession_id=?");

            preparedStatement.setInt(1, (int) professionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //SUBJECT ************** ****************** ****************** ******************
    //************** ****************** ****************** ******************

    public Subject getSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;
        Subject subject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM subject WHERE subject_id=?");
            preparedStatement.setInt(1, (int) subjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return subject;
    }

    public List<Subject> getSubjects() throws Exception {
        Statement statement = null;

        List<Subject> subjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subject");
            Subject subject = null;
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
                subjects.add(subject);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return subjects;
    }

    public void saveSubject(Subject subject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (subject.getId() <1) {
                preparedStatement = connection.prepareStatement("INSERT INTO subject (subject_name) VALUES (?) ");

                preparedStatement.setString(1, subject.getSubjectName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE subject SET subject_name=? WHERE subject_id=?");

                preparedStatement.setString(1, subject.getSubjectName());
                preparedStatement.setInt(2, (int) subject.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM subject WHERE subject_id=?");

            preparedStatement.setInt(1, (int) subjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //applicant_results ****************** ****************** ******************
    //************** ****************** ****************** ******************

    public ApplicantResult getApplicant_result(long applicant_resultId) throws Exception {
        PreparedStatement preparedStatement = null;
        ApplicantResult applicant_result = null;
        try {
            preparedStatement = connection.prepareStatement
                    //("SELECT * FROM applicant_result WHERE applicant_result_id=?");
                    ("SELECT * FROM APPLICANT_RESULT " +
                            "left join APPLICANT on applicant.applicant_id = APPLICANT_RESULT.APPLICANT_ID " +
                            "left join SUBJECT on SUBJECT.SUBJECT_ID = APPLICANT_RESULT.SUBJECT_ID " +
                            "WHERE applicant_result_id=?");
            preparedStatement.setInt(1, (int) applicant_resultId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicant_result = new ApplicantResult();
                applicant_result.setId(resultSet.getInt("applicant_result_id"));
                applicant_result.setLastName(resultSet.getString("last_name"));
                applicant_result.setFirstName(resultSet.getString("first_name"));
                applicant_result.setSubjectName(resultSet.getString("subject_name"));
                applicant_result.setMark(resultSet.getInt("mark"));
                applicant_result.setSubjectId(resultSet.getLong("subject_id"));
                applicant_result.setApplicantId(resultSet.getLong("applicant_id"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicant_result;
    }

    public List<ApplicantResult> getApplicantResults() throws Exception {
        Statement statement = null;

        List<ApplicantResult> applicant_results = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery
                    //("SELECT * FROM applicant_result");
                    ("SELECT * FROM APPLICANT_RESULT " +
                            "left join APPLICANT on applicant.applicant_id = APPLICANT_RESULT.APPLICANT_ID " +
                            "left join SUBJECT on SUBJECT.SUBJECT_ID = APPLICANT_RESULT.SUBJECT_ID ");
            ApplicantResult applicant_result = null;
            Applicant applicant = null;
            while (resultSet.next()) {
                applicant_result = new ApplicantResult();
                //добавил аппликанта!!
                applicant = new Applicant();

                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
//
//                applicant.setProfession(resultSet.getString("profession_name"));
                applicant.setProfessionId(resultSet.getLong("profession_id"));

                applicant_result.setApplicant(applicant);


                applicant_result.setId(resultSet.getInt("applicant_result_id"));
                applicant_result.setLastName(resultSet.getString("last_name"));
                applicant_result.setFirstName(resultSet.getString("first_name"));
                applicant_result.setSubjectName(resultSet.getString("subject_name"));
                applicant_result.setMark(resultSet.getInt("mark"));
                applicant_results.add(applicant_result);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return applicant_results;
    }

    public void saveApplicant_result(ApplicantResult applicantResult) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicantResult.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO applicant_result (applicant_id,subject_id,mark) VALUES (?,?,?) ");

                preparedStatement.setLong(1, applicantResult.getApplicantId());
                preparedStatement.setLong(2, applicantResult.getSubjectId());
                preparedStatement.setInt(3, applicantResult.getMark());

            } else {
                preparedStatement = connection.prepareStatement("UPDATE applicant_result SET applicant_id=?,subject_id = ?, mark = ? WHERE applicant_result_id=?");

                preparedStatement.setLong(1, applicantResult.getApplicantId());
                preparedStatement.setLong(2, applicantResult.getSubjectId());
                preparedStatement.setInt(3, applicantResult.getMark());
                preparedStatement.setInt(4, (int) applicantResult.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicant_result(long applicantResult) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant_result WHERE applicant_result_id=?");

            preparedStatement.setInt(1, (int) applicantResult);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    //SpecialitySubject   ****************** ****************** ******************
    //************** ****************** ****************** ******************

    public SpecialitySubject getSpecialitySubject(long specialitySubjectId) throws Exception {
        PreparedStatement preparedStatement = null;
        SpecialitySubject specialitySubject = null;
        try {
            preparedStatement = connection.prepareStatement
                    //("SELECT * FROM speciality_subject WHERE sp_sb_id=?");
                    ("select * from speciality_subject " +
                            "left join SUBJECT on SPECIALITY_SUBJECT.SUBJECT_ID = SUBJECT.SUBJECT_ID " +
                            "left join PROFESSION on SPECIALITY_SUBJECT.PROFESSION_ID = PROFESSION.PROFESSION_ID " +
                            "WHERE sp_sb_id=?");
            preparedStatement.setInt(1, (int) specialitySubjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setId(resultSet.getLong("sp_sb_id"));
                //тут поменял
                specialitySubject.setProfession(resultSet.getString("profession_name"));
                specialitySubject.setSubject(resultSet.getString("subject_name"));
                specialitySubject.setProfessionSubject(resultSet.getLong("profession_id"));
                specialitySubject.setSubjectId(resultSet.getLong("subject_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return specialitySubject;
    }

    public List<SpecialitySubject> getSpecialitySubjects() throws Exception {
        Statement statement = null;

        List<SpecialitySubject> specialitySubjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery
                    ("select * from speciality_subject " +
                            "left join SUBJECT on SPECIALITY_SUBJECT.SUBJECT_ID = SUBJECT.SUBJECT_ID " +
                            "left join PROFESSION on SPECIALITY_SUBJECT.PROFESSION_ID = PROFESSION.PROFESSION_ID");
                    //("SELECT * FROM speciality_subject");
            SpecialitySubject specialitySubject = null;
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setId(resultSet.getInt("sp_sb_id"));
                //тут искать ошибку если чё
                specialitySubject.setProfession(resultSet.getString("profession_name"));
                specialitySubject.setSubject(resultSet.getString("subject_name"));
                specialitySubject.setProfessionSubject(resultSet.getLong("profession_id"));
                specialitySubject.setSubjectId(resultSet.getLong("subject_id"));
                specialitySubjects.add(specialitySubject);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return specialitySubjects;
    }

    public void saveSpecialitySubjectCommand(SpecialitySubject specialitySubject) throws Exception{
        PreparedStatement preparedStatement = null;

        try {
            if (specialitySubject.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO speciality_subject (profession_id,subject_id) VALUES (?,?) ");

                preparedStatement.setLong(1, specialitySubject.getProfessionSubject());
                preparedStatement.setLong(2, specialitySubject.getSubjectId());


            } else {
                preparedStatement = connection.prepareStatement("UPDATE speciality_subject SET profession_id=?,subject_id = ? WHERE sp_sb_id=?");

                preparedStatement.setLong(1, specialitySubject.getProfessionSubject());
                preparedStatement.setLong(2, specialitySubject.getSubjectId());
                preparedStatement.setInt(3, (int) specialitySubject.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteSpecialitySubjectCommand(long specialitySubject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM speciality_subject WHERE sp_sb_id=?");

            preparedStatement.setInt(1, (int) specialitySubject);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }



}
