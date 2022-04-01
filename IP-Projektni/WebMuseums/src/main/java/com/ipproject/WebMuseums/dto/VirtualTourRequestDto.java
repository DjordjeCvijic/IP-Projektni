package com.ipproject.WebMuseums.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VirtualTourRequestDto {
	
	private Integer virtualTourId;
	private LocalDateTime startDateTime;
	private Integer duration;
	private String youtubeUrl;
	private Integer museumId;

}
