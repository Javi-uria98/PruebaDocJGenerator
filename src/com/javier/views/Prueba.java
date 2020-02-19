package com.javier.views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.docgene.help.JavaHelpFactory;
import org.docgene.help.gui.jfx.JFXHelpContentViewer;

import java.net.URL;

public class Prueba extends Application {

    private JFXHelpContentViewer viewer;

    private void initializeHelp(Stage stage)
    {
        try {
            URL url = this.getClass().getResource("/help/articles.zip");
            JavaHelpFactory factory = new JavaHelpFactory(url);
            factory.create();
            viewer = new JFXHelpContentViewer();
            factory.install(viewer);
            viewer.getHelpWindow(stage, "Help Content", 600, 700);
        }catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        initializeHelp(stage);
        VBox vBox=new VBox();
        Button btn=new Button("Ayuda");
        vBox.getChildren().add(btn);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewer.showHelpDialog(btn);
            }
        });
        Scene scene=new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
