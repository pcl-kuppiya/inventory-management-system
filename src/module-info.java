module inventory {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.sql;
    requires jbcrypt;

    opens com.pcl.inventory.controller to javafx.fxml;
    exports com.pcl.inventory;
    exports com.pcl.inventory.view.tm;
}