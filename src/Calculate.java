import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Calculate {
    LocalDateTime startTime;
    LocalDateTime endTime;
    Robo robo;

    Calculate(LocalDateTime startTime, LocalDateTime endTime, Robo robo){
       this.startTime = startTime;
       this.endTime = endTime;
       this.robo = robo;
    }

    public long calculateFees(){
        long fees = 0;
        int workHours = 0;
        long eightHours = 8 * 60;
        if(startTime.isAfter(endTime)){
            return fees;
        }
        while(startTime.isBefore(endTime)){
            // if robot has worked for 8 hours take a break
            if(workHours == eightHours){
                workHours = 0;
                this.startTime = startTime.plusMinutes(60);

            // if robot has worked less than 8 hours
            } else {
                // weekend fees calculations
                if(startTime.getDayOfWeek() == DayOfWeek.SUNDAY || startTime.getDayOfWeek() == DayOfWeek.SATURDAY){
                    if(startTime.toLocalTime().equals(Robo.extraDayStart) || (startTime.toLocalTime().isAfter(Robo.extraDayStart) && startTime.toLocalTime().isBefore(Robo.extraDayEnd))){
                        fees += Robo.extraDayPrice;
                    } else {
                        fees += Robo.extraNightPrice;
                    }
                    this.startTime = startTime.plusMinutes(1);
                    workHours++;

                } else {
                    // weekday fee calculations
                    if(startTime.toLocalTime().equals(Robo.standardDayStart) || (startTime.toLocalTime().isAfter(Robo.standardDayStart) && startTime.toLocalTime().isBefore(Robo.standardDayEnd))){
                        fees += Robo.standardDayPrice;
                    } else {
                        fees += Robo.standardNightPrice;
                    }
                    this.startTime = startTime.plusMinutes(1);
                    workHours++;
                }
            }
        }
        return fees;
    }
}
