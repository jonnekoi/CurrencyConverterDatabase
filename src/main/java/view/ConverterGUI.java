package view;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConverterGUI extends Application {
    private TextField amountField = new TextField();
    private ChoiceBox<String> fromCurrency = new ChoiceBox<>();
    private ChoiceBox<String> toCurrency = new ChoiceBox<>();
    private Button convertButton = new Button("Convert");;
    private TextField resultField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        datasource.dbconn db = new datasource.dbconn();
        Controller controller = new Controller(db, this);
        VBox root = new VBox();
        Label amountLabel = new Label("Amount");
        Label fromLabel = new Label("From");
        Label toLabel = new Label("To");
        Label resultLabel = new Label("Result");

        fromCurrency.getItems().addAll("EUR", "USD", "GBP", "SEK", "JPY", "CAD");
        toCurrency.getItems().addAll("EUR", "USD", "GBP", "SEK", "JPY", "CAD");

        convertButton.setOnAction(event -> {
            resultField.setText(String.valueOf(controller.convertCurrencies()));
        });

        VBox amountBox = new VBox(amountLabel, amountField);
        VBox fromBox = new VBox(fromLabel, fromCurrency);
        VBox toBox = new VBox(toLabel, toCurrency);
        VBox resultBox = new VBox(resultLabel, resultField);

        resultField.setEditable(false);
        root.getChildren().addAll(amountBox, fromBox, toBox, resultBox, convertButton);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public String fromCurrency() {
        return fromCurrency.getValue();
    }

    public String toCurrency() {
        return toCurrency.getValue();
    }

    public double getAmount() {
        return Double.parseDouble(amountField.getText());
    }
}