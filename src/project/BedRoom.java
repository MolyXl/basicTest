package project;

import java.util.List;

/**
 * @author MaZhuli
 * @description 卧室
 * @date 2019/6/27
 */
public class BedRoom {
    private Double longs;
    private Double widths;
    private Double floor;
    private Double ceiling;

    private List<Furniture> furnitureList;

    public Double getLongs() {
        return longs;
    }

    public void setLongs(Double longs) {
        this.longs = longs;
    }

    public Double getWidths() {
        return widths;
    }

    public void setWidths(Double widths) {
        this.widths = widths;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor;
    }

    public Double getCeiling() {
        return ceiling;
    }

    public void setCeiling(Double ceiling) {
        this.ceiling = ceiling;
    }

    public void addFurniture(Furniture furniture) {
        this.furnitureList.add(furniture);
    }

    public void removeFurniture(Furniture furniture) {
        this.furnitureList.remove(furniture);
    }
}
