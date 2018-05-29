package com.test.jerseyclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Component
public class Program implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting program");


        System.out.println("*****************USERS*****************");
        testGetAllUsers();
        System.out.println("*****************USER BY USERNUMBER*****************");
        testGetUserByUserNumber();
        System.out.println("*****************WORKITEMS FOR CERTAIN USER*****************");
        testGetAllWorkItemsForUser();
        System.out.println("*****************UPDATED A USER*****************");
        testUpdateUser();
        System.out.println("*****************TEAMS*****************");
        testGetAllTeams();
        System.out.println("*****************CERTAIN TEAM*****************");
        testGetTeam();
        System.out.println("*****************ADDED A USER TO A TEAM*****************");
        testaddUserToTeam();
        System.out.println("*****************WORKITEMS FOR A TEAM*****************");
        testGetWorkItemsForTeam();
        System.out.println("*****************WORKITEMS*****************");
        testGetAllWorkItems();
        System.out.println("*****************Added USER*****************");
        testAddUser();
        System.out.println("*****************UPDATED WORKITEM*****************");
        testUpdateWorkItem();
        System.out.println("*****************WORKITEM FROM DATE X TO DATE X*****************");
        testGetAllWorkItemsByDate();
        System.out.println("*****************ISSUE CREATED*****************");
        testCreateIssue();
    }


    private static void testGetAllUsers() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("users");


        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }

    private static void testGetUserByUserNumber() throws IOException {
        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/users/945")
                .request(MediaType.APPLICATION_JSON);


        Response response = builder.get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }


    private static void testGetAllWorkItemsForUser() throws IOException {
        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/users/945/workitems")
                .request(MediaType.APPLICATION_JSON);


        Response response = builder.get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }



    private static void testGetWorkItemsForTeam() throws IOException {
        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/teams/5/workitems")
                .request(MediaType.APPLICATION_JSON);


        Response response = builder.get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }




    private static void testUpdateUser() {

        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/users/627")
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Jasse");

        String input = "{\"firstName\":\"Uppdatering\",\"lastName\":\"Ett Efternamn\",\"username\":\"Ett username\",\"status\":\"true\"}";

        Response response = builder.put(Entity.json(input));
        System.out.println(response.getHeaders());

    }

    private static void testGetAllTeams() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("teams");


        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }


    private static void testGetTeam() throws IOException {
        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/teams/5")
                .request(MediaType.APPLICATION_JSON);


        Response response = builder.get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }


    private static void testaddUserToTeam() {

        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/teams/4/627")
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Jasse");


        Response response = builder.put(Entity.json(""));
        System.out.println(response.getHeaders());

    }




    private static void testGetAllWorkItems() throws IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("workitems");


        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }



    private static void testGetAllWorkItemsByDate() throws IOException {
        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/workitems")
                .queryParam("from", "20131001" )
                .queryParam("to", "20180529")
                .request(MediaType.APPLICATION_JSON);



        Response response = builder.get();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(response.readEntity(String.class), Object.class);
        String indented = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json);

        System.out.println(indented);
    }


    private static void testAddUser() {

        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/users")
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Jasse");

        String input = "{\"firstName\":\"Ett namn\",\"lastName\":\"Ett Efternamn\",\"username\":\"Ett username\",\"status\":\"true\"}";

        Response response = builder.post(Entity.json(input));
        System.out.println(response.getHeaders());

    }


    private static void testUpdateWorkItem() {

        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/workitems/20")
                .queryParam("user", "945")
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Jasse");

        String input = "{\"description\":\"TEST:UPPDATERAD\",\"workItemStatus\":\"DONE\"}";

        Response response = builder.put(Entity.json(input));
        System.out.println(response.getHeaders());

    }


    private static void testCreateIssue() {

        Client client = ClientBuilder.newClient();
        Invocation.Builder builder = client
                .target("http://localhost:8080/issues")
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Jasse");

        String input =
                "{" +
                        "\"description\": \"HEJHEJ\"," +
                        "\"workItem\": {" +
                        "\"id\": \"22\"" +
                        "}" +
                        "}";

        Response response = builder.post(Entity.json(input));

        System.out.println(response.getHeaders());
        System.out.println(response.readEntity(String.class));

    }


}
