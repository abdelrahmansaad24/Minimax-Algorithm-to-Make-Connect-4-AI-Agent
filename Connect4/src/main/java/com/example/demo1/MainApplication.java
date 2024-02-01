package com.example.demo1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Dialog<Results> dialog = getResultsDialog();
        Optional<Results> optionalResult = dialog.showAndWait();
        MainController controller = new MainController(Integer.parseInt(optionalResult.get().depth), optionalResult.get().method);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load());
        scene.getRoot().setStyle("-fx-background-color: #2d75dd;");
        stage.setTitle("Connect 4");
        stage.setScene(scene);
        stage.show();
    }

    private static Dialog<Results> getResultsDialog() {
        Dialog<Results> dialog = new Dialog<>();
        dialog.setTitle("Dialog Test");
        dialog.setHeaderText("Please specify Depth and Method…");
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField textField = new TextField("5");
        ObservableList<Method> options =
                FXCollections.observableArrayList(Method.values());
        ComboBox<Method> comboBox = new ComboBox<>(options);
        comboBox.getSelectionModel().selectFirst();
        dialogPane.setContent(new VBox(8, textField, comboBox));
        Platform.runLater(textField::requestFocus);
        dialog.setResultConverter((ButtonType button) -> {
            if (button == ButtonType.OK) {
                return new Results(textField.getText(), comboBox.getValue());
            }
            return null;
        });
        return dialog;
    }

    public static void main(String[] args) {
        launch();
    }

    private static class Results {
        String depth;
        Method method;
        public Results(String depth, Method method) {
            this.depth = depth;
            this.method = method;
        }
    }

    public static enum Method {AlphaBeta, Normal}


}