package pane;

import item.Book;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;

public class NewBookPane extends GridPane {
    public NewBookPane(){
        setPadding(new Insets(12));
        setVgap(8);
        TextField nameField = input();
        TextField authorField = input();
        TextField ratingField = input();
        TextField imageField = input();
        TextField descriptionField = input();
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(25);
        columnConstraints1.setHalignment(HPos.RIGHT);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setPercentWidth(75);
        columnConstraints2.setHalignment(HPos.RIGHT);
        Button addButton = new Button("Add");
        addButton.setMaxWidth(430);
        addButton.setPrefHeight(32);
        addButton.setTextFill(Color.WHITE);
        addButton.setBackground(Background.fill(Color.DARKCYAN));
        addButton.setOnMouseClicked(event -> {
            handleClick(nameField.getText(),authorField.getText(),ratingField.getText(),imageField.getText(),descriptionField.getText());
        });
        getColumnConstraints().addAll(columnConstraints1,columnConstraints2);
        add(label("Title: "), 0 , 0);
        add(label("Author: "), 0 , 1);
        add(label("Rating: "), 0 , 2);
        add(label("Image: "), 0 , 3);
        add(label("Description: "), 0 , 4);
        add(nameField,1,0);
        add(authorField,1,1);
        add(ratingField,1,2);
        add(imageField,1,3);
        add(descriptionField,1,4);
        add(addButton,0, 5, 2, 1);
    }

    private Text label(String s){
        Text t = new Text(s);
        t.setFont(new Font("Arial", 16));
        return t;
    }

    private TextField input(){
        TextField t = new TextField();
        t.setBackground(new Background( new BackgroundFill(Color.DARKCYAN,new CornerRadii(16), Insets.EMPTY)));
        return t;
    }

    private void handleClick(String name, String author, String rating, String image, String description){
        if(name.isEmpty() || author.isEmpty() || rating.isEmpty() || image.isEmpty() || description.isEmpty()){
            return;
        }else{
            Book book = new Book(name, author, rating, image, description);
            BookListPane.getInstance().getBooks().add(book);
            BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
            Goto.mainPage();
        }
    }

}
