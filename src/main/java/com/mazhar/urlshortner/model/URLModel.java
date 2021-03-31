package com.mazhar.urlshortner.model;


import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class URLModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "url_short_id", nullable = false)
	private UUID id;
	private String longUrl;
	private String shortUrl;
	private String parameters;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	public URLModel(String longUrl, String shortUrl, String parameters) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
		this.parameters = parameters;
	}
}
