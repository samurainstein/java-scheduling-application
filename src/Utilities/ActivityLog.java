/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class is used to write login activity to a .txt file
 * @author Eric Matelyan
 */
public abstract class ActivityLog {
    /**
     * Method for documenting login attempts, including a timestamp, user info, and whether login was successful or not. 
     * @param userID Used to check if username was found
     * @param username Username that attempted to login
     * @throws IOException 
     */
    public static void loginAttempt(int userID, String username) throws IOException {
        //Lambda Expression
        CurrentTimeInterface currentTime = () -> LocalTime.now();
        LocalTime time = currentTime.getCurrentTime();
        if(userID == 0) {
            LocalDate date = LocalDate.now();
            String fileName = "login_activity.txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Login Failed Username:" + username + " Date:" + date + " Time" + time);
            printWriter.close();
        }
        else {
            LocalDate date = LocalDate.now();
            String fileName = "login_activity.txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Login Successful Username:" + username + " Date:" + date + " Time" + time);
            printWriter.close();
        }
    }
}
