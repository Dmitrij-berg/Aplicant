import org.junit.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Profession;

import java.util.List;


public class TestApplcant {
    //вернът существующего аппликанта
    @Test
    public void testGetApplicantTrue() {
        Applicant applicant = null;
        try {
            applicant = ApplicantDBProvider.INSTANCE.getApplicant(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(applicant);
    }

    //в аппликанте будет пусто
    @Test
    public void testGetApplicantFalse() {
        Applicant applicant = null;
        try {
            applicant = ApplicantDBProvider.INSTANCE.getApplicant(100500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNull(applicant);
    }

    //исключение, пустой аппликант пихаем
    @Test(expected = Exception.class)
    public void testSaveApplicantFalse() throws Exception {

        Applicant applicant = new Applicant();

        ApplicantDBProvider.INSTANCE.saveApplicant(applicant);

    }

    //вернёт список аппликантов
    @Test
    public void testGetApplicantsFalse() {
        List<Applicant> applicantList = null;

        try {
            applicantList = ApplicantDBProvider.INSTANCE.getApplicants();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertFalse(applicantList.isEmpty());
    }

    //сохраняет аппликанта

    @Test
    public void testSaveApplicantTrue() throws Exception {

        Applicant applicant = new Applicant();
        applicant.setProfessionId(2);
        applicant.setEntranceYear(2008);
        applicant.setLastName("Baba");
        applicant.setFirstName("Ali");

        ApplicantDBProvider.INSTANCE.saveApplicant(applicant);

    }

    @Test
    public void testEditApplicantTrue() throws Exception {

        Applicant applicant = ApplicantDBProvider.INSTANCE.getApplicant(3);
        ApplicantDBProvider.INSTANCE.saveApplicant(applicant);

    }

    @Test
    public void testDeleteApplicantException() throws Exception {

        ApplicantDBProvider.INSTANCE.deleteApplicant(100);

    }


}
