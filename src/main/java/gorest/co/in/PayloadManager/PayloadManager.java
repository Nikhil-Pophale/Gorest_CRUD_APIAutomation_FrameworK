package gorest.co.in.PayloadManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import gorest.co.in.PayloaD.CreateUser;
import gorest.co.in.FAKER.faker;
import com.fasterxml.jackson.core.JsonProcessingException;
import gorest.co.in.PayloaD.UpdateUser;
import org.testng.annotations.Test;

public class PayloadManager {
    ObjectMapper objectMapper;

    public String Createuser() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        CreateUser c = new CreateUser();
        c.setName(faker.name());
        c.setGender("male");
        c.setEmail(faker.email());
        c.setStatus("Active");
        String createuser = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(c);
        return createuser;

    }

    public String Updateuser() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        UpdateUser u = new UpdateUser();
        u.setId(faker.id());
        u.setName(faker.name());
        u.setEmail(faker.email());
        u.setGender("female");
        u.setStatus("Active");

        String updateuser = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);
        return updateuser;

    }
}
