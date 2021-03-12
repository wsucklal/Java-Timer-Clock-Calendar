package Question3;

import Question1.CounterDisplay;

public class CalendarCounter implements CounterDisplay {

    private YearWheel yearWheel;
    private MonthWheel monthWheel;
    private DayWheel dayWheel;
    private WeekDaysWheel weekDaysWheel;

    //Constructor class creates instantiates calender wheels
    public CalendarCounter(int initialMonth, int initialDay, int initialYear){

        yearWheel = new YearWheel(initialYear);

        // Makes the February day 29 if it is a leap year
        if (yearWheel.isLeapYear()){
            monthWheel = new MonthWheel(initialMonth,29);
        }
        else{
            monthWheel = new MonthWheel(initialMonth,28);
        }

        dayWheel = new DayWheel(initialDay,monthWheel.monthLength());
        weekDaysWheel = new WeekDaysWheel(initialDay,initialMonth,initialYear);

    }

    //Resets all wheels to their initial values
    @Override
    public void reset() {
        yearWheel.reset();
        monthWheel.reset();
        dayWheel.reset();
        weekDaysWheel.reset();
    }

    //Randomizes the values of the wheel of the counter
    @Override
    public void shuffle() {
        monthWheel.setValue(((int)(Math.random() * (monthWheel.getMax() - monthWheel.getMin() + 1) + monthWheel.getMin())));
        dayWheel.setValue(((int)(Math.random() * (dayWheel.getMax() - dayWheel.getMin() + 1) + dayWheel.getMin())));
        weekDaysWheel.setValue(((int)(Math.random() * (weekDaysWheel.getMax() - weekDaysWheel.getMin() + 1) + weekDaysWheel.getMin())));
        yearWheel.setValue(((int)(Math.random() * (1000000 - 0 + 1) + 0)));;
    }

    //Increases the Integer Wheels with respect to each other once the previous wheel is rolled over
    @Override
    public void increase() {


        if(((Integer)(monthWheel.getValue())+1>monthWheel.getMax())&&((Integer)(dayWheel.getValue())+1>dayWheel.getMax())){
            yearWheel.rollUp();
        }

        if((Integer)(dayWheel.getValue())+1>dayWheel.getMax()){
            dayWheel.setMonthDays(monthWheel.monthLength());
            monthWheel.rollUp();
        }
        weekDaysWheel.rollUp();
        dayWheel.rollUp();

    }

    //Decreases the Integer Wheels with respect to each other once the previous wheel is rolled over
    @Override
    public void decrease() {

        if(((Integer)(monthWheel.getValue())-1<monthWheel.getMin())&&((Integer)(dayWheel.getValue())-1<dayWheel.getMin())){
            yearWheel.rollDown();
        }

        if((Integer)(dayWheel.getValue())-1<dayWheel.getMin()){

            monthWheel.rollDown();
            dayWheel.setMonthDays(monthWheel.monthLength());
        }
        dayWheel.rollDown();
        weekDaysWheel.rollDown();
    }

    //Prints the wheels with the calender format
    public String toString() {
        return (weekDaysWheel.weekDay + " " + dayWheel.getValue() + " "+monthWheel.monthName()+", " + yearWheel.getValue());
    }
}
