public class Clock {
    
    private int day;
    private int hour;
    private int minute;
    private int second;

    public Clock(){
    }

    public Clock(int day, int hour, int minute, int second)
    {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getDay()
    {
        return day;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public int getSecond()
    {
        return second;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }
    
    public void increment(int seconds)
    {
        second += seconds;

        while(second >= 60)
        {
            minute += 1;
            second -= 60;
            while(minute >= 60)
            {
                hour += 1;
                minute -= 60;
                while(hour >= 24)
                {
                    day += 1;
                    hour -= 24;
                }
            }
        }
    }

    public int calculateTotalSeconds()
    {
        int totalseconds;

        totalseconds = (day * 86400) + (hour * 3600) + (minute * 60) + second;
        return totalseconds;
    }

    public static void main(String[] args) 
    {
        // Create elapsed time with the default values of zeros for day, hour,
        // minute and second.
        Clock t1 = new Clock(); // Default constructor
        // sets hour to 23
        t1.setHour(23);
        // sets day to 1
        t1.setDay(1);
        // sets minute to 59
        t1.setMinute(59);
        // sets day to 16
        t1.setSecond(16);
        // prints: 1:23:59:16
        System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
        // increments time t1 by 44 seconds:
        t1.increment(44);
        // prints: 2:0:0:0
        System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
        // prints the total elapsed time in seconds: 172,800
        System.out.printf("The elapsed time in seconds is: %d", t1.calculateTotalSeconds());
        // REPEAT SIMILAR TESTS FOR t2
        //Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
        Clock t2 = new Clock(3, 1, 4, 5);
        
        System.out.println();
        System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());   
        System.out.printf("The elapsed time in seconds is: %d", t2.calculateTotalSeconds());    
    }
}
