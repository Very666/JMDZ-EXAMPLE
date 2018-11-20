package com.gfyw.example.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class JsonResult {
 	@Getter
	@Setter
	private String status = null;
 	@Getter
	@Setter
	private Object result = null;
 
	public JsonResult status(String status) {
		this.status = status;
		return this;
	}
 
}
