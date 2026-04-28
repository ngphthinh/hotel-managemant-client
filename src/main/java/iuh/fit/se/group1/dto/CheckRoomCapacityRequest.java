package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckRoomCapacityRequest implements Serializable {
    private int adults;
    private int children;
    private int usedSingleRooms;
    private int usedDoubleRooms;
}