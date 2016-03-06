/*
  File name: DayOfWeek.java
  Author: Hannah Johnson
  Purpose: Handles day of the week logic
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DayOfWeek {

  // Month variables
  private int jan = 1;
  private int feb = 2;
  private int mar = 3;
  private int apr = 4;
  private int may = 5;
  private int jun = 6;
  private int jul = 7;
  private int aug = 8;
  private int sep = 9;
  private int oct = 10;
  private int nov = 11;
  private int dec = 12;

  // The user set month and day, and the resulting day of week variables
  private int m_month = 0;
  private int m_day = 0;
  private String m_dayOfWeek = "";

  /**
    @pre: none
    @post: set m_month and m_day to zero
    @return: none
  */
  public DayOfWeek() {
    m_month = 0;
    m_day = 0;
    m_dayOfWeek = "";
  }

  /**
    @pre: valid integers month and day and string day of week
    @post: set m_month and m_day and m_dayOfWeek to passed in values
    @return: none
  */
  public DayOfWeek(int month, int day, String dayOfWeek) {
    m_month = month;
    m_day = day;
    m_dayOfWeek = dayOfWeek;
  }

  /**
    @pre: valid month and day integers passed in
    @post: calculates day of the week from given month and day by modding the number of
    days that have passed in 2016 so far by 7. calculatePosition function is then called
    and returns accurate day of week as a string and not simply an integer position
    @return: day of the week as a string
  */
  public void calculateDayOfWeek() {
    int positionInWeek;
    if(this.m_month == 1) {
      positionInWeek = m_day % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 2) {
      positionInWeek = (m_day + 31) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 3) {
      positionInWeek = (m_day + 31 + 29) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 4) {
      positionInWeek = (m_day + 31 + 29 + 31) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 5) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 6) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 7) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 8) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 9) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 10) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 11) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    else if(this.m_month == 12) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30) % 7;
      m_dayOfWeek = calculatePosition(positionInWeek);
    }
    return;
  }

  /**
    @pre: passes in valid integer for positionInWeek
    @post: checks which day of week is at given position. Note: 0 is set to
    Thursday because Jan 1, 2016 was a Thursday.
    @return: returns day of week as a string
  */
  public String calculatePosition(int positionInWeek) {
    if(positionInWeek == 0) { return "Thursday"; }
    else if(positionInWeek == 1) { return "Friday"; }
    else if(positionInWeek == 2) { return "Saturday"; }
    else if(positionInWeek == 3) { return "Sunday"; }
    else if(positionInWeek == 4) { return "Monday"; }
    else if(positionInWeek == 5) { return "Tuesday"; }
    else if(positionInWeek == 6) { return "Wednesday"; }
    return "";
  }

  /**
    @pre: none
    @post: none
    @return: returns day of week as a string
  */
  public String getDayOfWeek() {
    return m_dayOfWeek;
  }

  /**
    @pre: none
    @post: none
    @return: returns month as an int
  */
  public int getMonth() {
    return m_month;
  }

  /**
    @pre: none
    @post: none
    @return: set m_month to passed in month
  */
  public void setMonth(int month) {
    m_month = month;
  }

  /**
    @pre: valid day as integer
    @post: set m_day to passed in day
    @return: none
  */
  public void setDay(int day) {
    m_day = day;
  }

  /**
    @pre: none
    @post: none
    @return: returns day of week as int
  */
  public int getDay() {
    return m_day;
  }
  /**
    @pre: none
    @post: checks which day of the week it currently is
    @return: returns the day after the current day
  */
  public String incrementDayOfWeek() {
    // Would this work?
    if(m_dayOfWeek == "Thursday") { m_dayOfWeek = "Friday"; }
    else if(m_dayOfWeek == "Friday") { m_dayOfWeek = "Saturday"; }
    else if(m_dayOfWeek == "Saturday") { m_dayOfWeek = "Sunday"; }
    else if(m_dayOfWeek == "Sunday") { m_dayOfWeek = "Monday"; }
    else if(m_dayOfWeek == "Monday") { m_dayOfWeek = "Tuesday"; }
    else if(m_dayOfWeek == "Tuesday") { m_dayOfWeek = "Wednesday"; }
    else if(m_dayOfWeek == "Wednesday") { m_dayOfWeek = "Thursday"; }
    else { return ""; }

    return "";
  }



}
