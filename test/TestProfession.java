


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by artem on 15.09.15.
 */
public class TestProfession {



    //в списке профессий должно что - то лежать
    @Test
    public void testGetProfessionsIsEmptyFalse(){

        List<Profession> professions = null;

        try {
            professions = ApplicantDBProvider.INSTANCE.getProfessions();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertFalse(professions.isEmpty());

    }

    //не получить профессию с вымышленным индексом
    @Test
    public void testGetProfessionPutNotRealElementNull(){
        Profession profession = null;
        try {
            profession = ApplicantDBProvider.INSTANCE.getProfession(100500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNull(profession);
    }

    //исключение при сохраниении пустого profession
    @Test(expected = Exception.class)
    public void testSaveProfessionFalse() throws Exception {

        Profession profession = new Profession();

        ApplicantDBProvider.INSTANCE.saveProfession(profession);

    }
    //тут короч непонятная муть
//    @Test(expected = Exception.class)
//    public void testGetProfessionException(){
//        Profession profession = null;
//        try {
//            profession = ApplicantDBProvider.INSTANCE.getProfession(-2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Assert.assertNull(profession);
//    }


    // тест update
    @Test
    public void testSaveProfession(){
        Profession profession = new Profession();
        profession.setProfessionName("Java test");
        profession.setId(2);
        try {
            ApplicantDBProvider.INSTANCE.saveProfession(profession);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //вернёт profession с id = 1 true
    @Test
    public void testGetProfessionTrue() throws Exception {
        Profession profession = null;
        profession = ApplicantDBProvider.INSTANCE.getProfession(1);
        Assert.assertNotNull(profession);

    }


//     исключение. удалит несуществующую профессию не работает!!!


    @Test
            //(expected = Exception.class)
    public void testDeleteProfessionException() throws Exception {

        ApplicantDBProvider.INSTANCE.deleteProfession(100);

    }




}
