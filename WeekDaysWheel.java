package Question3;

import Question1.Rollable;
import Question2.Wheel;


public class WeekDaysWheel extends Wheel implements Rollable {

    private int minValue = 0;
    private int maxValue = 6;
    private String initialwWeekDay;
    private String weekDays[] = {"Sat","Sun","Mon","Tue","Wed","Thu","Fri"};
    public String weekDay;

    //Constructor method sets value based on zellers congruence method
    public WeekDaysWheel( int day, int month, int year){
        setValue(zellers(day, month, year));

        weekDay = weekDays[zellers(day,month,year)];
        initialwWeekDay = weekDay;
    }


    //Determines the weekday represented as an integer of given the day, month and year
    public int zellers (int day,int month, int year ){

        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2)
        {
            month = 14;
            year--;
        }

        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = day + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;

        return h;
    }


    // Gets the min value of the class
    public int getMin(){
        return minValue;
    }

    // Gets the max value of the class
    public int getMax() {
        return maxValue;
    }

    //Rolls the wheel one step up, setting value back to the min value when it goes over max value
    public void rollUp() {

        if ((Integer)(getValue())+1>maxValue) {

            setValue(minValue);

        }
        else {
            setValue((Integer) (getValue()) + 1);
        }
        weekDay = weekDays[(Integer)getValue()];
    }

    //Rolls the wheel one step down, setting value back to the min value when it goes over max value
    @Override
    public void rollDown() {

        if ((Integer)(getValue())-1<minValue) {

            setValue(maxValue);

        }
        else {
            setValue((Integer) (getValue()) - 1);
        }
        weekDay = weekDays[(Integer)getValue()];
    }


    //Sets the value field to the initial weekday
    @Override
    public void reset() {
        weekDay = initialwWeekDay;
    }

    //Return whether the last wheel step caused a rollover
    @Override
    public boolean isRolledOver() {
        return ((Integer) (getValue()) + 1) > maxValue || ((Integer) (getValue()) - 1) < minValue;
    }
}
