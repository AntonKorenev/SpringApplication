import org.junit.Test;

/**
 * The Integration test class tests the correctness of data transfer/transform
 * processing in app by making comparison between the data in
 * {@link com.company.spring_application.connector.ConnectorCSV} and the data in publisher
 * package classes(or the entities/services they represent)
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class IntegrationTest {
    /**
     * Method to test the correctness of data in DB according to the first CSV file
     * in connector
     */
    @Test
    public void testDatabaseRecord(){
        System.out.println("Starting database record correctness test");
    }

    /**
     * Method to test the correctness of data coming to Upstream according to the first CSV file
     * in connector
     */
    @Test
    public void testUpstreamRecord(){
        System.out.println("Starting upstream record correctness test");
    }

    /**
     * Method to test the correctness of data in Dashboard according to the first CSV file
     * in connector
     */
    @Test
    public void testDashboardRecord(){
        System.out.println("Starting dashboard record correctness test");
    }
}
