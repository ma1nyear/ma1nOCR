package com.tes.ma1n;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


import java.io.File;

public class HelloController {
    @FXML
    public TextArea output;
    @FXML
    public TextField lang;
    @FXML
    public Button btn;
    @FXML
    public ImageView image;


    public void change(MouseEvent mouseEvent) {
        FileChooser open = new FileChooser();
        File img = open.showOpenDialog(btn.getScene().getWindow());
        Image image1 = new Image(img.getAbsolutePath());
        image.setImage(image1);
    }

    public void convert(ActionEvent actionEvent) throws TesseractException {
        Image im = image.getImage();
        String ur = im.getUrl();
        System.out.println("Изображение:"+ur);
        File f = new File(ur);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata");
        tesseract.setLanguage(lang.getText());
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        String result = tesseract.doOCR(f);
        output.setText(result);

    }

}