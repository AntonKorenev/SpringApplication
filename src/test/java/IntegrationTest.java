import com.company.SpringApplication.Connectors.ConnectorCSV;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The Integration test class tests the correctness of data transfer/transform
 * processing in app by making comparison between the data in
 * {@link com.company.SpringApplication.Connectors.ConnectorCSV} and the data in Publishers
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
        assertEquals(true,false);
    }

    /**
     * Method to test the correctness of data coming to Upstream according to the first CSV file
     * in connector
     */
    @Test
    public void testUpstreamRecord(){
        System.out.println("Starting upstream record correctness test");
        ConnectorCSV csv;
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
