package dev.prometheus.exptracker;


import dev.prometheus.exptracker.utils.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Model {
    private String date = new Date().getFormattedDate();
    private double amount;
    private String description;
    private String paymentMethod;
    private String currency;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
