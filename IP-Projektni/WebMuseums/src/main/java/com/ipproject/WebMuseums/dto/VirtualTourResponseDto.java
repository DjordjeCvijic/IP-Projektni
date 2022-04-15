package com.ipproject.WebMuseums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VirtualTourResponseDto {
	
	private Integer virtualTourId;
	private String name;
	private String startDateTime;
	private Integer duration;
	private String youtubeUrl;
	private boolean purchasedByUser;
	private boolean started;
}
