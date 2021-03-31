package com.mazhar.urlshortner.model;



import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClickEventModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "click_event_id")
	private UUID id;
	private String browserName;
	private String deviceinfo;
	private String ipAddress;
	
	private Date clickTIme;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "url_short_id")
	private URLModel urlModel;
	
	public ClickEventModel(String browserName,String deviceinfo,String ipAddress, Date clickTIme ) {
		this.browserName = browserName;
		this.deviceinfo = deviceinfo;
		this.ipAddress = ipAddress;
		this.clickTIme = clickTIme;
	}
}
