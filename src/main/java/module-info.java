module com.rplbo.project_akhir {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.rplbo.project_akhir to javafx.fxml;
    exports com.rplbo.project_akhir;
}