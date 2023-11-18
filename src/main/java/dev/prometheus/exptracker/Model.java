package dev.prometheus.exptracker;


import dev.prometheus.exptracker.utils.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "expenditure")
public class Model {
    private String date = new Date().getFormattedDate();
    private double amount;
    private String description;
    private String paymentMethod;
    private String currency;
}
