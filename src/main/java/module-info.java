module com.tes.ma1n {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires tess4j;

    opens com.tes.ma1n to javafx.fxml;
    exports com.tes.ma1n;
}