/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Model.Appointment;
import Model.Data;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TimeZone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Eric
 */
public abstract class DateAndTime {
    //Members
    private static ZoneId localZoneID = ZoneId.of(TimeZone.getDefault().getID());
    private static ObservableList<LocalDateTime> localZonedDateTime = FXCollections.observableArrayList();
    private static ObservableList<LocalTime> localStartTimes = FXCollections.observableArrayList();
    private static ObservableList<LocalTime> localEndTimes = FXCollections.observableArrayList();
    private static ObservableList<Month> allMonths = FXCollections.observableArrayList();
    
    
    public static void setAppointmentTimes() {
        Data.clearAppointmentTimes();
        LocalDate startDate = LocalDate.now();
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(22, 0);
        LocalDateTime startDateTime = LocalDateTime.of(startDate, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(startDate, endTime); 
        ZonedDateTime zonedStartDateTime = startDateTime.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime zonedEndDateTime = endDateTime.atZone(ZoneId.of("America/New_York"));
        while(zonedStartDateTime.isBefore(zonedEndDateTime) || zonedStartDateTime.isEqual(zonedEndDateTime)) {
            Data.addAppointmentTime(zonedStartDateTime);
            zonedStartDateTime = zonedStartDateTime.plusMinutes(15);
        }    
    }  
    
    public static void convertAppointmentTimes() {
        localZonedDateTime.clear();
        ObservableList<ZonedDateTime> estZonedAppointmentTimes = Data.getAllAppointmentTimes();
        for(ZonedDateTime zonedDateTime : estZonedAppointmentTimes) {
            zonedDateTime = zonedDateTime.withZoneSameInstant(localZoneID);
            LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
            localZonedDateTime.add(localDateTime);
        }
    }
    
    public static ObservableList<LocalTime> getConvertedStartTimes() {
        localStartTimes.clear();
        for(LocalDateTime localDateTime : localZonedDateTime) {
            LocalTime localTime = localDateTime.toLocalTime();
            localStartTimes.add(localTime);
        }
        
        return localStartTimes;
    }
    
    public static ObservableList<LocalTime> getConvertedEndTimes(LocalTime startTime) {
        localEndTimes.clear();
        for(LocalTime endTime : localStartTimes) {
            if(endTime.isAfter(startTime)) {
                localEndTimes.add(endTime);
            }
        }
        return localEndTimes;    
    }
    
    public static LocalDateTime getMonthStart(Month month) {
        LocalDateTime startLDT = null;
        int year = LocalDateTime.now().getYear();
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalTime startTime = LocalTime.of(0, 0);
        switch (month) {
            case JANUARY:
                startDate = startDate.withMonth(1);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case FEBRUARY:
                startDate = startDate.withMonth(2);
                startLDT = LocalDateTime.of(startDate, startTime);
            break;
            case MARCH:
                startDate = startDate.withMonth(3);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case APRIL:
                startDate = startDate.withMonth(4);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case MAY:
                startDate = startDate.withMonth(5);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case JUNE:
                startDate = startDate.withMonth(6);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case JULY:
                startDate = startDate.withMonth(7);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case AUGUST:
                startDate = startDate.withMonth(8);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case SEPTEMBER:
                startDate = startDate.withMonth(9);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case OCTOBER:
                startDate = startDate.withMonth(10);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case NOVEMBER:
                startDate = startDate.withMonth(11);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
            case DECEMBER:
                startDate = startDate.withMonth(12);
                startLDT = LocalDateTime.of(startDate, startTime);
                break;
        }
        return startLDT;
    }
    
    public static LocalDateTime getMonthEnd(Month month) {
        LocalDateTime endLDT = null;
        int year = LocalDateTime.now().getYear();
        LocalDate endDate = LocalDate.of(year, 1, 1);           
        LocalTime endTime = LocalTime.of(23, 59);
        switch (month) {
            case JANUARY:
                endDate = endDate.withMonth(1);
                int janLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(janLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case FEBRUARY:
                endDate = endDate.withMonth(2);
                int febLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(febLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case MARCH:
                endDate = endDate.withMonth(3);
                int marLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(marLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case APRIL:
                endDate = endDate.withMonth(4);
                int aprLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(aprLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case MAY:
                endDate = endDate.withMonth(5);
                int mayLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(mayLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case JUNE:
                endDate = endDate.withMonth(6);
                int junLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(junLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case JULY:
                endDate = endDate.withMonth(7);
                int julLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(julLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case AUGUST:
                endDate = endDate.withMonth(8);
                int augLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(augLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case SEPTEMBER:
                endDate = endDate.withMonth(9);
                int sepLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(sepLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case OCTOBER:
                endDate = endDate.withMonth(10);
                int octLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(octLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case NOVEMBER:
                endDate = endDate.withMonth(11);
                int novLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(novLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
            case DECEMBER:
                endDate = endDate.withMonth(12);
                int decLength = endDate.lengthOfMonth();
                endDate = endDate.withDayOfMonth(decLength);
                endLDT = LocalDateTime.of(endDate, endTime);
                break;
        }
        return endLDT;
    }
    
    public static ObservableList<Month> getAllMonths() {
        allMonths.clear();
        for(Month month : Month.values()) {
            allMonths.add(month);
        }
        return allMonths;
    }
    
}
