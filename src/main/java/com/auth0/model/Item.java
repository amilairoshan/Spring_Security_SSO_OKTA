package com.auth0.model;

public class Item {

	private String itemId;
	private String itemName;
	private String noOfUnit;
	private String unitPrice;
	


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", noOfUnit=" + noOfUnit + ", unitPrice="
				+ unitPrice + "]";
	}
	public Item(ItemBuilder itemBuilder) {
		super();
		this.itemId = itemBuilder.itemId;
		this.itemName = itemBuilder.itemName;
		this.noOfUnit = itemBuilder.noOfUnit;
		this.unitPrice = itemBuilder.unitPrice;
	}
	public String getNoOfUnit() {
		return noOfUnit;
	}
	public void setNoOfUnit(String noOfUnit) {
		this.noOfUnit = noOfUnit;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public static class ItemBuilder 
    {
		private String itemId;
		private String itemName;
		private String noOfUnit;
		private String unitPrice;
 
        public ItemBuilder(String itemId) {
            this.itemId = itemId;
        }
        public ItemBuilder setName(String itemName) {
            this.itemName = itemName;
            return this;
        }
        public ItemBuilder setNoOfUnit(String noOfUnit) {
            this.noOfUnit = noOfUnit;
            return this;
        }
        public ItemBuilder setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }
        //Return the finally consrcuted Item object
        public Item build() {
        	Item item =  new Item(this);
            return item;
        }
      
    }
	
	
	
}
