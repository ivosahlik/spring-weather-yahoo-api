package cz.ivosahlik.weatheryahooapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class WeatherYahooApiApplicationTests {

	private static final String JSON_QUERY = "src/main/resources/query_1.json";

	@Test
	public void contextLoads() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(new File(JSON_QUERY));

		int countResult = jsonNode.get("count").asInt();
		int countExpected = 10;

		assertEquals(countExpected, countResult);

	}

}
