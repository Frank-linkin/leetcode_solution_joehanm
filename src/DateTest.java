import org.junit.Test;

import java.util.Date;

import static java.lang.Thread.sleep;

public class DateTest {

    @Test
    public void test1() throws InterruptedException {
        Date date = new Date();
        System.out.println(date.getTime());
        sleep(1000);
        System.out.println(date.getTime());
    }
}
