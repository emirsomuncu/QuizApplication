package com.example.quizApplication.core.utilites.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	public ModelMapper forResponse();
	public ModelMapper forRequest();
}
