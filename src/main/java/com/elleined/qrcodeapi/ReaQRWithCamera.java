package com.elleined.qrcodeapi;

import com.elleined.qrcodeapi.service.CodeService;
import com.github.sarxos.webcam.Webcam;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicReference;

public class ReaQRWithCamera extends Application {
    private ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();
    private ImageView ivCameraOutput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Center your QR Code in the Camera.");
        primaryStage.setScene(initializeUI());
        primaryStage.setHeight(500);
        primaryStage.setWidth(600);
        primaryStage.show();

        streamCamera();
    }


    private void streamCamera() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();

        Thread thread = new Thread(() -> {
            final AtomicReference<WritableImage> reference = new AtomicReference<>();
            BufferedImage image;
            while ((image = webcam.getImage()) != null) {
                try {
                    reference.set(SwingFXUtils.toFXImage(image, reference.get()));
                    image.flush();
                    Platform.runLater(() -> imageProperty.set(reference.get()));

                    String scanResult = CodeService.read(image);
                    System.out.println(scanResult);
                    if (scanResult != null) {
                        ivCameraOutput.imageProperty().unbind();
                        webcam.close();
                        this.stop();
                        break;
                    }
                } catch (Exception ignored) { }
            }
        });

        thread.setDaemon(true);
        thread.start();

        ivCameraOutput.imageProperty().bind(imageProperty);
    }


    private Scene initializeUI() {
        BorderPane root = new BorderPane();

        // Bottom controls
        FlowPane bottomBar = new FlowPane();
        bottomBar.setPrefHeight(56);
        bottomBar.setHgap(16);
        bottomBar.setVgap(16);
        bottomBar.setOrientation(Orientation.HORIZONTAL);
        bottomBar.setAlignment(Pos.CENTER);

        // Camera container
        BorderPane webCamPane = new BorderPane();
        webCamPane.setPrefHeight(500);
        webCamPane.setPrefWidth(600);
        webCamPane.setStyle("-fx-background-color: #CCC;");
        ivCameraOutput = new ImageView();
        webCamPane.setCenter(ivCameraOutput);

        // Setup image view for camera capture
        ivCameraOutput.setFitHeight(500);
        ivCameraOutput.setFitWidth(600);
        ivCameraOutput.prefHeight(500);
        ivCameraOutput.prefWidth(600);
        ivCameraOutput.setPreserveRatio(true);

        // Assembly ui
        root.setCenter(webCamPane);
        root.setBottom(bottomBar);
        return new Scene(root);
    }
}
