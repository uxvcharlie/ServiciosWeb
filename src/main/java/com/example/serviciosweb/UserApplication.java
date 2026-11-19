package com.example.serviciosweb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserApplication.class.getResource("users-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Usuarios API REST de supabase");
        stage.setScene(scene);
        stage.show();


    }
}
