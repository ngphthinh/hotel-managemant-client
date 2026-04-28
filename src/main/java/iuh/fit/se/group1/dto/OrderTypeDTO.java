package iuh.fit.se.group1.dto;

import iuh.fit.se.group1.enums.OrderBookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderTypeDTO implements Serializable {
    private Long orderTypeId;
    private OrderBookStatus name;
}
