package edu.miu.cs.cs489.odkoo;

import com.google.gson.*;
import edu.miu.cs.cs489.odkoo.model.Patient;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        List<Patient> patients = new ArrayList<>();

        // Add patients (Firstname, Lastname, Phone, Email, Mailing Address, DOB)
        patients.add(new Patient("John", "Doe", "555-1234", "john.doe@example.com", "123 Main St, Anytown, USA", LocalDate.of(1950, 5, 20)));
        patients.add(new Patient("Alice", "Smith", "555-2345", "alice.smith@example.com", "234 Oak Ave, Sometown, USA", LocalDate.of(1985, 8, 10)));
        patients.add(new Patient("Bob", "Johnson", "555-3456", "bob.johnson@example.com", "345 Pine Rd, Othertown, USA", LocalDate.of(1972, 12, 1)));
        patients.add(new Patient("Carol", "Williams", "555-4567", "carol.williams@example.com", "456 Maple Blvd, Newtown, USA", LocalDate.of(1995, 3, 15)));
        patients.add(new Patient("Eve", "Davis", "555-5678", "eve.davis@example.com", "567 Birch Ln, Oldtown, USA", LocalDate.of(2000, 1, 30)));

        // Sort by age descending (oldest first)
        patients.sort(Comparator.comparingInt(Patient::getAge).reversed());

        printReportAsJson(patients);
    }

    private static Gson buildGson() {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        // LocalDate serializer/deserializer
        builder.registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
            @Override
            public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.format(fmt));
            }
        });
        builder.registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
                return LocalDate.parse(json.getAsString(), fmt);
            }
        });
        return builder.create();
    }

    private static void printReportAsJson(List<Patient> patients) {
        Gson gson = buildGson();

        Map<String, Object> output = new HashMap<>();
        output.put("patients", patients);

        // Print all employees JSON
        System.out.println("--- List of All Patient (JSON) ---");
        System.out.println(gson.toJson(patients));
    }
}