package org.example;

public class Stock {
    private Long id;
    private Long serialNum;
    private String name;
    private String size;
    private String colorPattern;
    private String material;
    private Double price;
    private Integer qty;
    public Stock(){}

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", serialNum=" + serialNum +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", colorPattern='" + colorPattern + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public Stock (Long id, Long serialNum, String name, String size, String colorPattern, String material, Double price, Integer qty){
        this.id = id;
        this.serialNum = serialNum;
        this.name = name;
        this.size = size;
        this.colorPattern = colorPattern;
        this.material = material;
        this.price = price;
        this.qty = qty;
    }
    public Long getId(){return this.id;}
    public Long getSerialNum(){return this.serialNum;}
    public String getName(){return  this.name;}
    public String getSize(){return this.size;}
    public String getColorPattern(){return this.colorPattern;}
    public String getMaterial(){return this.material;}
    public Double getPrice(){return this.price;}
    public Integer getQty(){return this.qty;}


    public void setId(Long id){this.id=id;}
    public void  setSerialNum(Long serialNum){this.serialNum=serialNum;}
    public void setName(String name){this.name=name;}
    public void setSize(String size){this.size=size;}
    public void setColorPattern(String colorPattern){this.colorPattern=colorPattern;}
    public void setMaterial(String material){this.material=material;}
    public void setPrice(Double price){this.price=price;}
    public void setQty(Integer qty){this.qty=qty;}
}

