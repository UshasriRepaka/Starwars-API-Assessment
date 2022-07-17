import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.people.PeopleData;
import com.swapi.people.PeopleService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import com.swapi.people.Results;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleApplicationTest {

    private Integer TOTAL_PEOPLE = 82;
    private Integer TOTAL_HEIGHT_COUNT = 10;
    private String url = "https://swapi.dev/api/people";
    PeopleService peopleService = new PeopleService();

    // JUnit test method to check whether the number of people objects returned is 82
    @Test
    public void testPeopleForTotalItems() throws Exception {
        PeopleData result = peopleService.findAllPeople(url);
        Integer count = result.getCount();
        assertThat(count).isEqualTo(TOTAL_PEOPLE);
    }

    // JUnit test method to check whether the number of people who height is greater than 200
    @Test
    public void testPeopleForHeightGreaterThan200() throws Exception {
        List<String> givenNames = new ArrayList<String>();
        givenNames.add("Darth Vader");
        givenNames.add("Chewbacca");
        givenNames.add("Roos Tarpals");
        givenNames.add("Rugor Nass");
        givenNames.add("Yarael Poof");
        givenNames.add("Taun We");
        givenNames.add("Grievous");
        givenNames.add("Tarfful");
        givenNames.add("Tion Medon");
        givenNames.add("Lama Su");

        List<String> actualNames = new ArrayList<String>();
        int count = 0;
        PeopleData result;
        do {

            result = peopleService.findAllPeople(url);

            for (Results r : result.getResults()) {
                if (!r.getHeight().contains("unknown") && Integer.parseInt(r.getHeight()) > 200 ) {
                    count += 1;
                    actualNames.add(r.getName().trim());
                }
            }
                url = result.getNext();
            Thread.sleep(2000);
        }while (url!=null);
        assertThat(count).isEqualTo(TOTAL_HEIGHT_COUNT);
        assertThat(actualNames).hasSameElementsAs(givenNames);
    }
}
