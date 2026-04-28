package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EmployeeShiftDTO implements Serializable {
    private Long employeeShiftId;
    private EmployeeDTO employee;
    private ShiftDTO shift;
    private BigDecimal systemAmount;
    private BigDecimal actualAmount;
    private BigDecimal difference;
    private LocalDate shiftDate;
    private LocalDate createdAt;


}
