package iuh.fit.se.group1.util;

import iuh.fit.se.group1.dto.ExportResponse;
import iuh.fit.se.group1.network.Response;
import iuh.fit.se.group1.network.client.SocketFacade;
import iuh.fit.se.group1.network.client.service.ImportExportExcelServiceClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ExportUtil {
    public static byte[] exportTableToExcel(JTable table, String sheetName, boolean excludeLastColumn) throws Exception {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int rowCount = model.getRowCount();
        int colCount = model.getColumnCount();

        List<String> columns = new ArrayList<>();
        for (int i = 0; i < colCount; i++) {
            columns.add(model.getColumnName(i));
        }

        List<List<Object>> data = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            List<Object> row = new ArrayList<>();
            for (int j = 0; j < colCount; j++) {
                row.add(model.getValueAt(i, j));
            }
            data.add(row);
        }
        ImportExportExcelServiceClient importExportExcelServiceClient = SocketFacade.getInstance().getImportExportExcel();

        Response response = importExportExcelServiceClient.exportTableToExcel(
                columns,
                data,

                sheetName,
                excludeLastColumn
        );

        if (response.getCode() != 200) {
            JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + "nMessage: " + response.getMessage(), "Lỗi xuất Excel", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        ExportResponse exportResponse = (ExportResponse) response.getData();

        return exportResponse.getFileData();
    }
}
