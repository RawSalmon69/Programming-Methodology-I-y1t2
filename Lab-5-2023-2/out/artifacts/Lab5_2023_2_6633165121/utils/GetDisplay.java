package utils;

import item.Book;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GetDisplay {
    public static Text Description(Book book, int fontSize, int wrappingWidth){
        Text description = new Text();
        description.setText(book.getDescription());
        description.setFont(new Font("Arial", fontSize));
        description.wrappingWidthProperty().setValue(wrappingWidth);
        return description;
    }

    public static ImageView image(Book book, int fitHeight){
        ImageView image = new ImageView();
        image.setImage(book.getImage());
        image.setPreserveRatio(true);
        image.setFitHeight(fitHeight);
        return image;
    }

    public static Text name(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment) {
        Text name = new Text();
        name.setText(book.getName());
        name.setFont(new Font("Arial", fontSize));
        name.wrappingWidthProperty().setValue(wrappingWidth);
        name.setTextAlignment(textAlignment);
        return name;
    }

    public static Text author(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment) {
        Text author = new Text();
        author.setFill(Color.GRAY);
        author.setText(book.getAuthor());
        author.setFont(new Font("Arial", fontSize));
        author.wrappingWidthProperty().setValue(wrappingWidth);
        author.setTextAlignment(textAlignment);
        return author;
    }

    public static Text stars(Book book, int fontSize) {
        Text stars = new Text();
        int starcount = book.getStars();
        stars.setText("\u2605".repeat(starcount) + "\u2606".repeat(5 - starcount));
        stars.setFont(new Font("Arial", fontSize));
        return stars;
    }
}
