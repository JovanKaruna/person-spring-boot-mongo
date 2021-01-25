package com.demo.base;

import java.io.Serializable;

public class Metadata implements Serializable {

	private int page = 0;
	private int size = 0;
	private Long totalItems;

	public Metadata() {
	}

	public Metadata(int page, int size, Long totalItems) {
		this.page = page;
		this.size = size;
		this.totalItems = totalItems;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	@Override
	public String toString() {
		return "Metadata{" + "page=" + page + ", size=" + size + ", totalItems=" + totalItems + '}';
	}
}
