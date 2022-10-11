package com.jsfcourse.calc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class CalcBB {
	private String x;
	private String y;
	private String z;
	private Double result;

	@Inject
	FacesContext ctx;
	
	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public Double getResult() {
		return result;
	}

	public String calc() {
		try {
			double x = Double.parseDouble(this.x); //kwota kredytu
			double y = Double.parseDouble(this.y); //ilosc dni
			double z = Double.parseDouble(this.z); // oprocentowanie
			
			result = x + x* z* 0.01 / z;
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja zostala wykonana pomyslnie!", null));
			return "showresult"; 
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Blad!!!", null));
			return null; 
		}
				
	}

	public String info() {
		return "info"; 
	}
}
