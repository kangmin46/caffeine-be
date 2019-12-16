package com.woowacourse.caffeine.application.dto;

<<<<<<< HEAD
=======
import com.woowacourse.caffeine.domain.Shop;

>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
public class MenuItemResponse {

    private final long id;
    private final String name;
<<<<<<< HEAD
    private final String description;
    private final int price;

    public MenuItemResponse(final long id, final String name, final String description, final int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
=======
    private final String nameInEnglish;
    private final String description;
    private final int price;
    private final String imgUrl;
    private final String category;
    private final Shop vendor;

    public MenuItemResponse(final long id, final String name, final String nameInEnglish, final String description, final int price, final String imgUrl, final String category, final Shop vendor) {
        this.id = id;
        this.name = name;
        this.nameInEnglish = nameInEnglish;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        this.vendor = vendor;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======
    public String getNameInEnglish() {
        return nameInEnglish;
    }

>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
<<<<<<< HEAD
=======

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public Shop getVendor() {
        return vendor;
    }
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
}
