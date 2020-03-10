import com.grouproject.sem.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

//    @Test
//    void testGetEmployee()
//    {
//        Employee emp = app.getEmployee(255530);
//        assertEquals(emp.emp_no, 255530);
//        assertEquals(emp.first_name, "Ronghao");
//        assertEquals(emp.last_name, "Garigliano");
//    }

    @Test
    void test_foo()
    {
        int cheese = 19;
        assertEquals(cheese, 19);
    }
}
