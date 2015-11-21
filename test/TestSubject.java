import org.junit.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Profession;
import org.sourceit.entities.Subject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by artem on 15.09.15.
 */
public class TestSubject {

    @Test
    public void testGetSubjectsIsEmptyFalse(){

        List<Subject> subjects = null;

        try {
            subjects = ApplicantDBProvider.INSTANCE.getSubjects();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertFalse(subjects.isEmpty());

    }
    // get существующий элемент
    @Test
    public void testGetSubjectPutRealElementTrue(){
        Subject subject = null;
        try {
            subject = ApplicantDBProvider.INSTANCE.getSubject(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(subject != null);
    }
    // get несуществующий элемент
    @Test
    public void testGetSubjectPutNotRealElementNull(){
        Subject subject = null;
        try {
            subject = ApplicantDBProvider.INSTANCE.getSubject(100500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNull(subject);
    }

    //save несуществующий элемент
    @Test(expected = Exception.class)
    public void testSaveSubjectNotReal() throws Exception {

        Subject subject = new Subject();

        ApplicantDBProvider.INSTANCE.saveSubject(subject);

    }
    //save существующий subject
    @Test
    public void testSaveSubjectReal() throws Exception {

        Subject subject = new Subject();
        subject.setSubjectName("Math");

        ApplicantDBProvider.INSTANCE.saveSubject(subject);

    }

    @Test
    public void testEditSubjectTrue() throws Exception {

        Subject subject = ApplicantDBProvider.INSTANCE.getSubject(2);
        ApplicantDBProvider.INSTANCE.saveSubject(subject);

    }

    @Test
    public void testDeleteSubjectException() throws Exception {

        ApplicantDBProvider.INSTANCE.deleteSubject(100);

    }

}
