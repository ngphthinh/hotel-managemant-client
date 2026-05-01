package iuh.fit.se.group1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExportRequest implements Serializable {
    private List<List<Object>> data;
    private String title;
    private boolean excludeLastColumn;
    private List<String> columnHeaders;
}
