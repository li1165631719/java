package day17.com.atguigu.team.junit;

import day17.com.atguigu.team.domain.Employee;
import day17.com.atguigu.team.service.NameListService;
import org.testng.annotations.Test;

/**
 * 对NameListService类的测试
 *
 * @author
 * @version v1.0
 * @Description
 * @data 2023年2月12日下午16：28
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees() {

        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }
    }

    @Test
    public void testGetEmployee() {
        NameListService nameListService = new NameListService();
        int id = 101;
        try {
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

}
