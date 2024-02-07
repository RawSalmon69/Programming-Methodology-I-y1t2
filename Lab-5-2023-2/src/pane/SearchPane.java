package pane;

import item.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class SearchPane extends HBox {
    public SearchPane(){
        setAlignment(Pos.CENTER);
        TextField textField = new TextField("Find the book");
        textField.setPrefWidth(250);
        Button button = new Button("Search");
        button.setBackground(Background.fill(Color.DARKCYAN));
        button.setTextFill(Color.WHITE);
        button.setOnAction( e-> {
            if(textField.getText().isEmpty()){
                BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
            }else{
                ArrayList<Book> books = new ArrayList<Book>();
                for(Book book : BookListPane.getInstance().getBooks())  {
                    if(book.getName().contains(textField.getText())){
                        books.add(book);
                    }
                }
                BookListPane.getInstance().setSearchedBooks(books);
            }
        });
        getChildren().addAll(textField, button);
    }
}
