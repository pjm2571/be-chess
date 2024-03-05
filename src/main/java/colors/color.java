package colors;

public enum color {
    WHITE("white"),
    BLACK("black");

    private String colorType;

    color(String colorType) {
        this.colorType = colorType;
    }

    public String getColorType(){
        return colorType;
    }

}
