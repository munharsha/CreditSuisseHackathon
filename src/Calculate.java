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
        if(startTime.isAfter(endTime)){
            return fees;
        }
        while(startTime.isBefore(endTime)){
            if(workHours == 8){
                workHours = 0;
                this.startTime = startTime.plusHours(1);
            }
            if(startTime.getDayOfWeek() == DayOfWeek.SUNDAY || startTime.getDayOfWeek() == DayOfWeek.SATURDAY){
                if(startTime.toLocalTime().equals(Robo.extraDayStart) || (startTime.toLocalTime().isBefore(Robo.extraDayStart) && startTime.toLocalTime().isBefore(Robo.extraDayEnd))){
                    fees += Robo.extraDayPrice * 60;
                } else {
                    fees += Robo.extraNightPrice * 60;
                }
                this.startTime = startTime.plusHours(1);
            } else {
                if(startTime.toLocalTime().equals(Robo.standardDayStart) || (startTime.toLocalTime().isBefore(Robo.standardDayStart) && startTime.toLocalTime().isBefore(Robo.standardDayEnd))){
                    fees += Robo.standardDayPrice * 60;
                } else {
                    fees += Robo.standardNightPrice * 60;
                }
                this.startTime = startTime.plusHours(1);
            }
            System.out.println(startTime.toString());
        }
        return fees;
    }
}
