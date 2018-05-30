package com.raj.sample.camel.domain;

import org.springframework.stereotype.Component;

@Component
public class LineCountResponse {

	Integer cleuCount;
	Integer eleuCont;
	Integer totalCount;

	public Integer getCleuCount() {
		return cleuCount;
	}

	public void setCleuCount(Integer cleuCount) {
		this.cleuCount = cleuCount;
	}

	public Integer getEleuCont() {
		return eleuCont;
	}

	public void setEleuCont(Integer eleuCont) {
		this.eleuCont = eleuCont;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
