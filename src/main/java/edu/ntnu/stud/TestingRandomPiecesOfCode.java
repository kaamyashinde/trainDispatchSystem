package edu.ntnu.stud;

import org.apache.commons.lang3.StringUtils;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestingRandomPiecesOfCode {

  private String username;
  private int age;

  public TestingRandomPiecesOfCode(String username, int age) {
    // Validation for username (assuming non-null and non-empty)
    if (username == null || username.isEmpty()) {
      throw new IllegalArgumentException("Username cannot be null or empty");
    }

    // Validation for age (assuming a valid age range)
    if (age < 0 || age > 150) {
      throw new IllegalArgumentException("Invalid age");
    }

    this.username = username;
    this.age = age;
  }

  // Getters and other methods...

  // Example of how to update the username with validation
  public void setUsername(String newUsername) {
    try {
      this.username = username;
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Username cannot be null or empty");
    }
  }

  // Example of how to update the age with validation
  public void setAge(int newAge) {
    if (newAge < 0 || newAge > 150) {
      throw new IllegalArgumentException("Invalid age");
    }

    this.age = newAge;
  }

  public static void tryingTimeThingy() {
    int time = 1390;
    int minutes = time % 100;
    System.out.println(minutes);
    int minutesToAdd = 0;
    if (minutes > 0) {
      // Calculate the number of minutes to add to round up to the next hour

      if (minutes == 60) {
        minutesToAdd = 40;
      } else if (minutes > 60) {
        minutesToAdd = minutes - 60;
      }
      time += minutesToAdd;
    }
    System.out.println(time);
    System.out.println("-----------------");
  }

  public static void tryingFormatter() {
    LocalTime time1 = LocalTime.of(10, 30);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime = time1.format(formatter); // Formats as "10:30:00"
    LocalTime parsedTime =
        LocalTime.parse("15:45:00", formatter); // Parses the string into a LocalTime instance

    DateTimeFormatter newformatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime parsedTimeNew = LocalTime.parse("15:45", newformatter);
    System.out.println(parsedTimeNew);
    System.out.println(parsedTimeNew.plusMinutes(90));
  }

  public static void register() {
    TrainDepartureRegister newRegister = new TrainDepartureRegister();
    TrainDeparture td1 = new TrainDeparture(LocalTime.of(10, 30), "test", 1, "test", 1, 3);
    TrainDeparture td2 = new TrainDeparture(LocalTime.of(12, 30), "test", 2, "test", 0, 2);
    TrainDeparture td3 = new TrainDeparture(LocalTime.of(15, 30), "test", 3, "test", 0, -1);

    newRegister.addTrainDeparture(td1);
    newRegister.addTrainDeparture(td2);
    newRegister.addTrainDeparture(td3);

    System.out.println(newRegister.toString());
  }

  public static void main(String[] args) {

    // TestingRandomPiecesOfCode newCode = new TestingRandomPiecesOfCode(" ", 1000);
    // LocalTime newTime = LocalTime.of(10, 30);
    // TestingRandomPiecesOfCode cd = new TestingRandomPiecesOfCode(null, 3);
    TrainDepartureRegister kristiansand = new TrainDepartureRegister();

    kristiansand.addTrainDeparture(
        new TrainDeparture(LocalTime.of(10, 0), "F2", 2, "Stavanger", 0, 2));
    kristiansand.addTrainDeparture(
        new TrainDeparture(LocalTime.of(12, 20), "F3", 4, "Bergen", 0, -1));
    // System.out.println(kristiansand.makeItStringy(kristiansand.showDeparturesThroughDestination("stavanger")));

      System.out.println(StringUtils.center("Departure Time", 15) + StringUtils.center("Destination", 20) + StringUtils.center("Platform", 10));
    System.out.println(StringUtils.center("Departure Time", 15) + StringUtils.left("Destination", 20) + StringUtils.right("Platform", 10));


  }
}
