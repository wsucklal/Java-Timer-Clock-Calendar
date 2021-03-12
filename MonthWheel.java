package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class MonthWheel extends Wheel implements Rollable {

    private int minValue =0;
    private int maxValue =11;
    private int monthDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    private String monthNames[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private int initialMonth;

    public String month;

    //Constructor method that sets the value and assigns the day of February
    public MonthWheel(int month,int febDay){
        setValue(month);

        initialMonth = month;
        monthDays[1]= febDay;
    }

    //Sets the month name based on the month wheel value
    public String monthName(){
        month = monthNames[(Integer)getValue()-1];
        return month;
    }

    //Returns min Value
    public int getMin(){
        return minValue;
    }

    //Returns max value
    public int getMax() {
        return maxValue;
    }

    //Returns the length of the month
    public int monthLength(){
        return monthDays[(Integer)getValue()-1];
    }


    //Rolls the wheel one step up, setting value back to the min value when it goes over max value
    public void rollUp() {

        if ((Integer)(getValue())+1>maxValue) {

            setValue(minValue);

        }
        else {
            setValue((Integer) (getValue()) + 1);
        }

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
    }

    //Sets the value field to the initial weekday
    @Override
    public void reset() {
         setValue(initialMonth);
    }


    //Return whether the last wheel step caused a rollover
    @Override
    public boolean isRolledOver() {
        return ((Integer) (getValue()) + 1) > maxValue || ((Integer) (getValue()) - 1) < minValue;
    }
}
