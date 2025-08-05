package com.selectorhub.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Test Data Provider for managing test data from JSON files
 */
public class TestDataProvider {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static UserData[] getUserTestData() {
        List<UserData> userDataList = new ArrayList<>();
        
        try {
            InputStream inputStream = TestDataProvider.class.getClassLoader()
                    .getResourceAsStream("testdata/users.json");
            
            if (inputStream != null) {
                JsonNode rootNode = objectMapper.readTree(inputStream);
                JsonNode usersNode = rootNode.get("users");
                
                if (usersNode.isArray()) {
                    for (JsonNode userNode : usersNode) {
                        UserData userData = new UserData.Builder()
                                .email(userNode.get("email").asText())
                                .password(userNode.get("password").asText())
                                .company(userNode.get("company").asText())
                                .mobile(userNode.get("mobile").asText())
                                .email2(userNode.get("email2").asText())
                                .carPreference(userNode.get("carPreference").asText())
                                .build();
                        userDataList.add(userData);
                    }
                }
            } else {
                // Fallback to hardcoded data if JSON file is not found
                userDataList.add(createDefaultUserData());
            }
        } catch (IOException e) {
            System.err.println("Error reading test data: " + e.getMessage());
            userDataList.add(createDefaultUserData());
        }
        
        return userDataList.toArray(new UserData[0]);
    }

    private static UserData createDefaultUserData() {
        return new UserData.Builder()
                .email("test.user@example.com")
                .password("SecurePass123!")
                .company("Test Automation Inc")
                .mobile("9876543210")
                .email2("secondary.email@example.com")
                .carPreference("Audi")
                .build();
    }

    public static Object[][] getUserDataAsObjectArray() {
        UserData[] users = getUserTestData();
        Object[][] data = new Object[users.length][1];
        for (int i = 0; i < users.length; i++) {
            data[i][0] = users[i];
        }
        return data;
    }
}
