package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDetailDTO implements Serializable {
    private BigDecimal unitPrice;

    private AmenityDTO amenity;
    private int quantity;
    private LocalDate createdAt;
}
