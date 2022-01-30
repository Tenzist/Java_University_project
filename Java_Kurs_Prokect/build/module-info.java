module me.mum14k.mathkursach {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens me.mum14k.mathkursach to javafx.fxml;
    exports me.mum14k.mathkursach;
}