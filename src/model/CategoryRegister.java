package model;

import java.util.ArrayList;

public class CategoryRegister {
	private ArrayList<Category> categories = new ArrayList<Category>();
	
	
	public CategoryRegister() {
	}
	
	//Custom constructor
	public CategoryRegister(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public void addCategory(Category category) {
		categories.add(category);
	}
	public Category findCategory(String name) {
		for (Category tmp : categories) {
			if (tmp.getName().equals(name)) {
				return tmp;
			}
		}
		return null;
	}
	public Category deleteCategory(String categoryName) {
		Category category = this.findCategory(categoryName);
		categories.remove(category);
		return category;
	}
	public Category editCategory(String oldCategoryName, String newCategoryName) {
		Category category = this.findCategory(oldCategoryName);
		category.setName(newCategoryName);
		return category;
	}
}

