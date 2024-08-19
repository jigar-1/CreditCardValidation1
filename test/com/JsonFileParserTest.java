package com;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class JsonFileParserTest {

    private JsonFileParser jsonFileParserUnderTest;

    @Before
    public void setUp() {

        jsonFileParserUnderTest = new JsonFileParser();
    }

    @Test
    public void testProcessEachValidRecord() {
        // Setup
        final JSONObject record = new JSONObject(new HashMap<>());
        final JSONObject expectedResult = new JSONObject(new HashMap<>());

        record.put("cardNumber","4410000000000000");
        record.put("expirationDate","4/25/2027");
        record.put("nameOfCardholder","Bob");
        System.out.println(record);
        expectedResult.put("CardNumber",Long.parseLong("4410000000000000"));
        expectedResult.put("CardType","Visa");
        expectedResult.put("Error","None");

        // Run the test
        final JSONObject result = jsonFileParserUnderTest.processEachRecord(record);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
