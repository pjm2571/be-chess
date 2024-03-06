package colors;

public enum Colors {
    WHITE("white"),
    BLACK("black");

    private String colorType;

    Colors(String colorType) {
        this.colorType = colorType;
    }

    public String getColorType(){
        return colorType;
    }

}
