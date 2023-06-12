package Homework;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;

public class task_1 {
    public static void start() {
        String sql_example = "select * from students where ";
        JSONObject js = jsonImport("File.json");
        String[] fields = {"name", "country", "city", "age"};
        StringBuilder sql = new StringBuilder(sql_example);
        boolean firstResult = true;

        for (String field : fields) {
            if (!((String) js.get(field)).equals("null")) {
                if (firstResult) {
                    firstResult = false;
                } else {
                    sql.append(" and ");
                }
                sql.append(field);
                sql.append(" = '").append((String) js.get(field)).append("'");
            }
        }
        System.out.println(sql);
    }
    public static JSONObject jsonImport(String file_name) {
        try (FileReader file = new FileReader(file_name)) {
            Object o = new JSONParser().parse(file);
            return (JSONObject) o;
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
