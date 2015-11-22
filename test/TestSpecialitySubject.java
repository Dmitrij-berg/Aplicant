import org.junit.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.SpecialitySubject;

import java.util.List;


public class TestSpecialitySubject {

    @Test
    public void testGetSpecialitySubjectTrue(){
        SpecialitySubject specialitySubject = null;
        try {
            specialitySubject = ApplicantDBProvider.INSTANCE.getSpecialitySubject(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(specialitySubject);
    }


    @Test
    public void testGetSpecialitySubjectFalse(){
        SpecialitySubject specialitySubject = null;
        try {
            specialitySubject = ApplicantDBProvider.INSTANCE.getSpecialitySubject(100500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNull(specialitySubject);
    }

    @Test(expected = Exception.class)
    public void testSaveSpecialitySubjectFalse() throws Exception {

        SpecialitySubject specialitySubject = new SpecialitySubject();

        ApplicantDBProvider.INSTANCE.saveSpecialitySubjectCommand(specialitySubject);

    }

    @Test
    public void testGetSpecialitySubjectsFalse(){
        List<SpecialitySubject> specialitySubjectList = null;

        try {
            specialitySubjectList = ApplicantDBProvider.INSTANCE.getSpecialitySubjects();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertFalse(specialitySubjectList.isEmpty());
    }


    @Test
    public void testEditSpecialitySubjectTrue() throws Exception {

        SpecialitySubject specialitySubject = ApplicantDBProvider.INSTANCE.getSpecialitySubject(2);
        ApplicantDBProvider.INSTANCE.saveSpecialitySubjectCommand(specialitySubject);

    }

    @Test
    public void testDeleteSpecialityException() throws Exception {

        ApplicantDBProvider.INSTANCE.deleteSpecialitySubjectCommand(100);

    }

}
