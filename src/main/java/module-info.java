module com.rplbo.project_akhir {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    exports com.rplbo.project_akhir;           
    opens com.rplbo.project_akhir to javafx.fxml;
}