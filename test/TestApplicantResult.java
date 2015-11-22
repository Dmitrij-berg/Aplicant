import org.junit.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;

import java.util.List;


public class TestApplicantResult {

    //
    @Test
    public void testGetApplicantResult(){
        ApplicantResult applicantResult = null;
        try {
            applicantResult = ApplicantDBProvider.INSTANCE.getApplicant_result(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(applicantResult);
    }

    @Test(expected = Exception.class)
    public void testSaveApplicantResultFalse() throws Exception {

        ApplicantResult applicantResult = new ApplicantResult();

        ApplicantDBProvider.INSTANCE.saveApplicant_result(applicantResult);

    }


    @Test
    public void testGetApplicantResultFalse(){
        ApplicantResult applicantResult = null;
        try {
            applicantResult = ApplicantDBProvider.INSTANCE.getApplicant_result(10050);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNull(applicantResult);
    }

    @Test
    public void testGetApplicantResultsFalse(){
        List<ApplicantResult> applicantResultList = null;

        try {
            applicantResultList = ApplicantDBProvider.INSTANCE.getApplicantResults();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertFalse(applicantResultList.isEmpty());
    }

    @Test
    public void testEditApplicantResultTrue() throws Exception {

        ApplicantResult applicantResult = ApplicantDBProvider.INSTANCE.getApplicant_result(1);
        ApplicantDBProvider.INSTANCE.saveApplicant_result(applicantResult);

    }

    @Test
    public void testDeleteApplicantResultException() throws Exception {

        ApplicantDBProvider.INSTANCE.deleteApplicant_result(100);

    }


}
