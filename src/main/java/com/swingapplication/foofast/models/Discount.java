package com.swingapplication.foofast.models;

import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    private long id;
    private int percent;
    private LocalDate start_date;
    private LocalDate end_date;
    private int is_active;

    @Override
    public String toString() {
        return "\n  [DISCOUNT]" + "\n" +
                "           id: " + this.id +"\n" +
                "           percent: " + this.percent +"\n"+
                "           start_date: " + this.start_date +"\n"+
                "           end_date: " + this.end_date +"\n"+
                "           is_active: "+ this.is_active;
    }


}
