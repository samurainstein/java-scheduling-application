/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 *
 * @author Eric
 */
public abstract class DateAndTime {
    //Members
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
    
}
