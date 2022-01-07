package br.com.logamigo.logamigo.enums;

public enum TypeLogEnum {
    WARNING("Warning", "Atenção"),
    ERROR("Error", "Erro"),
    INFO("Info", "Informação"),
    SUCCESS("Success", "Sucesso");

    private final String descriptionEng;
    private final String descriptionPtBr;

    public String getDescriptionEng() {
        return descriptionEng;
    }

    public String getDescriptionPtBr() {
        return descriptionPtBr;
    }

    TypeLogEnum(String descriptionEng, String descriptionPtBr) {
        this.descriptionEng = descriptionEng;
        this.descriptionPtBr = descriptionPtBr;
    }
}
