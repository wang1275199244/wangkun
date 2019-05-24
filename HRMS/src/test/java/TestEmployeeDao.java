import com.wk.dao.EmployeeDao;
import com.wk.model.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployeeDao {
    private ApplicationContext context
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testGetEmployeeById(){
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = employeeDao.getEmployeeById(1);
        System.out.println(employee);
    }

}
