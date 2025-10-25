module inventory {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;

    opens com.pcl.inventory.controller to javafx.fxml;
    exports com.pcl.inventory;
}