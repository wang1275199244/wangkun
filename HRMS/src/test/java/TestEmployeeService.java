import com.wk.model.Employee;
import com.wk.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:SpringMVC-servlet.xml" })
public class TestEmployeeService {

    @Resource
    private EmployeeService employeeService;

    @Test
    public void testGetEmployeeById(){
        Employee employee = employeeService.getEmployeeById(1);
        System.out.println(employee);
    }
}
