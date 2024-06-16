/**
 *
 * @author Najiba Imam
 * date: March 23, 2024
 */

package coe528.project;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DisplayBox{

    // constructor
    public static void display(String title, String message) {
        Stage messageWindow = new Stage();

        // blocking events to other windows
        messageWindow.initModality(Modality.APPLICATION_MODAL);
        messageWindow.setTitle(title);
        messageWindow.setMinWidth(450);

        Label lblMessage = new Label(message);
        lblMessage.setFont(Font.font("Monoid", 18));
        lblMessage.setTextFill(Color.DARKRED);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> messageWindow.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lblMessage, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        // creating a scene and setting it in the window
        Scene scene = new Scene(layout);
        messageWindow.setScene(scene);

        // showing the window
        messageWindow.showAndWait();
    }

}