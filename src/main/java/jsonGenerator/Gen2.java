package jsonGenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Gen2 {

    public static void main(String[] args) throws IOException {
        UserDTO userDTO = new UserDTO("Vania", 24, "+380505554433");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        UserDTO[] users = new UserDTO[3];
        users[0] = userDTO;
        users[1] = new UserDTO("Vania2", 25, "+380505554455");
        users[2] = new UserDTO("Vania3", 55, "+380505554466");
        String toJson = gson.toJson(users);
        System.out.println(toJson);
        OutputStream fos = new FileOutputStream("src/main/java/jsonGenerator/user2.json");
        fos.write(toJson.getBytes(StandardCharsets.UTF_8));
        FileWriter fw = new FileWriter("src/main/java/jsonGenerator/user2.json");
        gson.toJson(users, fw);
        fw.close();
        FileReader fr = new FileReader("src/main/java/jsonGenerator/user2.json");
        Type type = TypeToken.getParameterized(List.class, UserDTO.class).getType();
        List<UserDTO> userDTOList = (List<UserDTO>) gson.fromJson(fr, type);
        for (UserDTO dto : userDTOList) {
            System.out.println(dto);
        }
    }
}
