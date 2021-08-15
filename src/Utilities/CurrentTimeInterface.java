/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.time.LocalTime;

/**
 * This interface is used to define a single method for getting a LocalTime object that will be used with a lambda expression. 
 * @author Eric Matelyan
 */
public interface CurrentTimeInterface {
    /**
     * This Method is used with a lambda expression to return a LocalTime object. 
     * @return Returns a LocalTime object
     */
    LocalTime getCurrentTime();
}
