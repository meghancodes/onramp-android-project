package com.onramp.android.takehome.model.pets;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetObjects {

    @SerializedName("objects")
    @Expose
    private List<PetObject> objects = null;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public List<PetObject> getObjects() {
        return objects;
    }

    public void setObjects(List<PetObject> objects) {
        this.objects = objects;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}