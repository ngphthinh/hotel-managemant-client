package iuh.fit.se.group1.util;

import iuh.fit.se.group1.dto.CustomerDTO;
import iuh.fit.se.group1.dto.EmployeeDTO;
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


//    public static byte[] exportTableToExcel(List<EmployeeDTO> data, List<String> columnHeaders, String sheetName) throws Exception {
//        ImportExportExcelServiceClient importExportExcelServiceClient = SocketFacade.getInstance().getImportExportExcel();
//
//        Response response = importExportExcelServiceClient.exportTableToExcel(
//                columnHeaders,
//                data,
//
//                sheetName,
//                false
//        );
//
//        if (response.getCode() != 200) {
//            JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + "nMessage: " + response.getMessage(), "Lỗi xuất Excel", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//
//        ExportResponse exportResponse = (ExportResponse) response.getData();
//
//        return exportResponse.getFileData();
//    }

    public static byte[] exportTableToExcelCustomer(List<CustomerDTO> dtos, String sheetName) throws Exception {


        List<String> columns = List.of(
                "Họ tên",
                "Giới tính",
                "Email",
                "CCCD",
                "SĐT",
                "Ngày sinh"
        );


        List<List<Object>> data = dtos.stream()
                .map(c -> {
                    List<Object> row = new ArrayList<>();
                    row.add(c.getFullName());
                    row.add(!c.isGender() ? "Nam" : "Nữ");
                    row.add(c.getEmail());
                    row.add("'" + c.getCitizenId());
                    row.add("'" + c.getPhone());
                    row.add(c.getDateOfBirth() != null ? c.getDateOfBirth().toString() : "");
                    return row;
                })
                .toList();
        ImportExportExcelServiceClient importExportExcelServiceClient = SocketFacade.getInstance().getImportExportExcel();

        Response response = importExportExcelServiceClient.exportTableToExcel(
                columns,
                data,

                sheetName,
                false
        );

        if (response.getCode() != 200) {
            JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + "nMessage: " + response.getMessage(), "Lỗi xuất Excel", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        ExportResponse exportResponse = (ExportResponse) response.getData();

        return exportResponse.getFileData();
    }

    public static byte[] exportTableToExcelEmployee(List<EmployeeDTO> dtos, String sheetName) throws Exception {


        List<String> columns = List.of(
                "Họ tên",
                "Giới tính",
                "Email",
                "CCCD",
                "SĐT",
                "Ngày vào làm",
                "Chức vụ"
        );


        List<List<Object>> data = dtos.stream()
                .map(e -> {
                    List<Object> row = new ArrayList<>();
                    row.add(e.getFullName());
                    row.add(!e.isGender() ? "Nam" : "Nữ");
                    row.add(e.getEmail());
                    row.add("'" + e.getCitizenId());
                    row.add("'" + e.getPhone());
                    row.add(e.getHireDate() != null ? e.getHireDate().toString() : "");

                    if (e.getAccount() != null && e.getAccount().getRole() != null) {
                        row.add(e.getAccount().getRole().getRoleName());
                    } else {
                        row.add("");
                    }

                    return row;
                })
                .toList();
        ImportExportExcelServiceClient importExportExcelServiceClient = SocketFacade.getInstance().getImportExportExcel();

        Response response = importExportExcelServiceClient.exportTableToExcel(
                columns,
                data,
                sheetName,
                false
        );

        if (response.getCode() != 200) {
            JOptionPane.showMessageDialog(null, "Server returned HTTP Status " + response.getCode() + "nMessage: " + response.getMessage(), "Lỗi xuất Excel", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        ExportResponse exportResponse = (ExportResponse) response.getData();

        return exportResponse.getFileData();
    }

}
