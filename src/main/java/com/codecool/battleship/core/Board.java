class Board {

    private Square[][] ocean;

    public Board(int mapSize) {
        ocean = new Square[mapSize][mapSize];
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public void setOcean(int indexX, int indexY, Square value){
        ocean[indexX][indexY] = value;
    }
}