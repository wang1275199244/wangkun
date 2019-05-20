import com.wk.dao.RecruitmentInformationDao;
import com.wk.model.RecruitmentInformation;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class TestRecruitmentInformationDao {
    private ApplicationContext context
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testGetAllRecruitmentInformations(){

        RecruitmentInformationDao recruitmentInformationDao = (RecruitmentInformationDao) context.getBean("recruitmentInformationDao");
        List<RecruitmentInformation> list = recruitmentInformationDao
                .getAllRecruitmentInformations();
        System.out.println(list);
    }


    @Test
    public void testGetRecruitmentInformationByState(){

        RecruitmentInformationDao recruitmentInformationDao = (RecruitmentInformationDao) context.getBean("recruitmentInformationDao");
        List<RecruitmentInformation> list = recruitmentInformationDao.getRecruitmentInformationsByState(1);
        System.out.println(list);

    }

    @Test
    public void testGetRecruitmentInformationById(){

        RecruitmentInformationDao recruitmentInformationDao = (RecruitmentInformationDao) context.getBean("recruitmentInformationDao");
        RecruitmentInformation ri = recruitmentInformationDao.getRecruitmentInformationsById(1);
        System.out.println(ri);

    }
}
