import org.junit.Test;

/**
 * @author AntonKorenev
 * @version 0.1
 */
public class ProcessorTest {
    /**
     * Method for testing whether Mapper has access to Processor or not
     */
    @Test(timeout = 100)
    public void testAccessFromMapper(){
        System.out.println("Starting Mapper access test");
    }

    /**
     * Method for testing whether Connector has access to Processor or not
     */
    @Test(timeout = 100)
    public void testAccessFromConnector(){
        System.out.println("Starting Connector access test");
    }

    /**
     * Method for testing whether Processor has access to DB or not
     */
    @Test(timeout = 100)
    public void testAccessToDB(){
        System.out.println("Starting DB access test");
    }

    /**
     * Method for testing whether Processor has access to Upstream or not
     */
    @Test(timeout = 100)
    public void testAccessToUpstream(){
        System.out.println("Starting Upstream access test");
    }

    /**
     * Method for testing whether Processor has access to Dashboard or not
     */
    @Test(timeout = 100)
    public void testAccessToDashboard(){
        System.out.println("Starting Dashboard access test");
    }
}
