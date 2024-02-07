package utils;

import item.Book;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.NewBookPane;
import pane.RootPane;
import pane.SearchPane;

import java.util.ArrayList;

public class Goto {
    private static RootPane rootPane;

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    public static void clear(){
        if(!rootPane.getChildren().isEmpty() && rootPane.getChildren().size() < 2){
            return;
        }else{
            Node child = rootPane.getChildren().get(0);
            rootPane.getChildren().clear();
            rootPane.getChildren().add(child);
        }
    }
    public static void mainPage() {
        clear();
        ScrollPane scrollPane = new ScrollPane(BookListPane.getInstance());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane.getChildren().addAll(new SearchPane(), scrollPane);
    }

    public static Button backToMainPageButton(){
        Button backToMainPageButton = new Button("Back");
        backToMainPageButton.setStyle("-fx-border-color:darkcyan;" +
                "-fx-border-style:solid;" + "-fx-border-width:2px;");
        backToMainPageButton.setBackground(Background.fill(Color.WHITE));
        backToMainPageButton.setTextFill(Color.DARKCYAN);
        backToMainPageButton.setPrefWidth(300);

        backToMainPageButton.setOnMouseClicked(e -> {
            clear();
            mainPage();
        });
        return backToMainPageButton;
    }

    public static void bookPage(Book book){
        clear();
        Text name = GetDisplay.name(book, 28, 336, TextAlignment.CENTER);
        Text author = GetDisplay.author(book, 24, 336, TextAlignment.CENTER);
        author.setText("By " + author.getText());
        ImageView imageView = GetDisplay.image(book, 320);
        Text stars = GetDisplay.stars(book, 24);
        Text description = GetDisplay.Description(book, 18, 336);
        rootPane.getChildren().addAll(backToMainPageButton(), name, author, imageView, stars, description);
    }

    public static void addNewBookPage(){
        clear();
        rootPane.getChildren().addAll(backToMainPageButton(), new NewBookPane());
    }
}
