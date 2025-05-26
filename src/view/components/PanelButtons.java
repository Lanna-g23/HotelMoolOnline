package view.components;


import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PanelButtons extends HBox {
    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnUpdate = new Button("Atualizar");
    public Button btnDelete = new Button("Deletar");

    public PanelButtons() {
        //cadastro
        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));

        //update
        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));

        //delete
        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));

        ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        ImageView viewImgBtnDel = new ImageView(imgBtnDel);


        //cadastro
        viewImgBtnCad.setFitWidth(20); //Definição de largura
        viewImgBtnCad.setFitHeight(20); //Definição de altura

        //update
        viewImgBtnUp.setFitWidth(20);
        viewImgBtnUp.setFitHeight(20);

        //delete
        viewImgBtnDel.setFitWidth(20);
        viewImgBtnDel.setFitHeight(20);
        //viewImgBtnCad.setOpacity(0.5); //Definição de opacidade: 0.0 (invisível) - 1.0 (opaco)

        btnCadastrar.setGraphic(viewImgBtnCad);
        btnUpdate.setGraphic(viewImgBtnUp);
        btnDelete.setGraphic(viewImgBtnDel);

        //botão
        //Cadastrar
        btnCadastrar.setStyle("-fx-background-color: transparent; -fx-text-weight: bold;");

        //Update
        btnUpdate.setStyle("-fx-background-color: transparent; -fx-text-weight: bold;");

        //Delete
        btnDelete.setStyle("-fx-background-color: transparent; -fx-text-weight: bold;");


        setSpacing(10);

        //estilização dos botões
        String styleButton1 = "-fx-background-color: rgb(190,228,239);" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;" ; //Setar o cursor da mãozinha
        btnCadastrar.setStyle(styleButton1);

        String styleButton2 = "-fx-background-color: rgb(193,239,227);" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;" ; //Setar o cursor da mãozinha
        btnUpdate.setStyle(styleButton2);

        String styleButton = "-fx-background-color: rgb(239,199,196);" +
                "-fx-border-color: transparent;" +
                "-fx-graphic-text-gap: 10px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;" ; //Setar o cursor da mãozinha
        btnDelete.setStyle(styleButton);

        btnCadastrar.setOnMouseEntered(evento ->
                btnCadastrar.setStyle(styleButton1.replace("transparent", "#007E98FF")));
        btnCadastrar.setOnMouseExited(evento -> btnCadastrar.setStyle(styleButton1));

        btnUpdate.setOnMouseEntered(evento ->
                btnUpdate.setStyle(styleButton2.replace("transparent", "#048A6EFF")));
        btnUpdate.setOnMouseExited(evento -> btnUpdate.setStyle(styleButton2));

        btnDelete.setOnMouseEntered(evento ->
                btnDelete.setStyle(styleButton.replace("transparent", "#AC0600FF")));
        btnDelete.setOnMouseExited(evento -> btnDelete.setStyle(styleButton));



        getChildren().addAll(btnCadastrar, btnUpdate, btnDelete);

    }

}
