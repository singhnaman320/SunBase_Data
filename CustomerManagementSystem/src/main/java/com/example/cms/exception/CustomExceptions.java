package com.example.cms.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomExceptions {

	 private LocalDateTime timeStamp;
	 private String message;
	 private String errorDetails;
}
