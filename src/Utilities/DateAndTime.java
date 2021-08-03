/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Model.Data;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    public static void dateTime() {
        LocalDate japanDate = LocalDate.now();
        System.out.println(japanDate.toString());
        
        LocalTime japanTime = LocalTime.now();
        System.out.println(japanTime.toString());
        
        ZoneId japanZoneID = ZoneId.of("Japan");
        System.out.println(japanZoneID.toString());
        
        ZonedDateTime japanZDT = ZonedDateTime.of(japanDate, japanTime, japanZoneID);
        System.out.println(japanZDT.toString());
        
        ZoneId localZoneID = ZoneId.of(TimeZone.getDefault().getID());
        System.out.println(localZoneID.toString());
        
        Instant japanToUTC = japanZDT.toInstant();
        System.out.println(japanToUTC.toString());
        
        ZonedDateTime japanToLocalZDT = japanZDT.withZoneSameInstant(localZoneID);
        System.out.println(japanToLocalZDT.toString());
        
        ZonedDateTime gmtToLocalZDT = japanToUTC.atZone(localZoneID);
        System.out.println(gmtToLocalZDT.toString());
    }
    
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
            System.out.println(zonedStartDateTime.toString());
        }    
    }  
    
    public static void convertAppointmentTimes() {
        localZonedDateTime.clear();
        ObservableList<ZonedDateTime> estZonedAppointmentTimes = Data.getAllAppointmentTimes();
        for(ZonedDateTime zonedDateTime : estZonedAppointmentTimes) {
            zonedDateTime = zonedDateTime.withZoneSameInstant(localZoneID);
            LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
            localZonedDateTime.add(localDateTime);
            System.out.println(localDateTime);
        }
    }
    
    public static ObservableList<LocalTime> getConvertedStartTimes() {
        localStartTimes.clear();
        for(LocalDateTime localDateTime : localZonedDateTime) {
            LocalTime localTime = localDateTime.toLocalTime();
            localStartTimes.add(localTime);
            System.out.println(localTime);
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
}
