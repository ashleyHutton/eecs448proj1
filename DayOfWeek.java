/*
  File name: DayOfWeek.java
  Author: Hannah Johnson
  Purpose: Handles day of the week logic
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

class DayOfWeek {

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
    @pre: user set integers for month and day
    @post: sets member variables m_month and m_day to user specified day and month
    @return: none
  */
  public DayOfWeek(int month, int day) {
      m_month = month;
      m_day = day;

      // Calculate day of week from given month and day
      m_dayOfWeek = calculateDayOfWeek(m_month, m_day);

  }

  /**
    @pre: valid month and day integers passed in
    @post: calculates day of the week from given month and day by modding the number of
    days that have passed in 2016 so far by 7. calculatePosition function is then called
    and returns accurate day of week as a string and not simply an integer position
    @return: day of the week as a string
  */
  public String calculateDayOfWeek(m_month, m_day) {
    int m_positionInWeek;
    if(m_month == 1) {
      positionInWeek = m_day % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 2) {
      positionInWeek = (m_day + 31) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 3) {
      positionInWeek = (m_day + 31 + 29) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 4) {
      positionInWeek = (m_day + 31 + 29 + 31) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 5) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 6) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 7) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 8) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 9) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 10) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 11) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31) % 7;
      return calculatePosition(positionInWeek);
    }
    else if(m_month == 12) {
      positionInWeek = (m_day + 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30) % 7;
      return calculatePosition(positionInWeek);
    }

  }

  /**
    @pre: passes in valid integer for positionInWeek
    @post: checks which day of week is at given position. Note: 0 is set to
    Thursday because Jan 1, 2016 was a Thursday.
    @return: returns day of week as a string
  */
  public String calculatePosition(positionInWeek) {
    if(positionInWeek == 0) { return "Thursday"; }
    else if(positionInWeek == 1) { return "Friday"; }
    else if(positionInWeek == 2) { return "Saturday"; }
    else if(positionInWeek == 3) { return "Sunday"; }
    else if(positionInWeek == 4) { return "Monday"; }
    else if(positionInWeek == 5) { return "Tuesday"; }
    else if(positionInWeek == 6) { return "Wednesday"; }
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
    @post: checks which day of the week it currently is
    @return: returns the day after the current day
  */
  public String incrementDayOfWeek() {
    // Would this work?
    if(m_dayOfWeek == "Thursday") { return "Friday"; }
    else if(m_dayOfWeek == "Friday") { return "Saturday"; }
    else if(m_dayOfWeek == "Saturday") { return "Sunday"; }
    else if(m_dayOfWeek == "Sunday") { return "Monday"; }
    else if(m_dayOfWeek == "Monday") { return "Tuesday"; }
    else if(m_dayOfWeek == "Tueday") { return "Wednesday"; }
    else if(m_dayOfWeek == "Wednesday") { return "Thursday"; }
  }



}
